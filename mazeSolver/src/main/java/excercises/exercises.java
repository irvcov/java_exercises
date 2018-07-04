package excercises;

import java.util.Stack;

public class exercises {

    public static int validParenthesis(String doc){
        Stack<Character> stk = new Stack();

        int len =0;
        for(char c : doc.toCharArray()){
            if(c == '('){
                stk.push(c);
            } else {
                if (!stk.isEmpty())
                    stk.pop();
                else
                    return doc.length() - len;
            }
            len++;
        }

        return stk.size();
    }

    public static void main(String[] args) {

        String doc1 = "((()()))";
        String doc2 = "(()()))";
        String doc3 = "((()()";

        System.out.println(validParenthesis(doc1));
        System.out.println(validParenthesis(doc2));
        System.out.println(validParenthesis(doc3));

    }

}
