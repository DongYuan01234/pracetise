package com.guozz.practise.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
//        Integer [] nums = new Integer[]{1,3,5,6};
//        Integer num=5;

        Integer [] nums = new Integer[]{1,3,5,6};
        Integer num=0;
        Integer result = getResult(nums,num);
        System.out.println(result);
    }

    private static int getResult(Integer[] nums, Integer num) {
        int result =-1;
        for(Integer i=0;i<nums.length;i++){
            if(nums[i]==num){
                result=i;
                break;
            }
        }
        if(result!=-1){
            return  result;
        }

        List<Integer> numsList= Arrays.asList(nums);
        numsList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        if(numsList.get(0)>num){
            return 0;
        }
        if(numsList.get(numsList.size()-1)<num){
            return numsList.size();
        }

        for(int i=0;i<numsList.size();i++){
            if(numsList.get(i)<num&&numsList.get(i+1)>num){
                return i+1;
            }
        }
        return result;
    }
}
