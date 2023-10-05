package testitehtava2;

import java.util.Arrays;

public class SmallestGap {
	public static int findSmallestGap(int[] numbers) {
        if (numbers == null || numbers.length <= 2) {
            return 0;
        }
        
        boolean allSame = true;
        for(int i=1; i<numbers.length; i++) {
        	if(numbers[i] != numbers[i-1]) {
        		allSame=false;
        		break;
        	}
        }
        
        if(allSame) {
        	return 0;
        }

        Arrays.sort(numbers);

        int smallestGap = Integer.MAX_VALUE;

        for (int i = 1; i < numbers.length; i++) {
            int gap = numbers[i] - numbers[i - 1] - 1;
            if (gap < smallestGap) {
                smallestGap = gap;
            }
        }
        
        if (smallestGap < 0) {
            return 0; 
        }

        return smallestGap;
    }

    public static void main(String[] args) {
        int[] numbers1 = {1, 4, 10};
        int[] numbers2 = {4, 9, 7, 7, 7};
        int[] numbers3 = {1, 2, 3, 4, 5};
        
        int smallestGap1 = findSmallestGap(numbers1);
        int smallestGap2 = findSmallestGap(numbers2);
        int smallestGap3 = findSmallestGap(numbers3);

        System.out.println("Pienin ero taulukossa 1: " + smallestGap1);
        System.out.println("Pienin ero taulukossa 2: " + smallestGap2);
        System.out.println("Pienin ero taulukossa 3: " + smallestGap3);
    }

}
