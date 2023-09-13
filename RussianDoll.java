package com.complexcity.test;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDoll {
//Input: envelopes = [[5,4],[6,4],[6,7][2,3]]
	//output= 3
	//Explanation: The maximum number of envelopes you can Russian doll is 3
	//(2,3) => (5,4) => (6,4) => (6,7)
	//3,4,4,7
	//3
	//3,4
	//3,4
	//3,4,7 =3


    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        // Sort the envelopes by width and then by height
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1]; // If widths are the same, sort by decreasing height
                } else {
                    return a[0] - b[0]; // Otherwise, sort by increasing width
                }
            }
        });

        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxDolls = 1;

        // Calculate the longest increasing subsequence based on height
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxDolls = Math.max(maxDolls, dp[i]);
        }

        return maxDolls;
    }

    public static void main(String[] args) {
    	RussianDoll solution = new RussianDoll();
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int result = solution.maxEnvelopes(envelopes);
        System.out.println("Maximum number of Russian dolls: " + result); // Output: 3
    }
	

}
