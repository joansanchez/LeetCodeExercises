package HackerRank.BalancedBrackets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        char[] input = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char element : input){
            if(element == '(' || element == '{' || element == '[') stack.add(element);
            else{
                if(stack.isEmpty()) return "NO";
                Character lastElement = stack.peek();
                if(element == ')' && lastElement == '(') stack.pop();
                else if(element == '}' && lastElement == '{') stack.pop();
                else if(element == ']' && lastElement == '[') stack.pop();
                else return "NO";
            }
        }
        if(!stack.isEmpty()) return "NO";
        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
