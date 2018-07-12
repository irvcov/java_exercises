package excersices;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Exercise 3
 * Write a program to read a multiple line text file and write the 'N' longest lines to the output console,
 * where the file to be read is specified as command line aruguments.
 * The program should read an input file.
 * The first line should contain the value of the number 'N' followed by multiple lines.
 * 'N' should be a valid positive integer.
 */
public class TextFileWriteNlongest {

    private Scanner sc = null;
    private int N;
    private Map<Integer, List<String>> linesSizesMap;

    public TextFileWriteNlongest(String path) {
        this.linesSizesMap = new HashMap<>();

        try {
            this.sc = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (!this.sc.hasNextLine())
            return;

        getNnumber();
        fillMapLines();
    }

    private void getNnumber() {
        String numberNline = this.sc.nextLine();
        String[] numberNlineArr = numberNline.split(" ");
        this.N = Integer.valueOf(numberNlineArr[1]);
    }

    private void fillMapLines() {
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (this.linesSizesMap.containsKey(line.length())){
                this.linesSizesMap.get(line.length()).add(line);
            } else {
                List<String> lineList =  new LinkedList<String>();
                lineList.add(line);
                this.linesSizesMap.put(line.length(), lineList);
            }
        }
    }

    public void printNLongestLines() {
        if (this.linesSizesMap.size() == 0) {
            System.out.println("No lines on File!");
            return;
        }

        List<Integer> keyList = new ArrayList<>(this.linesSizesMap.keySet());
        Collections.sort(keyList);
        int longestKey = keyList.get(keyList.size()-1);
        int i=0;
        for (String line : this.linesSizesMap.get(Integer.valueOf(longestKey))) {
            if (this.N <= i)
                return;
            System.out.println(line);
            i++;
        }
    }

    public static void main(String[] args) {
        TextFileWriteNlongest textFileWriteNlongest =
                new TextFileWriteNlongest("/Users/icovarrubias/test.txt");
        textFileWriteNlongest.printNLongestLines();
    }
}
