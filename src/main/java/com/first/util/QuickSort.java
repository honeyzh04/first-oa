package com.first.util;    /**
 * @Title: QuickSort
 * @ProjectName first-oa
 * @Description: TODO
 * @author: zhaoh
 * @date 2018/11/2810:54
 */

public class QuickSort {

    public static void sort(int[] a, int low, int high) {
        if(low>=high)
            return;
        int i = low;
        int j = high;
        int key = a[i];
        while (i < j) {
            while (i < j && a[j] >= key)
                j--;
            a[i++] = a[j];
            while (i < j && a[i] <= key)
                i++;
            a[j--] = a[i];
        }
        a[i] = key;
        sort(a,low,i-1);
        sort(a,i+1,high);
    }

    public static void quickSort(int[] a) {
        sort(a, 0, a.length-1);
        for(int i:a)
            System.out.print(i+" ");
    }

    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 50 };
        quickSort(a);
    }
}