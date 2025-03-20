package org.jwk;

import java.util.ArrayList;
import java.util.List;

public class lc295_MedianFinder {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(0);
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());
    }
}

class MedianFinder {
    List<Integer> nums;

    public MedianFinder() {
        nums = new ArrayList<>();
    }

    public void addNum(int num) {
        if (nums.isEmpty()) {
            nums.add(num);
            return;
        }
        int left = 0;
        int right = nums.size()-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums.get(mid) < num)
                left = mid+1;
            else
                right = mid-1;
        }
        nums.add(left, num);
    }

    public double findMedian() {
        int n = nums.size();
/*        for (int i=0; i<n; i++)
            System.out.print(nums.get(i) + " ");*/
        if (n == 0)
            return 0;
        if (n%2 == 0) {
            return (double) (nums.get(n / 2) + nums.get(n / 2 - 1)) / 2;
        } else {
            return nums.get(n/2);
        }
    }
}
