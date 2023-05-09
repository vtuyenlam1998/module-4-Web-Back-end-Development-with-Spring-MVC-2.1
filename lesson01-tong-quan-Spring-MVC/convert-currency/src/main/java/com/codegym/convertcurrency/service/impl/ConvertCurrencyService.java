package com.codegym.convertcurrency.service.impl;

import org.springframework.stereotype.Component;

@Component
public interface ConvertCurrencyService {
    double convertToVND(double USD,double rate);
}
