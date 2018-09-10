package excersices;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int idxSum = 0;
        int idx = 0;
        int gSum = 0;
        Set<Integer> nums = new HashSet<>();
        for (int i=0; i<A.length; i++) {
            if (nums.contains(A[i])) {
                continue;
            } else {
                idx++;
                idxSum += idx;
                gSum += A[i];
            }
            nums.add(A[i]);
        }
        idx++;
        idxSum += idx;

        if (idxSum == gSum)
            return A.length;

        if (gSum < 0)
            return 1;

        return idxSum - gSum;
    }


    public int countNumOfCountries(int[][] A) {
        // write your code in Java SE 8
        int countries = 0;
        for(int i=0; i<A.length; i++){
            for(int j=0; j<A[0].length; j++){
                if (A[i][j] != 0) { // Where 0 is the number we use to Mark the Country as visited.
                    countries++;
                    int color = A[i][j];
                    markCountry(A, i, j, A[0].length, A.length, color);
                }
            }
        }

        return countries;
    }

    public void markCountry(int[][] A, int i, int j, int l, int r, int color) {
        if (j < l && i < r && j >= 0 && i >= 0 && A[i][j] == color) {
            A[i][j] = 0;  // Where 0 is the number we use to Mark the Country as visited.
        } else {
            return;
        }

        markCountry(A, i+1, j, l, r, color);
        markCountry(A, i-1, j, l, r, color);
        markCountry(A, i, j+1, l, r, color);
        markCountry(A, i, j-1, l, r, color);
    }

}