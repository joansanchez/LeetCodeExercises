package medium.Problem438;

import java.util.*;

public class Problem438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagrams = new ArrayList<>();
        if (p.length() > s.length()) return anagrams;

        final char[] sArray = s.toCharArray();
        final char[] pArray = p.toCharArray();

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> pMap = new HashMap<>();

        for(int i = 0; i < p.length(); ++i){
            Integer valuePresent = pMap.getOrDefault(pArray[i], 0);
            pMap.put(pArray[i], ++valuePresent);
            valuePresent = sMap.getOrDefault(sArray[i], 0);
            sMap.put(sArray[i], ++valuePresent);
        }
        if(sMap.equals(pMap)){anagrams.add(0);}

        int firstPointer= 0;

        for(int secondPointer = p.length(); secondPointer < s.length(); ++ secondPointer){
            Integer valuePresent = sMap.getOrDefault(sArray[secondPointer], 0);
            sMap.put(sArray[secondPointer], ++valuePresent);
            valuePresent = sMap.getOrDefault(sArray[firstPointer], 0) - 1;
            if (valuePresent <= 0) sMap.remove(sArray[firstPointer]);
            else sMap.put(sArray[firstPointer], valuePresent);

            if(sMap.equals(pMap)){
                anagrams.add(firstPointer+1);
            }
            ++firstPointer;
        }
        return anagrams;
    }
}
