package HackerRank.SwapNodes;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'swapNodes' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY indexes
     *  2. INTEGER_ARRAY queries
     */

    public static class Node{
        int data;
        int level;
        Node left,right;
        Node(int item)
        {
            data = item;
            left = null;
            right = null;
        }
    }

    public static Node constuctTree(List<List<Integer>> tree)
    {
        Node root = new Node(1);
        root.level = 1;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        for(int i=0;i<tree.size();i++)
        {
            List<Integer> currentNode = tree.get(i);
            Node left,right;
            if(currentNode.get(0)!=-1)
                left = new Node(currentNode.get(0));
            else
                left = null;
            if(currentNode.get(1)!=-1)
                right= new Node(currentNode.get(1));
            else
                right = null;

            Node temp = q.remove();
            temp.left = left;
            temp.right = right;

            if(left!=null){
                q.add(left);
                temp.left.level = temp.level + 1;
            }
            if(right!=null){
                q.add(right);
                temp.right.level = temp.level + 1;
            }
        }
        return root;
    }

    public static void swapLevels(Node root, int k){
        Queue <Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node actualNode = queue.poll();
            if(actualNode.level % k == 0){
                Node temp = actualNode.left;
                actualNode.left = actualNode.right;
                actualNode.right = temp;
            }
            if(actualNode.left != null) queue.add(actualNode.left);
            if(actualNode.right != null) queue.add(actualNode.right);
        }
    }

    public static List<Integer> inOrder(Node root){
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        result.addAll(inOrder(root.left));
        result.add(root.data);
        result.addAll(inOrder(root.right));
        return result;
    }

    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        //create root node and create tree from indexes
        Node root = constuctTree(indexes);

        List<List<Integer>> result = new ArrayList<>();
        //process the queries
        for(int i = 0; i < queries.size(); ++i){
            int k = queries.get(i);
            swapLevels(root, k);
            result.add(inOrder(root));
        }
        //swap levels
        //return in-order
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> indexes = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                indexes.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<List<Integer>> result = Result.swapNodes(indexes, queries);

        result.stream()
                .map(
                        r -> r.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                )
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

