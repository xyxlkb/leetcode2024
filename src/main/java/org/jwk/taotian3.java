package org.jwk;

//在一个数组中有一个数字出现的次数超过了数组长度的一半，找出这个数字(要求时间空间均最优)
public class taotian3 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,2,2,2,2,2,2};
        System.out.println(findNum(nums1));

        int[] nums2 = {1,1,1,2,2,3,4,1,1};
        System.out.println(findNum(nums2));
    }

    public static int findNum(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
