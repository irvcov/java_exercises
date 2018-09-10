package excersices;

// Write a function that returns true if the brackets in a given string are balanced.
// The function must handle parens (), square brackets [], and curly braces {}.

import java.io.*;
import java.util.*;

class MyCode {
    public static void main (String[] args) {
        System.out.println("(a[0]+b[2c[6]]) {24 + 53}  passed:" + parensMatch("(a[0]+b[2c[6]]) {24 + 53}"));
        System.out.println("f(e(d))                    passed:" + parensMatch("f(e(d))"));
        System.out.println("[()]{}([])                 passed:" + parensMatch("[()]{}([])"));
        System.out.println("((b)                       passed:" + !parensMatch("((b)"));
        System.out.println("(c]                        passed:" + !parensMatch("(c]"));
        System.out.println("{(a[])                     passed:" + !parensMatch("{(a[])"));
        System.out.println("([)]                       passed:" + !parensMatch("([)]"));
        System.out.println(")(                         passed:" + !parensMatch(")("));
        System.out.println(" (empty)                   passed:" + parensMatch(""));
    }

    public static boolean parensMatch(String sentence){

        Stack<Character> stk = new Stack<>();

        for (char c : sentence.toCharArray()) {

            if (c == '(' || c == '[' || c == '{') {
                stk.push(c);
            }

            if (c == ')' || c == ']' || c == '}' ) {

                if (stk.isEmpty())
                    return false;

                char tmp = stk.pop();

                if (c == ')' && tmp != '(') {
                    return false;
                }
                if (c == ']' && tmp != '[') {
                    return false;
                }
                if (c == '}' && tmp != '{') {
                    return false;
                }

            }

        }

        if (stk.isEmpty())
            return true;
        return false;
    }

}

