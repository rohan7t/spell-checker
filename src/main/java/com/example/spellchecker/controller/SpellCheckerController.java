package com.example.spellchecker.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spellchecker.handler.SpellCheckerHandler;

@RestController
public class SpellCheckerController {

    private static final String PATH = "/error";
    @Autowired
    SpellCheckerHandler spellChekerHandler;

    @PostMapping("/spellCheck")
    public List<String> spellCheck(@RequestParam String path) throws IOException {
	if (path == null || path.isEmpty() || !path.endsWith(".txt")) {
	    throw new IOException("Given path is not valid");
	}
	try {
	    return spellChekerHandler.spellCheck(path);
	} catch (Exception e) {
	    throw new IOException(e);
	}
    }

//    @RequestMapping(value = PATH)
//    public String error() throws IOException {
//	throw new IOException("Wrong endpoint accessed");
//    }
//
//    @Override
//    public String getErrorPath() {
//	return PATH;
//    }

}
