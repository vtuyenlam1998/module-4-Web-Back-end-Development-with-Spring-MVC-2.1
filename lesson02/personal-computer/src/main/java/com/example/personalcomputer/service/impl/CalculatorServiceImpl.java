package com.example.personalcomputer.service.impl;

import com.example.personalcomputer.service.CalculatorService;

public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public StringBuilder calculate(double firstOperand, double secondOperand, String operator) {
        StringBuilder message = new StringBuilder("Kết quả: " + firstOperand + " " + operator + " " + secondOperand + " = ");
        double result = 0;
        switch (operator) {
            case "addition":
                 result = firstOperand + secondOperand;
            case "subtraction":
                result = firstOperand - secondOperand;
            case "multiplication":
                result = firstOperand * secondOperand;
            case "division":
                result = firstOperand / secondOperand;
        }
        message.append(result);
        return message;
    }
}
