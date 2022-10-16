package HackerRank.contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static class Node {
        private static int NUMBER_OF_CHARACTERS = 26;
        Node[] children = new Node[NUMBER_OF_CHARACTERS];
        int size = 0;

        private int getCharIndex(char c) {
            return c - 'a';
        }

        private Node getNode(char c){
            return children[getCharIndex(c)];
        }

        private void setNode(char c, Node child){
            children[getCharIndex(c)] = child;
        }

        private void add(String s){
            add(s, 0);
        }

        private void add(String s, int index){
            size++;
            if(index == s.length()) return;
            char current = s.charAt(index);
            Node child = getNode(current);
            if(child == null){
                child = new Node();
                setNode(current, child);
            }
            child.add(s, index + 1);
        }

        public int find(String s){
            return find(s, 0);
        }

        private int find(String s, int index){
            if(index == s.length()) return size;
            char current = s.charAt(index);
            Node child = getNode(current);
            if(child == null){
                return 0;
            }
            return child.find(s, index+1);
        }
    }
    /*
     * Complete the 'contacts' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_STRING_ARRAY queries as parameter.
     */

    public static List<Integer> contacts(List<List<String>> queries) {
        Node root = new Node();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < queries.size(); ++i){
            List<String> opperation = queries.get(i);
            if(opperation.get(0).equals("add")) root.add(opperation.get(1));
            else {
                results.add(root.find(opperation.get(1)));
            }
        }
        return results;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> queries = new ArrayList<>();

        IntStream.range(0, queriesRows).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.contacts(queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

