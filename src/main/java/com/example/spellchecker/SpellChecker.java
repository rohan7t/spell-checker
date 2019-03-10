package com.example.spellchecker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;


public class SpellChecker {
    private static final String DICTIONARY_FILE = "E:\\NYU_DRIVE_DATA\\GitHub\\App-Sec\\spell-checker\\src\\main\\resources\\dictionary.txt";
    Hashtable<String, String> dictionary;
    private String incorrectWords;

    public  SpellChecker(){
        this.incorrectWords = "";
    }

    public static void main(String[] args) {
        SpellChecker checker = new SpellChecker();
        String inputFile = "E:\\NYU_DRIV_DATA\\GitHub\\App-Sec\\spell-checker\\src\\main\\resources\\input.txt";
        checker.spellCheck(inputFile);
    }

    public String spellCheck(String inputFile) {
        dictionary = new Hashtable<String, String>();
        System.out.println("== Initializing ==");

        try {
            loadDictionary(DICTIONARY_FILE);

            BufferedReader inputFileReader = new BufferedReader(new FileReader(inputFile));
            System.out.println("Reading from: " + inputFile);

            // Reads input.txt and spell check
            while (inputFileReader.ready()) {
                String[] wordsToCheck = inputFileReader.readLine().split("\\s");
                for (String word : wordsToCheck) {
                   checkWord(word);
                }
            }
            inputFileReader.close();
        } catch (IOException e) {
                e.printStackTrace();
                //TODO: gracefully handel it
        }
        return incorrectWords;
    }

    private void loadDictionary(String dictionaryFile) throws IOException {
        BufferedReader dictionaryReader = new BufferedReader(new FileReader(dictionaryFile));
        System.out.println("Dictionary : " + dictionaryFile);
        // Reads dictionary.txt lines
        while (dictionaryReader.ready()) {
            String[] dictionaryWord = dictionaryReader.readLine().split("\\s");
            for (String s : dictionaryWord) {
                dictionary.put(s, s);
            }
        }
        dictionaryReader.close();
    }

    private void checkWord(String wordToCheck) {
        String word = wordToCheck.toLowerCase();    //not case sensitive
        if (dictionary.get(word) != null) {
            System.out.println("Correct word: " + word);
            //TODO
        } else {
            System.out.println("Incorrect:--------- " + word);
            this.incorrectWords = incorrectWords + word + ",";
            //TODO
        }
    }

}