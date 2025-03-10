package org.jwk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class lc347_topKFrequent {
    public static void main(String[] args) {
        Solution347 solution = new Solution347();
        int[] res = solution.topKFrequent(new int[]{1,1,1,2,2,3,3,3}, 2);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }

}

class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>(); //key是数字，value是频率
        for (int num : nums) {
            if (frequencyMap.containsKey(num))
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            else
                frequencyMap.put(num, 1);
        }

        //小顶堆，只放k个内容，堆顶是k个里频率最低的，如果频率大于堆顶，就放入
        //这里有一个点，堆里只存key的数字，而不存频率，但是比较的时候，用这个key的频率来比较
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (a, b) ->  frequencyMap.get(a) - frequencyMap.get(b)
        );

        for (Integer num : frequencyMap.keySet()) { //这里循环所有的key，往堆里放
            heap.add(num);
            if (heap.size() > k) //如果超出k个了，就扔掉一个
                heap.poll();
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }
}