package com.guozz.practise.leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println("()---"+isValidParentheses("()"));
        System.out.println("()[]{}---"+isValidParentheses("()[]{}"));
        System.out.println("(]---"+isValidParentheses("(]"));
        System.out.println("([)]---"+isValidParentheses("([)]"));
        System.out.println("{[]}---"+isValidParentheses("{[]}"));

    }

    /**
     * 用栈来实现
     * 1.如果是'(','{','[' 则压栈
     * 2.如果是')', '}', ']'则判断栈是否为空，如果为空则返回false
     * 3.栈不为空时就判断顶括号和当前的括号是否一致，如果是一对则栈顶移除
     * 4.如果栈为空则返回true
     * @return
     */
    public static boolean  isValidParentheses(String s){
        Stack stack = new Stack();
        char[] chars =  s.toCharArray();

        for(int i=0;i<chars.length;i++){
            if(isLeft(chars[i])){
                stack.push(chars[i]);
            }else{
                if(stack.empty()){
                    return false;
                }else{
                    if(isAPair(stack,chars[i])){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }

        }
        return stack.empty();
    }

    private static boolean isAPair(Stack stack, char aChar) {
        //System.out.println(stack.peek());
        //System.out.println(aChar);

        if(
                (stack.peek().toString().equals("(") && aChar==')')||
                (stack.peek().toString().equals("{") && aChar=='}')||
                (stack.peek().toString().equals("[") && aChar==']')
           ){
            return true ;
        }else{
            return false;
        }
    }

    private static boolean isLeft(char ch) {
        if(ch=='('|| ch=='{' || ch=='['){
            return true;
        }else{
            return false;
        }
    }
}
