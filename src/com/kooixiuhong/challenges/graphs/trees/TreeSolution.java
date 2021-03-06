package com.kooixiuhong.challenges.graphs.trees;

import com.kooixiuhong.challenges.graphs.trees.extras.BinaryTreeNode;
import com.kooixiuhong.commons.extras.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TreeSolution {


    /**
     *
     * Traverse a Binary tree by its level
     *
     * @param root
     * @return
     */
    public List<List<Integer>> binaryLevelOrderTraversal(BinaryTreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> current = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode n = q.poll();
                current.add(n.val);

                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);
            }
            ans.add(current);
        }
        return ans;

    }

    /**
     *
     *
     * Given a binary tree, write a function to get the maximum width of the given tree. The maximum width of a tree is
     * the maximum width among all levels.
     *
     * The width of one level is defined as the length between the end-nodes
     * (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes
     * are also counted into the length calculation.
     *
     *
     * @param root
     * @return
     */
    public int maxTreeWidth(BinaryTreeNode root) {
        Queue<Pair<BinaryTreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));
        int maxWidth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            Pair<BinaryTreeNode, Integer> head = q.peek();
            Pair<BinaryTreeNode, Integer> tail = null;
            for (int i = 0; i < size; i++) {
                tail = q.poll();
                BinaryTreeNode n = tail.getKey();
                if (n.left != null)
                    q.offer(new Pair<>(n.left, tail.getValue() * 2));
                if (n.right != null)
                    q.offer(new Pair<>(n.right, tail.getValue() * 2 + 1));
            }
            maxWidth = Math.max(maxWidth, tail.getValue() - head.getValue() + 1);
        }
        return maxWidth;
    }


    /**
     *
     * Given a binary tree, find its maximum depth.
     *
     * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     *
     * @param root
     * @return
     */
    public int maxDepth(BinaryTreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    /**
     *
     * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
     *
     * If two nodes are in the same row and column, the order should be from left to right.
     *
     * @param node
     * @return
     */
    public List<List<Integer>> verticalOrderTraversal(BinaryTreeNode node) {
        Map<Integer, List<Integer>> levelMap = new HashMap<>();

        Queue<Pair<BinaryTreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(node, 0));
        int min = 0;
        int max = 0;
        while (!q.isEmpty()) {
            Pair<BinaryTreeNode, Integer> p = q.poll();
            if (!levelMap.containsKey(p.getValue())) {
                levelMap.put(p.getValue(), new ArrayList<>());
            }
            levelMap.get(p.getValue()).add(p.getKey().val);
            if (p.getKey().left != null) {
                q.offer(new Pair<>(p.getKey().left, p.getValue() - 1));
                min = Math.min(min, p.getValue() - 1);
            }
            if (p.getKey().right != null) {
                q.offer(new Pair<>(p.getKey().right, p.getValue() + 1));
                max = Math.max(max, p.getValue() + 1);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            ans.add(levelMap.get(i));
        }
        return ans;

    }

    /**
     *
     *
     * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values
     * with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants.
     * The tree s could also be considered as a subtree of itself.
     *
     * @return
     */
    public boolean isSubTree(BinaryTreeNode s, BinaryTreeNode t) {
        return isSubTreeHelper(s, t, false);
    }

    public boolean isSubTreeHelper(BinaryTreeNode s, BinaryTreeNode t, boolean matching) {
        if (s == null && t == null) return true;
        if (s == null ^ t == null) return false;

        if (s.val == t.val) {
            boolean left = isSubTreeHelper(s.left, t.left, true);
            boolean right = isSubTreeHelper(s.right, t.right, true);
            return (left && right);
        }
        if (matching) return false;
        boolean left = isSubTreeHelper(s.left, t, false);
        if (left) return true;
        return isSubTreeHelper(s.left, t, false);
    }

    /**
     *
     *  Invert a binary tree
     *
     * @param node
     * @return
     */
    public BinaryTreeNode invertBinaryTree(BinaryTreeNode node) {
        if (node == null) return  null;
        invertBinaryTree(node.left);
        invertBinaryTree(node.right);
        BinaryTreeNode t = node.left;
        node.left = node.right;
        node.right = t;
        return node;
    }


}
