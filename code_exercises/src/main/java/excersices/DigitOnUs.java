package excersices;

import java.util.*;
import java.util.stream.Collectors;

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

    public static class Movie {
        int rate;
        String title;

        public Movie(String title, int rate) {
            this.rate = rate;
            this.title = title;
        }

        public int getRate() {
            return rate;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return String.format("Title: %s, Rate: %s - ", this.title, this.rate);
        }
    }

    /**
     * https://dzone.com/articles/java-8-comparator-how-to-sort-a-list
     * https://www.concretepage.com/java/jdk-8/java-8-stream-sorted-example
     */
    public static void MoviesProcess(List<Movie> movies) {
        movies.sort(Comparator.comparing(Movie::getRate));
        printListMovies(movies);

        movies.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                return m1.getRate() > m2.getRate() ? -1 : 1;
            }
        });
        printListMovies(movies);

        movies.sort((m1, m2) -> {
            return m1.getRate() > m2.getRate() ? 1 : -1;
        });
        printListMovies(movies);

        printListMovies(movies.stream().sorted(Comparator.comparing(Movie::getRate, (m1, m2) -> {
            return m1 > m2 ? -1 : 1;
        })).collect(Collectors.toList()));

        printListMovies(movies.stream().sorted(Comparator.comparing(Movie::getTitle)).collect(Collectors.toList()));
        printListMovies(movies.stream().sorted(Comparator.comparing(Movie::getTitle)).map(movie1 -> {
            return new Movie(movie1.getTitle(), movie1.getRate()*2);
        }).collect(Collectors.toList()));

        printListMovies(movies.stream().filter(movie -> {
            return movie.getRate() == 3;
        }).collect(Collectors.toList()));

    }

    public static void printListMovies(List<Movie> movies) {
        movies.stream().forEach(movie1 -> {
            System.out.print(movie1.toString());
        });
        System.out.println("");
    }

    public String frequencySort(String s) {
        Map<Character, Integer> freqChars = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqChars.put(c,freqChars.getOrDefault(c,0)+1);
        }

        StringBuilder stb = new StringBuilder();
        freqChars.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue, (e1, e2) -> {
            return e1>e2 ? -1:1;
        })).forEach(e -> {
            for (int i=0; i<e.getValue(); i++) {
                stb.append(e.getKey());
            }
        });
        return stb.toString();
    }


    public static void main(String[] args) {
        FreqChar freqChar = exe2("I love javaalot");
        System.out.println(freqChar.getC() + " - " + String.valueOf(freqChar.getFreq()));

        System.out.println(" ");
        for (int i : exe1(new int[] {-1,0,8,9,0,2,0,3}))
            System.out.print(i);

        System.out.println("\n");
        System.out.println(exe4(2598));

        List<Movie> movies = new LinkedList<>();
        movies.add(new Movie("Pelicula4", 3));
        movies.add(new Movie("Peliculon23", 4));
        movies.add(new Movie("Pelicula11", 2));
        movies.add(new Movie("movie", 1));
        movies.add(new Movie("A que movie", 5));
        movies.add(new Movie("Pelicula1", 3));
        movies.add(new Movie("Pelicula1", -10));
        MoviesProcess(movies);

        Map<Integer, String> map = new HashMap<>();
        map.put(90, "Ashish");
        map.put(45, "Mahesh");
        map.put(15, "Mahesh");
        map.put(10, "Suresh");
        map.put(30, "Nilesh");
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(e -> {
            System.out.println(e.getKey());
        });
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach(e -> {
            System.out.println(e.getValue());
        });
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey, (e1,e2) -> {
            return e1>e2 ? 1:-1;
        }));

    }
}
