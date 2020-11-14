package com.kooixiuhong.challenges.arrays;

import com.kooixiuhong.challenges.arrays.extras.Node;

import java.util.HashMap;
import java.util.HashSet;
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
    public Node reverseALinkedList(Node head) {
        Node prev = null;
        while (head != null && head.next != null) {
            Node temp = head.next;
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

    
}
