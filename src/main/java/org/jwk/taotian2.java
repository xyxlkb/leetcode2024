package org.jwk;
import java.util.Arrays;
import java.util.Comparator;

//给定一个正整数序列，重新排列它们的顺序使之组成一个最大的整数。输出结果可能非常大，
//所以你需要返回一个字符串而不是整数。例如[10, 3, 92, 32, 14] ->923321410
public class taotian2 {

    public static void main(String[] args) {
        int[] nums1 = {10, 3, 92, 32, 14};
        System.out.println(largestNumber(nums1));

        int[] nums2 = {0, 0};
        System.out.println(largestNumber(nums2));

        int[] nums3 = {0};
        System.out.println(largestNumber(nums3));
    }

    public static String largestNumber(int[] nums) {
        if (nums.length==0 || nums==null)
            return null;

        String[] numStrs = new String[nums.length];
        for (int i=0; i<nums.length; i++) { //转换为字符数组
            numStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStrs, new Comparator<String>() { //降序排列
            @Override
            public int compare(String o1, String o2) {
                String order1 = o1 + o2;
                String order2 = o2 + o1;
                return order2.compareTo(order1);
            }
        });

        if (numStrs[0].equals("0"))
            return "0";

        StringBuilder res = new StringBuilder();
        for (String numStr : numStrs) {
            res.append(numStr);
        }
        return res.toString();
    }

}
