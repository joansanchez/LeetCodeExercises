package easy.Problem1;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> values = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            Integer val = values.get(target - nums[i]);
            if(val != null){
                return new int[]{val, i};
            }
            values.put(nums[i], i);
        }
        return new int[0];
    }
}
