package com.codev.datastructures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.LinkedList;
import java.util.Queue;

public class TreeDS {

    private static final Logger log = LoggerFactory.getLogger(TreeDS.class);

    // ─────────────────────────────────────────
    // NODE — building block of a tree
    // Every node holds: a value + left child + right child
    // ─────────────────────────────────────────
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        log.info("========== BINARY TREE ==========");

        // --- Build a tree manually ---
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6

        TreeNode root = new TreeNode(1);
        root.left        = new TreeNode(2);
        root.right       = new TreeNode(3);
        root.left.left   = new TreeNode(4);
        root.left.right  = new TreeNode(5);
        root.right.right = new TreeNode(6);

        log.info("root           = {}", root.val);
        log.info("root.left      = {}", root.left.val);
        log.info("root.right     = {}", root.right.val);

        // ─────────────────────────────────────────
        // TRAVERSALS — 4 ways to visit every node
        // ─────────────────────────────────────────

        // 1. Inorder: Left → Root → Right
        // On a BST → gives sorted output
        log.info("--- Inorder (L → Root → R) ---");
        inorder(root);

        // 2. Preorder: Root → Left → Right
        log.info("--- Preorder (Root → L → R) ---");
        preorder(root);

        // 3. Postorder: Left → Right → Root
        log.info("--- Postorder (L → R → Root) ---");
        postorder(root);

        // 4. Level-order (BFS): level by level left to right — uses Queue
        log.info("--- Level-order (BFS) ---");
        levelOrder(root);

        // ─────────────────────────────────────────
        // COMMON TREE OPERATIONS
        // ─────────────────────────────────────────

        log.info("height         = {}", height(root));   // 3
        log.info("countNodes     = {}", countNodes(root)); // 6
        log.info("isLeaf(4)?     = {}", isLeaf(root.left.left));  // true
        log.info("isLeaf(2)?     = {}", isLeaf(root.left));       // false

        // ─────────────────────────────────────────
        // BINARY SEARCH TREE (BST)
        // Rule: left subtree < node < right subtree
        // ─────────────────────────────────────────
        log.info("========== BST ==========");

        TreeNode bst = null;
        bst = insert(bst, 5);
        bst = insert(bst, 3);
        bst = insert(bst, 7);
        bst = insert(bst, 1);
        bst = insert(bst, 4);
        bst = insert(bst, 6);
        bst = insert(bst, 8);

        //        5
        //       / \
        //      3   7
        //     / \ / \
        //    1  4 6  8

        log.info("--- BST Inorder (should be sorted) ---");
        inorder(bst);  // 1 2 3 4 5 6 7 8

        log.info("search(4)      = {}", search(bst, 4) != null ? "found" : "not found");
        log.info("search(9)      = {}", search(bst, 9) != null ? "found" : "not found");

        // ─────────────────────────────────────────
        // COMPLEXITY
        // All traversals      → O(n)
        // BST search/insert   → O(log n) balanced / O(n) worst case
        // Height              → O(n)
        // ─────────────────────────────────────────
    }

    // ─────────────────────────────────────────
    // TRAVERSAL METHODS
    // ─────────────────────────────────────────

    static void inorder(TreeNode node) {
        if (node == null) return;     // base case — always check null first
        inorder(node.left);
        log.info("inorder visit  = {}", node.val);
        inorder(node.right);
    }

    static void preorder(TreeNode node) {
        if (node == null) return;
        log.info("preorder visit = {}", node.val);
        preorder(node.left);
        preorder(node.right);
    }

    static void postorder(TreeNode node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        log.info("postorder visit= {}", node.val);
    }

    static void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            log.info("level-order    = {}", node.val);
            if (node.left  != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

    // ─────────────────────────────────────────
    // UTILITY METHODS
    // ─────────────────────────────────────────

    static int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    static int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    // ─────────────────────────────────────────
    // BST METHODS
    // ─────────────────────────────────────────

    static TreeNode insert(TreeNode node, int val) {
        if (node == null) return new TreeNode(val);   // place here
        if (val < node.val)
            node.left  = insert(node.left,  val);     // go left
        else if (val > node.val)
            node.right = insert(node.right, val);     // go right
        return node;
    }

    static TreeNode search(TreeNode node, int target) {
        if (node == null)          return null;    // not found
        if (target == node.val)    return node;    // found
        if (target < node.val)     return search(node.left,  target); // go left
        return                            search(node.right, target); // go right
    }
}
