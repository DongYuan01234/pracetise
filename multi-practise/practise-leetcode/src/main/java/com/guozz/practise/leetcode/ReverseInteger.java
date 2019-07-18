package com.guozz.practise.leetcode;


/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 *
 * Example 2:
 *
 * Input: -123
 * Output: -321
 *
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit
 * signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        //System.out.println(reserseInteger((123)));
        System.out.println(reserseInteger((-123)));
        //System.out.println(reserseInteger((120)));
        //System.out.println(reserseInteger((Integer.MAX_VALUE)));
    }


    public static  int reserseInteger(int input){
        if(input<=Integer.MIN_VALUE || input>=Integer.MAX_VALUE){
            return 0;
        }

        long result=0;

        for(;input!=0;input=input/10){
            result=result*10+input%10;
        }

        return (int)result;
    }
}
