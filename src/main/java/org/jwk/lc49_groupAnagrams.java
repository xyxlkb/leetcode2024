package org.jwk;

import java.util.*;

public class lc49_groupAnagrams {
}

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>(); //key是排序后的字符串，value是他在ans的序号
        for (String str : strs) {
            char[] chars = str.toCharArray(); //遍历每一个字符串，排序后，加入set
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (map.containsKey(sorted)) { //如果已存在，就在ans的该序号把str加进去
                ans.get(map.get(sorted)).add(str);
            } else { //否则就把排序后的字符串加入map，没排序的加入ans
                List<String> list = new ArrayList<>();
                list.add(str);
                ans.add(list);
                map.put(sorted, ans.size()-1);
            }

        }
        return ans;
    }
}