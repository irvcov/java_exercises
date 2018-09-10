package excersices;

import java.util.*;
import java.util.stream.Collectors;

public class facebook {

    /*
    Given a list of Contacts, where each contact consists of a contact ID and a list of email IDs.
    Output a unique list of contacts by removing duplicates. Two contacts are considered to be the same,
    if they share at least one email ID.
     */
    public static List<String> listOfContacts(Map<String, List<String>> contactsMap) {
        Map<String, String> emailsMap = new HashMap<>();

        List<String> contactKey = new LinkedList<>(contactsMap.keySet());
        for (String contact : contactKey) {
            for (String email : contactsMap.get(contact)) {
                if (!emailsMap.containsKey(email)) {
                    emailsMap.put(email, contact);
                } else {
                    String toRemove = emailsMap.get(email);
                    if (!toRemove.equals(contact)) {
                        contactsMap.remove(toRemove);
                        contactsMap.remove(contact);
                    }
                }
            }
        }

        return new LinkedList<>(contactsMap.keySet());
    }

    /*
    * Given an integer, print an English phrase that describes the integer (eg, "Two hundred and thirty four", “One Thousand, Two Hundred and Thirty Four”)
     */
    public static String englishNumberFromInt(int number) {

        Map<Integer, String> numberStringDict = new HashMap<>();
        numberStringDict.put(0,"zero");
        numberStringDict.put(1,"one");
        numberStringDict.put(2,"two");
        numberStringDict.put(3,"three");
        numberStringDict.put(4,"four");
        numberStringDict.put(5,"five");
        numberStringDict.put(6,"six");
        numberStringDict.put(7,"seven");
        numberStringDict.put(8,"eigth");
        numberStringDict.put(9,"nine");
        numberStringDict.put(10,"ten");
        numberStringDict.put(11,"eleven");
        numberStringDict.put(12,"twelve");
        numberStringDict.put(13,"thirdteen");
        numberStringDict.put(14,"fourteen");
        numberStringDict.put(15,"fiveteen");
        numberStringDict.put(16,"sixteen");
        numberStringDict.put(17,"seventeen");
        numberStringDict.put(18,"eigthteen");
        numberStringDict.put(19,"nineteen");
        numberStringDict.put(20,"thewnty");
        numberStringDict.put(30,"thirty");
        numberStringDict.put(40,"foury");
        numberStringDict.put(50,"fifthty");
        numberStringDict.put(60,"sixty");
        numberStringDict.put(70,"seventy");
        numberStringDict.put(80,"eithty");
        numberStringDict.put(90,"ninety");
        numberStringDict.put(100,"hundred");
        numberStringDict.put(1000,"Thousand");
        numberStringDict.put(1000000,"million");
        numberStringDict.put(1000000000,"billion");

        if (number < 21) {
            return numberStringDict.get(number);
        }

        int multiply = 10, powTo = 0;
        StringBuilder num = new StringBuilder(String.valueOf(number));
        List<String> numStr = new LinkedList<>();
        num.reverse();
        for (char c : num.toString().toCharArray()) {
            Integer key = (int) Math.pow(multiply, powTo);

            Integer k = Character.getNumericValue(c);
            if (key < 10) {
                numStr.add(numberStringDict.get(k));
            } else if (key > 10 && key < 100) {
                numStr.add(numberStringDict.get(new Integer(k*key)));
            } else {
                numStr.add(numberStringDict.get(key));
                numStr.add(numberStringDict.get(k));
            }

            if (key > 1000) {
                numStr.add(",");
            }
            numStr.add(" ");

            powTo++;
        }

        Collections.reverse(numStr);
        return numStr.stream().collect(Collectors.joining(" ")).toString();
    }


    /**
     * You are given n points (x1, y1), (x2, y2), ..... (xm, ym) of a two dimensional graph.
     * Find 'n' closest points to (0,0) [ n <= m ].
     * Euclidean distance can be used to find the distance between 2 points.
     * @param points
     */
    private static void nearestTo00(int[][] points) {
        //Eucledian distance is given as dist((x, y), (a, b)) = √(x - a)² + (y - b)²
        double dist = Double.MAX_VALUE;
        int x = 0, y = 0;
        for(int[] point: points) {
            double currentDist = Math.sqrt(Math.pow(0-point[0],2) + Math.pow(0-point[1],2));
            if(currentDist < dist) {
                dist = currentDist;
                x = point[0];
                y = point[1];
            }
        }
        System.out.println("Nearest Number: {" + x + " " + y + "}");
    }

    /**
     * Given a list of integers, return the largest product that can be made by multiplying any three integers.
     For example, if the list is [-10, -10, 1, 2, 5], we should return 500, since that's -10 * -10 * 5.
     You can assume the list has at least three integers.
     */
    public static int largestProductByMul3ints(int[] array){
        if (array.length < 3) {
            return 0;
        }

        int maxProduct = 0;
        int i1 = 0, i2 = 1, i3 = 2;
        for (int s = 0; s<3; s++) {
            for (int i = 0; i<=array.length-3; i++) {
                if (s == 0) {
                    i3+=i;
                } else if (s == 1) {
                    i3+=i; i2+=i;
                } else {
                    i1+=i; i2+=i; i3+=i;
                }
                System.out.println(String.format("i1:%s, i2:%s, i3:%s", i1,i2,i3));
                int product = array[i1] * array[i2] * array[i3];
                if (product > maxProduct) {
                    maxProduct = product;
                }
                i1 = 0; i2 = 1; i3 = 2;
            }
        }

        return maxProduct;
    }


    public static void main(String[] args) throws Exception {
        Map<String, List<String>> contacts = new HashMap<>();
        List<String> lista1 = new LinkedList<>();
        lista1.add("felipe@gmail.com");
        lista1.add("felipe@msn.com");
        contacts.put("Felipe", lista1);

        List<String> lista2 = new LinkedList<>();
        lista2.add("andres@gmail.com");
        lista2.add("andres@msn.com");
        contacts.put("andres", lista2);

        List<String> lista3 = new LinkedList<>();
        lista3.add("ir@gmail.com");
        lista3.add("ir@msn.com");
        lista3.add("felipe@gmail.com");
        contacts.put("ir", lista3);

        List<String> lista4 = new LinkedList<>();
        lista4.add("fede@gmail.com");
        lista4.add("fede@msn.com");
        contacts.put("fede", lista4);

        //System.out.println(contacts);
        System.out.println(listOfContacts(contacts));

        System.out.println("-------------------");
        System.out.println(englishNumberFromInt(540));
        System.out.println(englishNumberFromInt(40));
        System.out.println(englishNumberFromInt(5));
        System.out.println(englishNumberFromInt(54680));

        System.out.println("-------------------");
        int[][] points = {{1,2}, {4,5}, {-1,3}, {0,1}};
        nearestTo00(points);

        System.out.println(largestProductByMul3ints(new int[]{-10, -10, 1, 2, 5}));
        System.out.println(largestProductByMul3ints(new int[]{-10, -10, 1, 2, 5, 6, 4}));
        System.out.println(largestProductByMul3ints(new int[]{-10, -10, 1, 2, 5, 6, -14}));
    }

}
