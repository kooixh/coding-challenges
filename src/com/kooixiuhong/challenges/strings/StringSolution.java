package com.kooixiuhong.challenges.strings;

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
}
