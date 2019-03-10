package com.example.spellchecker.handler;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component("spellCheckerHandler")
public class SpellCheckerHandler {

    public HashSet<String> fetchDictionaryWords(String path) {
        HashSet<String> words = new HashSet<String>();
        return words;
    }

    public List<String> spellCheck(String path) {
        List<String> errorWords = new ArrayList<String>();
        return errorWords;
    }

}
