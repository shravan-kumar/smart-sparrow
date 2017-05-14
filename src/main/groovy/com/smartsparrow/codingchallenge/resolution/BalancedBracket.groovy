package com.smartsparrow.codingchallenge.resolution

import com.smartsparrow.codingchallenge.exception.EmptyStringException

/**
 * Balanced Bracket program to look for whether all the bracket has been balanced in one string according or not
 */
class BalancedBracket {

    /**
     * The function to search all the open bracket as well as corresponding closing brackets from a string
     * @return Boolean value of whether all the brackets are balanced or not
     * @throws com.smartsparrow.codingchallenge.exception.EmptyStringException if the input is not recognised
     */
    public static Boolean checkBalancedBracket() {

        System.out.println("Please enter the string you would " +
                "like to check for balanced bracket")
        BufferedReader stdin = System.in.newReader()
        String expression = stdin.readLine()

        if (expression == "" || expression == null) {
            throw new EmptyStringException()
        }

        if ((expression.length() % 2) == 1) return false;
        else {
            Stack<Character> s = new Stack<>();
            for (char bracket : expression.toCharArray())
                switch (bracket) {
                    case '{': s.push('}'); break;
                    case '(': s.push(')'); break;
                    case '[': s.push(']'); break;
                    default :
                        if (s.isEmpty() || bracket != s.peek()) { return false;}
                        s.pop();
                }
            return s.isEmpty();
        }
    }
}
