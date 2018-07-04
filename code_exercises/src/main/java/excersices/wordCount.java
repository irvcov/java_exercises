package excersices;

import java.util.*;

public class wordCount {

    /**
     *
     * Word Count Engine
     Implement a document scanning function wordCountEngine, which receives a string document and returns a list of all unique words in it and their number of occurrences, sorted by the number of occurrences in a descending order. If two or more words have the same count, they should be sorted according to their order in the original sentence. Assume that all letters are in english alphabet. You function should be case-insensitive, so for instance, the words “Perfect” and “perfect” should be considered the same word.

     The engine should strip out punctuation (even in the middle of a word) and use whitespaces to separate words.

     Analyze the time and space complexities of your solution. Try to optimize for time while keeping a polynomial space complexity.

     Examples:

     input:  document = "Practice makes perfect. you'll only
     get Perfect by practice. just practice!"

     output: [ ["practice", "3"], ["perfect", "2"],
     ["makes", "1"], ["youll", "1"], ["only", "1"],
     ["get", "1"], ["by", "1"], ["just", "1"] ]
     *
     * @param document
     * @return
     */
    static String[][] wordCountEngine(String document) {
        document = document.toLowerCase();
        Map<String, Integer> wordsCounts = new HashMap<>();
        Map<String, Integer> wordsindex = new HashMap<>();
        document = document.replaceAll("[-@#!$%^&*()_+|~=`{}\\[\\]:;'<>?,.\\/]","");
        String[] words = document.split(" ");

        int index=0;
        for(String wd : words) {
            if(wd.length() < 1){
                continue;
            } else if(wordsCounts.containsKey(wd)){
                wordsCounts.put(wd, wordsCounts.get(wd.toLowerCase()) + 1);
            } else {
                wordsCounts.put(wd, 1);
                wordsindex.put(wd, index);
                index++;
            }
        }

        Map<Integer, List<String[]>> wordsFreqAsKey = new HashMap<>();
        for (String kwd : wordsCounts.keySet()) {
            String[] tmpArr = new String[2];
            tmpArr[0] = kwd;
            tmpArr[1] = String.valueOf(wordsindex.get(kwd));
            List<String []> tmpList =
                    wordsFreqAsKey.getOrDefault(wordsCounts.get(kwd), new LinkedList<String []>());
            tmpList.add(tmpArr);
            wordsFreqAsKey.put(wordsCounts.get(kwd), tmpList);
        }

        String[][] arrayr = new String[wordsCounts.size()][];
        int i = 0;
        for(Integer freq : wordsFreqAsKey.keySet()) {
            List<String []> tmpList = wordsFreqAsKey.get(freq);
            Collections.sort(tmpList, (o1, o2) -> {
                return Integer.valueOf(o1[1]) - Integer.valueOf(o2[1]);
            });
            for(String [] tmparr : tmpList){
                String [] tmparr2 = new String[2];
                tmparr2[0] = tmparr[0];
                tmparr2[1] = String.valueOf(wordsCounts.get(tmparr[0]));
                arrayr[i] = tmparr2;
                i++;
            }
        }

        Arrays.sort(arrayr, (o1, o2) -> {
            return Integer.valueOf(o2[1]) - Integer.valueOf(o1[1]);
        });
        return arrayr;
    }

    public static void print2DArray(String[][] array){
        System.out.println("[");
        for (String[] tmpArr : array) {
            System.out.print("[" + "'"+tmpArr[0]+"', " + "'"+tmpArr[1]+"'" + "]");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        String document = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
        wordCountEngine(document);
    }

}
