package com.example.personalcomputer.service;

import java.util.SplittableRandom;

public interface CalculatorService {
    StringBuilder calculate(double firstOperand, double secondOperand, String operator);
}
