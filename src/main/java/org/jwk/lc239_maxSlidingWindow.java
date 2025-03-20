package org.jwk;

import java.util.Deque;
import java.util.LinkedList;

public class lc239_maxSlidingWindow {
    public static void main(String[] args) {
        Solution239 solution = new Solution239();
        int[] res = solution.maxSlidingWindow(new int[]{1,-1}, 1);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}

class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 维护一个双端队列，队列里存“可能成为最大值的”，所以队列必须降序，从右边插入（队列里存的是索引）
        // 每次有新数字进来，如果比队列里已有的数字大，就把队列里的数字出去，因为他们不可能是最大值了
        // 如果队列里数字超过窗口大小了，再从左边弹出数字
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast(); //把所有右边的小于当前数字的弹出
            }
            deque.offerLast(i); //把当前数字放进去
            while (deque.peekFirst() <= i-k)
                deque.pollFirst(); //如果队列里数字超过k个了，就从左边弹出一个
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()]; //因为队列是递减的，所以第一个就是每一轮的最大值
            }
        }
        return result;

/*      //直接窗口模拟的方法
        int[] result = new int[nums.length - k + 1];
        int max = -10000;
        int maxIndex = 0;
        for (int i=0; i<k; i++)
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }

        result[0] = max;
        int left=1, right=left+k-1;
        while (right<nums.length) {
            if (nums[right] > max) {
                max = nums[right];
                maxIndex = right;
            } else if (left > maxIndex) {
                max = nums[left];
                maxIndex = left;
                for (int t=left+1; t<=right; t++)
                    if (nums[t] > max) {
                        max = nums[t];
                        maxIndex = t;
                    }
            }

            result[right-k+1] = max;
            right++;
            left++;
        }
        return result;*/
    }
}