package org.jwk;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("原始数组:");
        printArray(arr);

        mergeSort(arr);

        System.out.println("归并排序后:");
        printArray(arr);
    }

    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return; // 如果数组长度为0或1，无需排序
        }

        // 将数组分为两半
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        // 复制数据到左半部分和右半部分
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }

        // 递归排序左右两半
        mergeSort(left);
        mergeSort(right);

        // 合并排序后的左右两半
        merge(arr, left, right);
    }

    //合并两个已排序的数组
    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // 合并两个数组到原数组中
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
