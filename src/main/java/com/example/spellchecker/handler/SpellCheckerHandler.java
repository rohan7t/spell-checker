package com.example.spellchecker.handler;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.spellchecker.SpellChecker;

@Component("spellCheckerHandler")
public class SpellCheckerHandler {

    @Autowired
    SpellChecker spellChecker;

    public List<String> spellCheck(String path) throws IOException {
	return spellChecker.spellCheck(path);
    }

}
