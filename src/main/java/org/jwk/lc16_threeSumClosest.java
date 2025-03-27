package org.jwk;

import java.util.Arrays;

public class lc16_threeSumClosest {
    public static void main(String[] args) {
        int[] a = {0,3,97,102,200};
        Solution16 solution = new Solution16();
        System.out.println(solution.threeSumClosest(a, 300));
    }
}

class Solution16 {
    // 思路错了！我写的是固定左右两个，二分找中间的，但是左右两个如何划分不一定！即使和大于target，也可能应该left++
    // 应该是先固定一个，然后用双指针寻找全部，这样能考虑所有情况
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2]; // 初始化为前三个数的和
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            // 跳过重复的起始元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if (currentSum == target) {
                    return target;
                }

                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // 根据当前和与目标的关系移动指针
                if (currentSum < target) {
                    left++;
                    // 跳过重复的左指针元素
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else {
                    right--;
                    // 跳过重复的右指针元素
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }

        return closestSum;
    }
/*    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        int ansSum = 0;
        int left = 0, right = n - 1;
        while (left+1 < right) {
            int sum = nums[left] + nums[right];
            int diff = target - sum;
            int midNum = findClosestNum(nums, left+1, right-1, diff);
            sum += midNum;
            if (Math.abs(sum-target) < minDiff) {
                minDiff = Math.abs(sum-target);
                ansSum = sum;
            }
            if (sum < target)
                left++;
            else
                right--;
        }
        return ansSum;
    }

    // 在left-right范围内，找到和target差距最小的数，返回数字
    public int findClosestNum(int[] nums, int left, int right, int target) {
        if (left == right) return nums[left];
        int ans = 0;
        int minDiff = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (Math.abs(nums[mid] - target) < minDiff) {
                minDiff = Math.abs(nums[mid] - target);
                ans = nums[mid];
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }*/
}