package sort;

import java.util.*;

public class Sort8 {
    
    //1.冒泡排序
    public void sort1(int[] nums) {

    }


    //2.归并排序,[start, end - 1]
    public static void mergeSort(int[] nums, int start, int end, int[] temp) {
        if(end - start <= 1) {
            return;
        }
        int mid = (start + end) >>> 1;
        mergeSort(nums, start, mid, temp);
        mergeSort(nums, mid, end, temp);

        for(int i = start, p = start, q = mid; i < end; i++) {
            if(q >= end || (p < mid && nums[p] < nums[q])) {
                temp[i] = nums[p++];
            }
            else {
                temp[i] = nums[q++];
            }
        }

        for(int i = start; i < end; i++) {
            nums[i] = temp[i];
        }
    }

    //快排,[start,end]
    public static void quickSort(int[] nums, int start, int end) {
        if(end <= start) return;
        //随机选择一个位置
        int index = start + new Random().nextInt(end - start + 1);
        
        //需要将小于pivot的数放在左边，大于pivot的数放在右边
        int pivot = nums[index], i = start;
        //由于小于pivot的数不确定数量，先将其放在最左边
        swap(nums, index, end);

        for(int j = start; j < end; j++) {
            if(nums[j] < pivot) {
                //如果j指针小于pivot,则将j与i指针所指元素交换
                swap(nums, i++, j);
            }
        }
        //结束遍历后，i指针指向位置就是pivot应该在的位置，交换回来即可
        swap(nums, i, end);
        //然后对i两边分别排序
        quickSort(nums, start, i - 1);
        quickSort(nums, i + 1, end);
    }

    //交换
    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    //打印数组
    public static void printNum(int[] nums) {
        int n = nums.length;
        if(n != 0) {
            System.out.print(nums[0]);
        }
        for(int i = 1; i < n; i++) {
            System.out.print(" " + nums[i]);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] a = {3,5,4,1,2};
        int[] b = {4,3,1,2};
        // System.out.println(-1 >>> 1);
        // Sort8.printNum(a);
        // int[] temp = new int[a.length];
        // mergeSort(a, 0, a.length, temp);
        // Sort8.printNum(a);
        // temp = new int[b.length];
        // mergeSort(b, 0, b.length, temp);
        quickSort(a, 0, a.length - 1);
        Sort8.printNum(a);
        System.out.println(-2 >> 1);
        System.out.println(-2 >>> 1);
        System.out.println((Integer.MAX_VALUE + Integer.MAX_VALUE) >> 1);
        System.out.println((Integer.MAX_VALUE + Integer.MAX_VALUE) >>> 1);
    }

}
