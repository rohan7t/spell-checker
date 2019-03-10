package com.example.spellchecker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component("spellChecker")
public class SpellChecker {
    private static final String DICTIONARY_FILE = "/static/dictionary.txt";
    Set<String> dictionary;

    public List<String> spellCheck(String inputFile) throws IOException {
	List<String> errorWords = new ArrayList<String>();
	dictionary = new HashSet<String>();
	System.out.println("== Initializing ==");

	try {
	    loadDictionary(DICTIONARY_FILE);
	    InputStream ipInput = SpellChecker.class.getResourceAsStream(inputFile);
	    if (ipInput == null) {
		throw new FileNotFoundException("Input file not found");
	    }
	    BufferedReader inputFileReader = new BufferedReader(new InputStreamReader(ipInput));
	    System.out.println("Reading from: " + inputFile);

	    // Reads input.txt and spell check
	    while (inputFileReader.ready()) {
		String[] wordsToCheck = inputFileReader.readLine().split("\\s");
		for (String word : wordsToCheck) {
		    String checkedWord = checkWord(word);
		    if (!checkedWord.isEmpty()) {
			errorWords.add(checkedWord);
		    }
		}
	    }
	    inputFileReader.close();
	} catch (IOException e) {
	    e.printStackTrace();
	    throw e;
	}
	return errorWords;
    }

    private void loadDictionary(String dictionaryFile) throws IOException {
	InputStream ipDictionary = SpellChecker.class.getResourceAsStream(DICTIONARY_FILE);
	BufferedReader dictionaryReader = new BufferedReader(new InputStreamReader(ipDictionary));
	System.out.println("Dictionary : " + dictionaryFile);
	// Reads dictionary.txt lines
	while (dictionaryReader.ready()) {
	    String[] dictionaryWord = dictionaryReader.readLine().split("\\s");
	    for (String s : dictionaryWord) {
		dictionary.add(s);
	    }
	}
	dictionaryReader.close();
    }

    private String checkWord(String wordToCheck) {
	StringBuilder result = new StringBuilder();
	if (wordToCheck != null) {
	    String word = wordToCheck.toLowerCase(); // not case sensitive
	    if (dictionary.contains(word)) {
		System.out.println("Correct word: " + word);
		return result.toString();
	    } else {
		result.append(word);
		return result.toString();
	    }
	}
	return result.toString();
    }

}