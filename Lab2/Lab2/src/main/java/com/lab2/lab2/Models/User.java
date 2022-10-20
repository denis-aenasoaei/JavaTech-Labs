package com.lab2.lab2.Models;

import java.util.ArrayList;

public class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitialWord() {
        return initialWord;
    }

    public void setInitialWord(String initialWord) {
        this.initialWord = initialWord;
    }

    public ArrayList<String> getPermutatedWords() {
        return permutatedWords;
    }

    public void setPermutatedWords(ArrayList<String> permutatedWords) {
        this.permutatedWords = permutatedWords;
    }

    public User(String name, String initialWord) {
        this.name = name;
        this.initialWord = initialWord;
    }

    public String name;
    public String initialWord;
    public ArrayList<String> permutatedWords;
}
