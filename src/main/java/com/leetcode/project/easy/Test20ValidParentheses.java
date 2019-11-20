package com.leetcode.project.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @title: leetCode
 * @author: Young
 * @desc: leetcode
 * @date: Created at 2019/11/20 2019 14:24
 * {@link} https://leetcode.com/problems/valid-parentheses/
 */
public class Test20ValidParentheses {
    /*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.

    An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Note that an empty string is also considered valid.

    Example 1:
    Input: "()"
    Output: true

    Example 2:
    Input: "()[]{}"
    Output: true

    Example 3:
    Input: "(]"
    Output: false

    Example 4:
    Input: "([)]"
    Output: false

    Example 5:
    Input: "{[]}"
    Output: true
    */

    public boolean isValid1(String s) {
        //  利用stack来处理,左符号全进,右符号匹配最近一个入栈数据
        Stack<Character> st = new Stack();
        char[] str = s.toCharArray();
        if (str.length % 2 != 0) {
            return false;
        }
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(' || str[i] == '{' || str[i] == '[') {
                st.push(new Character(str[i]));
            } else {
                if (st.empty()) {
                    return false;
                } else if (str[i] == ')' && st.peek() == '(') {
                    st.pop();
                } else if (str[i] == '}' && st.peek() == '{') {
                    st.pop();
                } else if (str[i] == ']' && st.peek() == '[') {
                    st.pop();
                }

            }
        }
        return st.empty();
    }

    public boolean isValid2(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> st = new Stack();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            } else {
                if (s.charAt(i) == ')' && st.pop() != '(') {
                    return false;
                }
                if (s.charAt(i) == '}' && st.pop() != '{') {
                    return false;
                }
                if (s.charAt(i) == ']' && st.pop() != '[') {
                    return false;
                }
            }
        }
        //  若正确匹配,则最后的Stack应是空的;如果stack有数据,则说明没有完全pop;
        return st.empty();
    }
}
