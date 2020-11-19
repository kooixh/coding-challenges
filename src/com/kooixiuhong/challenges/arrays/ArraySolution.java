package com.kooixiuhong.challenges.arrays;

import com.kooixiuhong.challenges.arrays.extras.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * Solution for arrays based questions, Questions in README.md
 *
 */
public class ArraySolution {


    /**
     * Given an array find a duplicate element
     *
     * @param input
     * @return
     */
    public int findADuplicateInArray(int[] input) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i : input) {
            if (hashSet.contains(i))
                return i;
            hashSet.add(i);
        }
        throw new IllegalArgumentException("Array does not contains duplicate");
    }

    /**
     * Given a singly linked list reverse it and return the head
     *
     * @param
     * @return
     */
    public ListNode reverseALinkedList(ListNode head) {
        ListNode prev = null;
        while (head != null && head.next != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        head.next = prev;
        return head;
    }

    /**
     *
     * Given an unsorted array and int k, return {i, j} i <= j if there are two elements that adds up to k
     * return {-1,-1} otherwise
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] unsortedTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (map.containsKey(comp)) {
                int min = Math.min(map.get(comp), i);
                int max = Math.max(map.get(comp), i);
                return new int[]{min, max};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     *
     * Given the birth year and death year, find the year with most people alive, see Cracking The Coding Interview 16.10
     *
     * years 1900 - 2000
     *
     * @param birth
     * @param death
     * @return
     */
    public int livingPeople(int[] birth, int[] death) {
        int[] birthCount = new int[100];
        int[] deathCount = new int[100];
        int[] dp = new int[100];

        for (int i = 0; i < birth.length; i++) {
            birthCount[birth[i] - 1900]++;
            deathCount[death[i] - 1900]++;
        }

        dp[0] = birthCount[0] + deathCount[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + birthCount[i] + deathCount[i] - deathCount[i - 1];
        }

        int max = -1;
        int ans = -1;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
                ans = i;
            }
        }
        return ans + 1900;


    }

    /**
     *
     * Given an array, return indicies m, n such that if m - n is sorted then the array is sorted
     *
     * @param arr
     * @return
     */
    public int[] subSortArray(int[] arr) {
        if (arr.length == 0) return new int[] {0,0};

        int[] rightMin = new int[arr.length];
        int[] leftMax = new int[arr.length];
        leftMax[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i - 1]);
        }
        rightMin[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i +1]);
        }

        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > rightMin[i]) {
                start = i;
                break;
            }
        }
        int end = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < leftMax[i]) {
                end = i;
                break;
            }
        }

        return new int[]{start, end};

    }

    /**
     *
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and return its sum.
     *
     * Ref: https://leetcode.com/problems/maximum-subarray/
     *
     * @param arr
     * @return
     */
    public int subArrayWithMaxSum(int[] arr) {
        if (arr.length == 0) return 0;
        int sum = arr[0];
        int current = arr[0];
        for (int i = 1; i < arr.length; i++) {
            current = Math.max(current + arr[i], arr[i]);
            sum = Math.max(sum, current);
        }
        return sum;
    }


    /**
     *
     * Given an array of distinct integers candidates and a target integer target,
     * return a list of all unique combinations of candidates where the chosen numbers sum to target.
     *
     * Ref: https://leetcode.com/problems/combination-sum/
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> findCombinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        searchCombinationSum(nums, 0, 0, target, ans, new ArrayList<>());
        return ans;
    }

    private void searchCombinationSum(int[] nums, int i, int sum, int target, List<List<Integer>> ans, List<Integer> current) {
        if (sum == target) {
            ans.add(current);
            return;
        }
        if (sum > target || i >= nums.length) {
            return;
        }

        List<Integer> temp = new ArrayList<>(current);
        searchCombinationSum(nums, i + 1, sum, target, ans, temp);
        current.add(nums[i]);
        searchCombinationSum(nums, i, sum + nums[i], target, ans, current);

    }

    /**
     *
     * Given an array of n positive integers and a positive integer s,
     * find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
     *
     * Ref: https://leetcode.com/problems/minimum-size-subarray-sum/
     *
     * @return
     */
    public int subArraySumLessThanN(int[] nums, int s) {
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                minLen = Math.min(minLen, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
