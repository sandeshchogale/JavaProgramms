package com.complexcity.test;

public class MinCostClimbingStairs {
//Input: cost = [10,15,20]
	//output: 15
	//Explanation; Ypu will start at index 1.
	//Pay 15 and climb two steps to reach the top. The total cost is 15.
	
	
	//Example2
	//Input: cost = [1,100,1,1,1,100,1,1,100,1]
	//output: 6
	//Explanation: You will start at index 0.
	//Pay 1 and climb two steps to reach index 2.
	//Pay 1 and climb two steps to reach index 4.
	//Pay 1 and climb two steps to reach index 6.
	//Pay 1 and climb one steps to reach index 7.
	//Pay 1 and climb two steps to reach index 9.
	//Pay 1 and climb one steps to reach the top.
	
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }

    public static void main(String[] args) {
    	MinCostClimbingStairs solution = new MinCostClimbingStairs();
        int[] cost = {10, 15, 20};
        int result = solution.minCostClimbingStairs(cost);
        System.out.println("Minimum cost to climb to the top: " + result); // Output: 15
    }

}
