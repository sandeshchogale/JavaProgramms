package com.complexcity.test;

public class HouseRobber {
//Example1
	//Input: nums =[1,2,3,1]
	//output: 4
	//Explanation: Rob house 1(money =1) and then rob house 3 (money =3). Total amount you can rob = 1 +3 + = 4.
	
//Example2
	//Input: nums = [2,7,9,3,1]
	//output: 12
	//Explanation: Rob house 1(money =2), rob house 3 (money =9) and rob house 5 (money = 1). 
	//Total amount you can rob = 2 + 9 + 1 = 12.
	
	//include
	//nums[i] + robRec(nums, i-2)
	
	//exclude
	//robRec(nums, i-1)

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        }

        // Create an array to store the maximum amount of money that can be robbed up to each house
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Calculate the maximum amount of money that can be robbed up to each house
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        // The maximum amount of money that can be robbed is the last element of the dp array
        return dp[n - 1];
    }

    public static void main(String[] args) {
    	HouseRobber solution = new HouseRobber();
        int[] nums = {1, 2, 3, 1};
        int result = solution.rob(nums);
        System.out.println("Maximum amount of money that can be robbed: " + result); // Output: 4
    }

	
}
