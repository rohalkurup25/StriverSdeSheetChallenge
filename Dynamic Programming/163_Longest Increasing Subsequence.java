import java.util.*;
public class Solution {

	public static int longestIncreasingSubsequence(int arr[]) {   
   List<Integer> piles = new ArrayList<>(arr.length);
    for (int num : arr) {
        int pile = Collections.binarySearch(piles, num);
        if (pile < 0) pile = ~pile;
        if (pile == piles.size()) {
            piles.add(num);
        } else {
            piles.set(pile, num);
        }
    }
    return piles.size();
    }

    
}