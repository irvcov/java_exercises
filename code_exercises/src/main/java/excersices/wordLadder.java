package excersices;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time.
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 Note:

 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 Example 1:

 Input:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]

 Output: 5

 Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.
 */
public class wordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!isEndWordOnList(wordList, endWord))
            return 0;

        int transformations = 1;
        List<List<String>> listOneShortest= new LinkedList<>();
        listOneShortest.add(listOneCharDiff(wordList, beginWord));
        List<List<String>> listOneShortestLeve2;
        List<String> result = new LinkedList<>();
        Set<String> wordTaked = new HashSet<>();
        wordTaked.add(beginWord);

        while (listOneShortest.size() != 0) {

            transformations++;
            listOneShortestLeve2 = new LinkedList<>();
            //System.out.println(transformations);

            for (List<String> listOnes : listOneShortest) {
                //System.out.println(listOnes);

                for (String wd : listOnes) {
                    if (wd.equals(endWord)) {
                        return transformations;
                    } else {
                        if (!wordTaked.contains(wd)) {
                            wordTaked.add(wd);
                            listOneShortestLeve2.add( listOneCharDiff(wordList, wd) );
                        }
                    }
                }

            }

            listOneShortest = listOneShortestLeve2;
        }

        return 0;
    }

    private boolean isEndWordOnList(List<String> wordList, String word) {
        for (String s : wordList) {
            if (s.equals(word))
                return true;
        }
        return false;
    }

    private List<String> listOneCharDiff(List<String> wordList, String word) {
        List<String> listOneShortest = new LinkedList<>();
        for (String s : wordList) {
            if ( isJustOneCharDiff(s, word) ) {
                listOneShortest.add(s);
            }
        }
        return listOneShortest;
    }

    private boolean isJustOneCharDiff(String word1, String word2) {
        int count = 0;
        for (int i=0; i<word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
            if (count > 1)
                return false;
        }
        if (count == 1)
            return true;
        else
            return false;
    }
}
