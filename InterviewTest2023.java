package com.test;

public class InterviewTest2023 {

	public static void main(String[] args) {
		test1();
		test2();	
		test3();
	}
	
	//find the pair of three array numbers sum should be zero //-1,1,0  -3 1 2
	public static void test1() {
		int[] arra1 = {-3,-1,1,0,2};
		int n = arra1.length;
		//OUTPUT=> pair of three preceding numbers sum should be zero //-1,1,0  -3 1 2
		boolean found = false;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arra1[i] + arra1[j] + arra1[k] == 0) {
                        System.out.println(arra1[i] + " "
                                           + arra1[j] + " "
                                           + arra1[k]);
                        found = true;
                    }
                }
            }
        }
	}

	//sort array using bubble sort algorithm
	public static void test2() {
		int temp;
		int[] arra1 = {5,10,1,100,40};
		for(int i=0; i< (arra1.length-1); i++ ) {
			for(int j=0; j < (arra1.length - i - 1); j++ ) {
				if(arra1[j] > arra1[j+1]) {
					temp =arra1[j];
					arra1[j] = arra1[j+1];
					arra1[j+1] = temp;
				}
			}
			
		}
		for(int k =0; k< arra1.length; k++) {
			System.out.println(arra1[k]);	
		}
		
		
	}
	
	//Split and find the empty element from the string and print non empty elements row from string 
	public static void test3() {
		
		String str ="1,2,4,,5";
		String[] arr= str.split(",");
		for(int i=0; i<arr.length;i++) {
			if(!arr[i].isEmpty()) {
				System.out.print(arr[i]);
			}
			
		}
	}

}
