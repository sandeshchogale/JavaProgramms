package com.complexcity.test;

public class CommonSubsequenceLCS {
	//Input: text1= "abcde", text2="ace"
	//output= 3
	//Explanation: The longest common subsequence is "ace" and its length is 3.
	

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // Create a 2D array to store the length of the longest common subsequence
        int[][] dp = new int[m + 1][n + 1];

        // Fill in the dp array based on the characters in text1 and text2
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The length of the longest common subsequence is stored in dp[m][n]
        return dp[m][n];
    }

    public static void main(String[] args) {
    	CommonSubsequenceLCS solution = new CommonSubsequenceLCS();
        String text1 = "abcde";
        String text2 = "ace";
        int result = solution.longestCommonSubsequence(text1, text2);
        System.out.println("Length of the longest common subsequence: " + result); // Output: 3
    }
	

	
}
