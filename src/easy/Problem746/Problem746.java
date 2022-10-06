package easy.Problem746;

public class Problem746 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 0) return 0;
        if(cost.length == 1) return cost[0];
        if(cost.length == 2) return Math.min(cost[0], cost[1]);

        int totalCost = 0;
        int iterator = 0;

        int firstMin = cost[0] + Math.min(cost[1], cost[2]);
        int secondMin = cost[1] + Math.min(cost[2], 3 < cost.length ? cost[3] : 0);
        if (firstMin < secondMin) {
            totalCost = cost[0];
            iterator = 0;
        } else {
            totalCost = cost[1];
            iterator = 1;
        }

        while (iterator < cost.length){
            if (iterator + 2 < cost.length){
                if(cost[iterator + 1] < cost[iterator + 2]){
                    totalCost += cost[iterator + 1];
                    ++iterator;
                }
                else {
                    totalCost += cost[iterator + 2];
                    iterator += 2;
                }
            }
            else{
                iterator += 2;
            }
        }
        return totalCost;
    }
}
