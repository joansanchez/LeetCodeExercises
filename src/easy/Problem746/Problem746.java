package easy.Problem746;

public class Problem746 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 0) return 0;
        if(cost.length == 1) return cost[0];
        if(cost.length == 2) return Math.min(cost[0], cost[1]);

        int iterator = cost.length - 3;
        while (iterator >= 0){
            cost[iterator] = cost[iterator] + Math.min(cost[iterator + 1], cost[iterator + 2]);
            --iterator;
        }
        return Math.min(cost[0], cost[1]);
    }
}
