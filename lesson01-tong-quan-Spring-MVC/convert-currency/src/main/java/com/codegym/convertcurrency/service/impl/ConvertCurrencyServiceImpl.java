package com.codegym.convertcurrency.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ConvertCurrencyServiceImpl implements ConvertCurrencyService{
    @Override
    public double convertToVND(double numberUSD,double rate) {
        return numberUSD*rate;
    }
}
