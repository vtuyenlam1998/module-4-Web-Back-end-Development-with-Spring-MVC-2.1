package com.example.final_test.service.city;

import com.example.final_test.model.City;
import com.example.final_test.payload.CityListDto;
import com.example.final_test.repository.CityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findByIsActiveTrue();
    }

    @Override
    public Optional<City> findById(Long id) throws Exception {
        Optional<City> city = cityRepository.findByIdAndIsActiveTrue(id);
        if (city.isEmpty()) {
            throw new Exception("city not found!");
        }
        return city;
    }

    @Override
    public void save(City city) {
        city.setIsActive(true);
        cityRepository.save(city);
    }

    @Override
    public void softDelete(Long id) {
        cityRepository.updateByIsActiveFalse(id);
    }

    @Override
    public List<CityListDto> getAll() {
        List<City> cityList = (List<City>) findAll();
        return cityList.stream().map(product -> modelMapper.map(product, CityListDto.class)).collect(Collectors.toList());
    }
}
