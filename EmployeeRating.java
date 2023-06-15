package com.test;

public class EmployeeRating {
    public static int evaluateEmployeeRating(int N, int[] workload) {
        int maxConsecutiveDays = 0;
        int currentConsecutiveDays = 0;
        
        for (int i = 0; i < N; i++) {
            if (workload[i] > 6) {
                currentConsecutiveDays++;
            } else {
                currentConsecutiveDays = 0;
            }
            
            if (currentConsecutiveDays > maxConsecutiveDays) {
                maxConsecutiveDays = currentConsecutiveDays;
            }
        }
        
        return maxConsecutiveDays;
    }
    
    public static void main(String[] args) {
        int N = 7;
        int[] workload = { 8, 6, 7, 9, 5, 10, 8 };
        int rating = evaluateEmployeeRating(N, workload);
        System.out.println("Employee rating: " + rating);
    }
}
