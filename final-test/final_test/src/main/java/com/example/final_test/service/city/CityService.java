package com.example.final_test.service.city;

import com.example.final_test.model.City;
import com.example.final_test.payload.CityListDto;
import com.example.final_test.service.GeneralService;

import java.util.List;

public interface CityService extends GeneralService<City> {
    List<CityListDto> getAll();
}
