package com.kooixiuhong.challenges.arrays;

import com.kooixiuhong.challenges.arrays.extras.Node;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Solution for arrays based questions, Questions in README.md
 *
 */
public class ArraySolution {


    public int findADuplicateInArray(int[] input) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i : input) {
            if (hashSet.contains(i))
                return i;
            hashSet.add(i);
        }
        throw new IllegalArgumentException("Array does not contains duplicate");
    }


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
}
