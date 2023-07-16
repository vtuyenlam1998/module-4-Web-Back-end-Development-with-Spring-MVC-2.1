package com.example.final_test.service.country;

import com.example.final_test.model.City;
import com.example.final_test.model.Country;
import com.example.final_test.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService{
    @Autowired
    private CountryRepository countryRepository;
    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findByIsActiveTrue();
    }

    @Override
    public Optional<Country> findById(Long id) throws Exception {
        Optional<Country> country = countryRepository.findByIdAndIsActiveTrue(id);
        if (country.isEmpty()) {
            throw new Exception("city not found!");
        }
        return country;
    }

    @Override
    public void save(Country country) {
        country.setIsActive(true);
        countryRepository.save(country);
    }

    @Override
    public void softDelete(Long id) {
        countryRepository.updateByIsActiveFalse(id);
    }
}
