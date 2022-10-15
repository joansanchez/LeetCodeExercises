package HackerRank.TreeLevelOrderTransversal;

import java.util.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node actual = queue.poll();
            result.add(actual.data);
            if(actual.left != null) queue.add(actual.left);
            if(actual.right != null) queue.add(actual.right);
        }

        result.stream().forEach(element -> {
            System.out.print(element + " ");
        });
    }
}

    //public static Node insert(Node root, int data) {
