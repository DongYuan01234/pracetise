package com.guozz.practise.leetcode;

public class RemoveDuplicates {

    public static void main(String[] args) {
       int []  nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0){
            return 0 ;
        }


        int duplicateSize = 0;
        for (int i = 0; i < nums.length; i++) {
            int preIndex = i - 1;

            if (preIndex < 0) {
                continue;
            }

            if (nums[preIndex] != nums[i]) {
                duplicateSize++;
                nums[duplicateSize] = nums[i] ;
            }

        }
        return duplicateSize + 1;
    }

}
