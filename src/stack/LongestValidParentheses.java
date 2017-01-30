package com.practice.queueandstack;

/**
 * Created by pankajtripathi on 12/18/16.
 */

import java.util.Stack;

/**
 * Input: str = "(()()"

 Initialize result as 0 and stack with one item -1.

 For i = 0, str[0] = '(', we push 0 in stack

 For i = 1, str[1] = '(', we push 1 in stack

 For i = 2, str[2] = ')', currently stack has [-1, 0, 1], we pop
 from the stack and the stack now is [-1, 0] and length of current
 valid substring becomes 2 (we get this 2 by subtracting stack top
 from current index).
 Since current length is more than current result, we update result.

 For i = 3, str[3] = '(', we push again, stack is [-1, 0, 3].

 For i = 4, str[4] = ')', we pop from the stack, stack becomes
 [-1, 0] and length of current valid substring becomes 4 (we get
 this 4 by subtracting stack top from current index).
 Since current length is more than current result, we update result.
 */

public class LongestValidParentheses {
    public static void main(String[] args) {
        String str1 = "((()()";
        findMaxLen(str1);
        String str2 = "()(()))))";
        findMaxLen(str2);
    }

    private static void findMaxLen(String str) {
        if(str.length() == 0 || str == null) return;
        Stack<Integer> st = new Stack<>();
        int res = 0;
        st.push(-1);

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(')
                st.push(i);
            else{
                st.pop();
                if(st.isEmpty())
                    st.push(i);
                else
                    res = Math.max(res, i-st.peek());
            }
        }
        System.out.println(res);
    }
}
