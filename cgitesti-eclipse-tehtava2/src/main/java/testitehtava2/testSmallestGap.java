package testitehtava2;

import static org.junit.Assert.*;
import org.junit.Test;

public class testSmallestGap {

    @Test
    public void testFindSmallestGapWithValidInput() {
        int[] numbers1 = {1, 4, 10};
        int[] numbers2 = {4, 9, 7, 7, 7};
        int[] numbers3 = {1, 2, 3, 4, 5};
        
        int smallestGap1 = SmallestGap.findSmallestGap(numbers1);
        int smallestGap2 = SmallestGap.findSmallestGap(numbers2);
        int smallestGap3 = SmallestGap.findSmallestGap(numbers3);

        assertEquals(2, smallestGap1);
        assertEquals(0, smallestGap2);
        assertEquals(0, smallestGap3);
    }
    
    @Test
    public void testFindSmallestGapWithSameNumbers() {
        int[] numbers1 = {1, 4, 10};
        int[] numbers2 = {10, 1, 4};
        int[] numbers3 = {4, 10, 1};
        
        int smallestGap1 = SmallestGap.findSmallestGap(numbers1);
        int smallestGap2 = SmallestGap.findSmallestGap(numbers2);
        int smallestGap3 = SmallestGap.findSmallestGap(numbers3);

        assertEquals(2, smallestGap1);
        assertEquals(2, smallestGap2);
        assertEquals(2, smallestGap3);
    }
    
    @Test
    public void testFindSmallestGapWithSameNumberDistance() {
        int[] numbers1 = {1, 3, 5};
        int[] numbers2 = {1, 4, 7};
        int[] numbers3 = {1, 5, 9};
        
        int smallestGap1 = SmallestGap.findSmallestGap(numbers1);
        int smallestGap2 = SmallestGap.findSmallestGap(numbers2);
        int smallestGap3 = SmallestGap.findSmallestGap(numbers3);

        assertEquals(1, smallestGap1);
        assertEquals(2, smallestGap2);
        assertEquals(3, smallestGap3);
    }

    @Test
    public void testFindSmallestGapWithOneElement() {
        int[] numbers = {5};
        int smallestGap = SmallestGap.findSmallestGap(numbers);
        assertEquals(0, smallestGap);
    }
}

