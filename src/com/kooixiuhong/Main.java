package com.kooixiuhong;

import com.kooixiuhong.challenges.arrays.ArrayTest;
import com.kooixiuhong.challenges.graphs.GraphTest;
import com.kooixiuhong.challenges.graphs.trees.TreeTest;
import com.kooixiuhong.challenges.hashtable.HashTableTest;
import com.kooixiuhong.challenges.stacks.StackTest;
import com.kooixiuhong.commons.TestAggregator;

public class Main {

    public static void main(String[] args) {
        int returnCode = 0;
	    // TODO setup automated testing
        ArrayTest.run();
        StackTest.run();
        HashTableTest.run();
        TreeTest.run();
        GraphTest.run();
        returnCode = TestAggregator.aggregate();
        System.exit(returnCode);
    }
}
