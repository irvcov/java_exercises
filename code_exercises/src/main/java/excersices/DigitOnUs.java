package excersices;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Find the first names and last names of all the employees managed by james anderson’s manager.
 * SELECT first_name, last_name FROM employees WHERE manager_id=1;
 * Assuming James Anderson has an id of 1 on the manager tables.
 *
 * Find how many employees are managed by each manager
 * SELECT count(employee_id) FROM employees WHERE manager_id=1 UNION
 * SELECT count(employee_id) FROM employees WHERE manager_id=2
 *
 * Assuming just 2 Managers
 * Assuming James Anderson has an id of 1 on the manager tables.
 * Assuming other manager has an id of 2 on the manager tables.
 *
 * or we can group by
 *
 * SELECT count(employee_id),manager_id FROM employees GROUP BY manager_id
 */
public class DigitOnUs {

    /*
    Exercise 1:
    Move zeros such that the non-zero integers in an array are moved
    to the beginning(in order) and the zeros towards the end of the array.

    [-1,0,8,9,0,2,0,3] --> [-1,8,9,2,3,0,0,0]
    */
    public static int[] exe1(int[] arr){  // Solution O(n) in time and constant in Memory
        int nzeros=0;

        for (int i=0; i<arr.length; i++) {
            arr[i-nzeros] = arr[i];
            if (arr[i] == 0) {
                nzeros++;
            }
        }
        for (int i=arr.length-1; i>arr.length-nzeros-1; i--) {
            arr[i] = 0;
        }

        return arr;
    }

    /*
    Exercise 2:
    Find the most number of occurences of a character in a string.
    String text = I love javaalot
    Answer:  a – 3
    */
    static class FreqChar {
        private char c;
        private int freq;

        public FreqChar() {
            this.c = ' ';
            this.freq = 0;
        }

        public char getC() {
            return c;
        }

        public void setC(char c) {
            this.c = c;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }
    }

    public static FreqChar exe2(String text) {  // Solution O(n) in time and O(n) in memory
        FreqChar freqChar = new FreqChar();
        Map<Character, Integer> cFreq = new HashMap<>();
        for (Character c : text.toCharArray()) {
            cFreq.put(c, cFreq.getOrDefault(c, 0)+1);
        }

        int max = 0;
        for (Character c : cFreq.keySet()) {
            if (cFreq.get(c) > max) {
                max = cFreq.get(c);
                freqChar.setC(c);
                freqChar.setFreq(max);
            }

        }
        return freqChar;
    }

    /*
    Exercise 4
    Below example shows how to find out sum of each digit in the given number using recursion logic.

    For example, if the number is 259, then the sum should be 2+5+9 = 16.
    */
    public static int exe4(int num) {
        int sum=0;
        if (num < 10)
            return num;
        sum += num%10;
        return sum + exe4(num/10);
    }


    public static void main(String[] args) {
        FreqChar freqChar = exe2("I love javaalot");
        System.out.println(freqChar.getC() + " - " + String.valueOf(freqChar.getFreq()));

        System.out.println(" ");
        for (int i : exe1(new int[] {-1,0,8,9,0,2,0,3}))
            System.out.print(i);

        System.out.println("\n");
        System.out.println(exe4(2598));

    }
}
