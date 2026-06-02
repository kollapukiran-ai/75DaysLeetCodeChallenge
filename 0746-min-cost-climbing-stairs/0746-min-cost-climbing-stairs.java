class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int prev2 = cost[0];   // cost to reach step 0
        int prev1 = cost[1];   // cost to reach step 1

        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        // You can end on last step or second last step
        return Math.min(prev1, prev2);
    }
}
