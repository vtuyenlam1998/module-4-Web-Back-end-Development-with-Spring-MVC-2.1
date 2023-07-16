package com.example.final_test.payload;

import com.example.final_test.model.Country;
import lombok.*;

@Setter@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CityListDto {
    private Long id;
    private String name;
    private Country country;
}
