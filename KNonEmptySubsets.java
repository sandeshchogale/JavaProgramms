package com.complexcity.test;

import java.util.ArrayList;
import java.util.List;

public class KNonEmptySubsets {
	//Input: nums=[4,3,2,3,5,2,1] k=4

    public List<List<Integer>> findSubsetsWithSum(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        findSubsetsWithSum(nums, k, 0, currentSubset, result);
        return result;
    }

    private void findSubsetsWithSum(int[] nums, int k, int startIndex, List<Integer> currentSubset, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(currentSubset)); // Found a subset with sum k
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (k - nums[i] >= 0) {
                currentSubset.add(nums[i]);
                findSubsetsWithSum(nums, k - nums[i], i + 1, currentSubset, result); // Recursively search for subsets
                currentSubset.remove(currentSubset.size() - 1); // Backtrack
            }
        }
    }

    public static void main(String[] args) {
    	KNonEmptySubsets solution = new KNonEmptySubsets();
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        List<List<Integer>> subsets = solution.findSubsetsWithSum(nums, k);

        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
	

}
