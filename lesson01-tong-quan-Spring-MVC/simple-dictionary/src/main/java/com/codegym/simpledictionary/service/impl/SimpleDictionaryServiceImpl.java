package com.codegym.simpledictionary.service.impl;

import com.codegym.simpledictionary.service.SimpleDictionaryService;

import java.util.HashMap;
import java.util.Map;

public class SimpleDictionaryServiceImpl implements SimpleDictionaryService {
    private static final Map<String,String> dictionary = new HashMap<>();
    static {
        dictionary.put("Dog","con chóoo");
        dictionary.put("Cat","con cặt");
        dictionary.put("Dragon","con rồng lộn");
        dictionary.put("Horse","con ngựa bà");
        dictionary.put("Thailand","con Thái Dúi");
    }
    @Override
    public String searchTranslateWord(String word) {
        if (dictionary.containsKey(word)) {
            String translate = dictionary.get(word);
            return translate;
        }
        return null;
    }
}
