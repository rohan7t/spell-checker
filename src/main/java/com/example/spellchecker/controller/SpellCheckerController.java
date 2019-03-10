package com.example.spellchecker.controller;

import java.util.HashSet;
import java.util.List;

import com.example.spellchecker.SpellChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spellchecker.handler.SpellCheckerHandler;

@RestController
public class SpellCheckerController {

    private static final String ERROR_OCCURRED = "An error occurred. Please try again\n";

    @Autowired
    SpellCheckerHandler spellChekerHandler;

    @PostMapping("/loadDictionary")
    @ResponseBody
    public HashSet<String> loadDictionary(@RequestParam String path) {
	if (path == null || path.length() == 0) {
//	    return new HttpClientErrorException(ERROR_OCCURRED);
	    return null;
	}
	return spellChekerHandler.fetchDictionaryWords(path);
    }

    @PostMapping("/spellCheck")
    public List<String> spellCheck(@RequestParam String path) {
	if (path == null || path.length() == 0) {
//	    return new HttpClientErrorException(ERROR_OCCURRED);
        SpellChecker spellChecker = new SpellChecker();
        spellChecker.spellCheck("E:\\NYU_DRIV_DATA\\GitHub\\App-Sec\\spell-checker\\src\\main\\resources\\input.txt");
	    return null;
	}
	return spellChekerHandler.spellCheck(path);
    }

}
