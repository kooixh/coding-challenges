package com.kooixiuhong.challenges.graphs.trees;

import com.kooixiuhong.challenges.graphs.trees.extras.BinaryTreeNode;
import com.kooixiuhong.commons.extras.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

}
