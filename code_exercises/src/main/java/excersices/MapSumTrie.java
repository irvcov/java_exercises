package excersices;

import java.util.HashMap;

/**
 Implement a MapSum class with insert, and sum methods.

 For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.

 For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.

 Example 1:

 Input: insert("apple", 3), Output: Null
 Input: sum("ap"), Output: 3
 Input: insert("app", 2), Output: Null
 Input: sum("ap"), Output: 5
 */
public class MapSumTrie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public MapSumTrie() {
        this.root = new TrieNode();
    }

    public boolean hasWord(String word){
        TrieNode cur = this.root;
        for(char c : word.toCharArray()) {
            if (!cur.children.containsKey(c))
                return false;
            cur = cur.children.get(c);
        }
        return cur.isEnd;
    }

    public void insert(String key, int val) {
        boolean wordExist = hasWord(key);
        TrieNode cur = this.root;
        for(char c : key.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                TrieNode newc = new TrieNode();
                cur.children.put(c, newc);
            }

            if (wordExist) {
                cur.children.get(c).val = val;
            } else {
                cur.children.get(c).val += val;
            }

            cur = cur.children.get(c);
        }
        cur.isEnd = true;
    }

    public int sum(String prefix) {
        int sum = 0;
        TrieNode cur = this.root;
        for(char c : prefix.toCharArray()) {
            if(!cur.children.containsKey(c))
                return 0;
            sum = cur.children.get(c).val;
            cur = cur.children.get(c);
        }
        return sum;
    }

    class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isEnd;
        int val;

        public TrieNode(){
            this.children = new HashMap();
            this.isEnd = false;
            this.val = 0;
        }
    }
}
