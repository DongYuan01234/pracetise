package com.guozz.practise.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {


    public static void main(String[] args) {
        int numbs[]=new int[]{1,4,3,8,6};
        //int result[]=twoSum(numbs,7);
        int result[]=twoSumUseHashMap(numbs,7);
        for(Integer temp:result){
            System.out.println(temp);
        }

    }

    // Brute force: O(n^2) runtime and O(1) space complexities
    public static int[] twoSum(int [] numbs,int target){
        if(numbs==null || numbs.length<2){
            return new int[numbs[0]];
        }

        for(int i=0;i<numbs.length;i++){
            for(int j=i+1;j<numbs.length;j++){
                if(numbs[i]+numbs[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[numbs[0]];
    }


    // Using a hashmap: O(n) runtime and O(n) space complexities
    public static int[] twoSumUseHashMap(int [] numbs,int target){
        if(numbs==null || numbs.length<2){
            return new int[numbs[0]];
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<numbs.length;i++){
            int complete = target-numbs[i];
            if(map.containsKey(complete)){
                return new int[]{map.get(complete),i};
            }else{
                map.put(numbs[i],i);
            }
        }
        return new int[]{numbs[0]};
    }
}
