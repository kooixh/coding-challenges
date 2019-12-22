package com.kooixiuhong.challenges.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Solution for arrays based questions, Questions in README.md
 *
 */
public class ArraySolution {


    public int questionOne(int[] input) {

        Set<Integer> hashSet = new HashSet<>();

        for (int i : input) {
            if (hashSet.contains(i))
                return i;
            hashSet.add(i);
        }
        throw new IllegalArgumentException("Array does not contains duplicate");
    }
}
