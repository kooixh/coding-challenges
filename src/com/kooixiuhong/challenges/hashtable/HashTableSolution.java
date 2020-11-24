package com.kooixiuhong.challenges.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

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

    /**
     *
     *
     * Given a non-empty list of words, return the k most frequent elements.
     *
     * Your answer should be sorted by frequency from highest to lowest.
     * If two words have the same frequency, then the word with the lower alphabetical order comes first.
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequentWords(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        Queue<String> q = new PriorityQueue<>((a, b) -> {
            if (map.get(a) == map.get(b)) return a.compareTo(b);
            return -(map.get(a) - map.get(b));
        });


        for (String s : map.keySet()) {
            q.offer(s);
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(q.poll());
        }
        return ans;

    }






}
