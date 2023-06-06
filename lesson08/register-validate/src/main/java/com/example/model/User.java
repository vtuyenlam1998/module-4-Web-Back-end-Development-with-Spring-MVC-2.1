package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Không để trống nha")
    @Size(min = 2, max = 25, message = "từ 5 tới 45 thôi")
    private String firstName, lastName;

    //    @NotBlank
//    @Size(min=5,max=45)
//    private String lastName;
    @Pattern(regexp =
            "^(0|84)(2(0[3-9]|1[0-6|8|9]|2[0-2|5-9]|3[2-9]|4[0-9]|5[1|2|4-9]|6[0-3|9]|7[0-7]|8[0-9]|9[0-4|6|7|9])|3[2-9]|5[5|6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])([0-9]{7})$", message = "chỉ chấp nhận từ 10 - 11 số và có thể đầu 84")
    private String phoneNumber;

    @Min(value = 18, message = "Đã đủ 18 chưa đó bồ?")
    private int age;

    @Email(message = "Không đúng định dạng")
    private String email;

}
