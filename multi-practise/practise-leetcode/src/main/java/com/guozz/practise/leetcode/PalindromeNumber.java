package com.guozz.practise.leetcode;

/**
 * 回文数
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 *
 * Coud you solve it without converting the integer to a string?
 */
public class PalindromeNumber {


    public static void main(String[] args) {
        System.out.println("121"+getPalindromeNumber(121));
        System.out.println("-121"+getPalindromeNumber(-121));
        System.out.println("10"+getPalindromeNumber(10));
        System.out.println("101"+getPalindromeNumber(101));
    }


    public static boolean getPalindromeNumber(Integer input){
        if(input>Integer.MAX_VALUE || input<Integer.MIN_VALUE || input<0){
            return false;
        }
        Integer temp = input;
        Integer result =0;
        for(;input!=0;input=input/10){
            result=result*10 + input%10;
        }

        return result.equals(temp);
    }

}
