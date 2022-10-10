package medium.Problem424;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Problem424 {
    public int characterReplacement(String s, int k) {
        if(s.length() == 1) return 1;
        final char[] chars = s.toCharArray();
        Map<Character, Integer> frequency = new HashMap<>();
        int longerSentence = 1;
        int l = 0;
        for(int r = 0; r < s.length(); ++r){
            Integer value = frequency.getOrDefault(chars[r], 0);
            frequency.put(chars[r], ++value);

            while((r - l + 1 - Collections.max(frequency.values()))> k){
                value = frequency.get(chars[l]) - 1;
                if (value == 0) frequency.remove(chars[l]);
                else frequency.put(chars[l], value);
                ++l;
            }

            longerSentence = Math.max(longerSentence, r - l + 1);

        }
        return longerSentence;
    }
}
