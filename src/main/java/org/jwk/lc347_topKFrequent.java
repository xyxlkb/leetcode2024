package org.jwk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class lc347_topKFrequent {
}

class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            if (frequencyMap.containsKey(num))
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            else
                frequencyMap.put(num, 1);
        }

        PriorityQueue<Map<Integer, Integer>> heap = new PriorityQueue<>(
                (a, b) ->  frequencyMap.get(a) - frequencyMap.get(b)
        );

        int[] res = new int[k];
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {}


        return res;
    }
}