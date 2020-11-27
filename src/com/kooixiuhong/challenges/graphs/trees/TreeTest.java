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


    private static void testMaximumTreeWidth() {
        System.out.println("Running maximum tree width tests...");
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(6);

        root.left.left = new BinaryTreeNode(7);
        root.left.right = new BinaryTreeNode(4);
        root.right.right = new BinaryTreeNode(1);

        int expected1 = 4;

        int actual1 = treeSolution.maxTreeWidth(root);
        System.out.print("test 1: ");
        verify(expected1, actual1);

        BinaryTreeNode root2 = new BinaryTreeNode(10);
        root2.left = new BinaryTreeNode(5);
        root2.right = new BinaryTreeNode(6);

        root2.left.left = new BinaryTreeNode(7);
        root2.left.left.left = new BinaryTreeNode(4);

        root2.right.right = new BinaryTreeNode(1);
        root2.right.right.right = new BinaryTreeNode(5);

        int expected2 = 8;

        int actual2 = treeSolution.maxTreeWidth(root2);
        System.out.print("test 2: ");
        verify(expected2, actual2);
    }


    private static void testMaximumTreeDepth() {
        System.out.println("Running maximum tree width tests...");
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(6);

        root.left.left = new BinaryTreeNode(7);
        root.left.right = new BinaryTreeNode(4);
        root.right.right = new BinaryTreeNode(1);

        int expected1 = 3;

        int actual1 = treeSolution.maxDepth(root);
        System.out.print("test 1: ");
        verify(expected1, actual1);

        BinaryTreeNode root2 = new BinaryTreeNode(10);
        root2.left = new BinaryTreeNode(5);
        root2.right = new BinaryTreeNode(6);

        root2.left.left = new BinaryTreeNode(7);
        root2.left.left.left = new BinaryTreeNode(4);

        root2.right.right = new BinaryTreeNode(1);

        int expected2 = 4;

        int actual2 = treeSolution.maxTreeWidth(root2);
        System.out.print("test 2: ");
        verify(expected2, actual2);
    }

    private static void testVerticalOrderTraversal() {
        System.out.println("Running maximum tree width tests...");
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(6);

        root.left.left = new BinaryTreeNode(7);
        root.left.right = new BinaryTreeNode(4);
        root.right.right = new BinaryTreeNode(1);

        List<List<Integer>> expected1 = new ArrayList<>();
        expected1.add(Collections.singletonList(7));
        expected1.add(Collections.singletonList(5));
        expected1.add(Arrays.asList(10, 4));
        expected1.add(Collections.singletonList(6));
        expected1.add(Collections.singletonList(1));

        List<List<Integer>> actual1 = treeSolution.verticalOrderTraversal(root);
        System.out.print("test 1: ");
        verify(expected1, actual1);

        BinaryTreeNode root2 = new BinaryTreeNode(10);
        root2.left = new BinaryTreeNode(5);
        root2.right = new BinaryTreeNode(6);

        root2.left.right = new BinaryTreeNode(4);
        root2.right.right = new BinaryTreeNode(1);
        root2.right.left = new BinaryTreeNode(7);

        List<List<Integer>> expected2 = new ArrayList<>();
        expected2.add(Collections.singletonList(5));
        expected2.add(Arrays.asList(10, 4, 7));
        expected2.add(Collections.singletonList(6));
        expected2.add(Collections.singletonList(1));

        List<List<Integer>> actual2 = treeSolution.verticalOrderTraversal(root2);
        System.out.print("test 2: ");
        verify(expected2, actual2);

        BinaryTreeNode root3 = new BinaryTreeNode(10);

        List<List<Integer>> expected3 = new ArrayList<>();
        expected3.add(Collections.singletonList(10));

        List<List<Integer>> actual3 = treeSolution.verticalOrderTraversal(root3);
        System.out.print("test 3: ");
        verify(expected3, actual3);

    }

    private static void testIsSubTree() {
        System.out.println("Running is sub tree tests...");
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(6);

        root.left.left = new BinaryTreeNode(7);
        root.left.right = new BinaryTreeNode(4);
        root.right.right = new BinaryTreeNode(1);

        BinaryTreeNode sub1 = new BinaryTreeNode(5);
        sub1.left = new BinaryTreeNode(7);
        sub1.right = new BinaryTreeNode(4);

        boolean actual1 = treeSolution.isSubTree(root, sub1);
        System.out.print("test 1: ");
        verify(true, actual1);

        BinaryTreeNode root2 = new BinaryTreeNode(10);
        root2.left = new BinaryTreeNode(5);
        root2.right = new BinaryTreeNode(6);

        root2.left.left = new BinaryTreeNode(7);
        root2.left.right = new BinaryTreeNode(4);
        root2.right.right = new BinaryTreeNode(1);

        BinaryTreeNode sub2 = new BinaryTreeNode(6);
        sub2.left = new BinaryTreeNode(7);
        sub2.right = new BinaryTreeNode(4);

        boolean actual2 = treeSolution.isSubTree(root2, sub2);
        System.out.print("test 2: ");
        verify(false, actual2);

        BinaryTreeNode root3 = new BinaryTreeNode(10);
        BinaryTreeNode sub3 = new BinaryTreeNode(10);
        boolean actual3 = treeSolution.isSubTree(root3, sub3);
        System.out.print("test 3: ");
        verify(true, actual3);

    }



}
