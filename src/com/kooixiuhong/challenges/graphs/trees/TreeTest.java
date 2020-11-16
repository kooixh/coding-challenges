package com.kooixiuhong.challenges.graphs.trees;

import com.kooixiuhong.challenges.graphs.trees.extras.BinaryTreeNode;
import com.kooixiuhong.commons.SolutionTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TreeTest extends SolutionTest {

    private static TreeSolution treeSolution = new TreeSolution();

    public static void run() throws InvocationTargetException, IllegalAccessException {
        System.out.println("Tree tests");
        Method[] methods = TreeTest.class.getDeclaredMethods();
        TreeTest tt = new TreeTest();
        for (Method method : methods) {
            if (!method.getName().equals("run"))
                method.invoke(tt);
        }

    }

    private static void testLevelOrderTraversal() {
        System.out.println("Running level order traversal tests...");
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(6);

        root.left.left = new BinaryTreeNode(7);
        root.left.right = new BinaryTreeNode(4);
        root.right.left = new BinaryTreeNode(1);

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Collections.singletonList(10));
        expected.add(Arrays.asList(5, 6));
        expected.add(Arrays.asList(7, 4, 1));

        List<List<Integer>> actual = treeSolution.binaryLevelOrderTraversal(root);
        System.out.print("test 1: ");
        verify(expected, actual);
    }

}
