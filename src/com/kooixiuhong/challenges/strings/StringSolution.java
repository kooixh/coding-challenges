package com.kooixiuhong.challenges.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringSolution {

    /**
     *
     * Given two strings text1 and text2, return the length of their longest common subsequence.
     *
     * Ref: https://leetcode.com/problems/longest-common-subsequence/
     *
     * @param s1
     * @param s2
     * @return
     */
    public int longestCommonSubString(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

    /**
     *
     *
     * Given a string, find the length of the longest substring T that contains at most k distinct characters.
     *
     *
     * @param s
     * @param k
     * @return
     */
    public int longestSubstringKDistinct(String s, int k) {
        int maxLen = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCount.put(c, charCount.getOrDefault(c, 0 ) + 1);
            while (charCount.size() > k) {
                charCount.put(s.charAt(left), charCount.get(s.charAt(left)) - 1);
                if (charCount.get(s.charAt(left)) == 0) charCount.remove(s.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }


    /**
     *
     * A string S of lowercase English letters is given.
     * We want to partition this string into as many parts as possible so that each letter appears in at most one part,
     * and return a list of integers representing the size of these parts.
     *
     * @return
     */
    public List<Integer> partitionString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        List<Integer> ans = new ArrayList<>();
        int j = 0;
        int anc = 0;
        for (int i = 0; i < s.length(); i++) {
            j = Math.max(map.get(s.charAt(i)), j);
            if (j == i) {
                ans.add(j - anc + 1);
                anc = i + 1;
            }
        }
        return ans;

    }


}
