package org.jwk;

import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;

public class lc27_removeElement {
}

class Solution27 {
    //双指诊法，快指针碰到和val想等的就往前，不想等的就放进慢指针
    public int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        int n = nums.length;
        while (fast < n) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                fast++;
                slow++;
            } else {
                fast++;
            }
        }
        return slow;
    }
}