package com.kooixiuhong.challenges.hashtable;

import java.util.HashMap;
import java.util.Map;

public class HashTableSolution {

    /**
     *
     *
     * Given a book with words, find the frequency a word appears in the book. See Cracking The Coding Interview 16.2
     *
     * @param words
     * @param word
     * @return
     */
    public int wordFrequency(String[] words, String word) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String w : words) {
            wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);
        }
        return wordMap.getOrDefault(word, 0);
    }



}
