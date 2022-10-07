package medium.Problem438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagrams = new ArrayList<>();
        if (p.length() > s.length()) return anagrams;
        int firstPointer= 0;
        for(int secondPointer = p.length()-1; secondPointer < s.length(); ++ secondPointer){
            if(isAnagram(s.substring(firstPointer, secondPointer+1), p)){
                anagrams.add(firstPointer);
            }
            ++firstPointer;
        }
        return anagrams;
    }

    private boolean isAnagram (String s, String p){
        final char[] string1 = s.toCharArray();
        Arrays.sort(string1);
        final char[] string2 = p.toCharArray();
        Arrays.sort(string2);
        return Arrays.equals(string1, string2);
    }
}
