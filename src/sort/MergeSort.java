package sort;

import java.util.concurrent.TimeUnit;

//归并排序相比于快排来说，更加稳定，时间复杂度为O(nlogn)，而快排在极端情况下为O(n^2)
public class MergeSort {
    
    /**
     * 选择排序，每次选择一个当前最值来进行交换
     * @param arr
     * @param low
     * @param high
     */
    public static void selectSort(int[] arr, int low, int high) {
        for(int i = low; i < high; i++) {
            int min = arr[i];
            int minIndex = i;
            for(int j = i + 1; j < high; j++) {
                if(arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 归并排序
     * 最终是相邻元素的比较，所以排序结果是稳定的
     * 相比于快排，时间复杂度也更为稳定，这是由归并排序的额外空间开销所换取的。
     * @param arr
     * @param low
     * @param high
     * @param tmp
     */
    public static void mergeSort(int[] arr, int low, int high, int[] tmp) {
        if(low + 1 >= high) return;
        //保证low， high 均 > 0
        int mid = (low + high) >>> 1;
        mergeSort(arr, low, mid, tmp);
        mergeSort(arr, mid, high, tmp);

        for(int i = low, p = low, q = mid; i < high; i++) {
            if(q >= high || p < mid && arr[p] < arr[q]) {
                tmp[i] = arr[p++];
            }
            else {
                tmp[i] = arr[q++];
            }
        }

        for(int i = low; i < high; i++) {
            arr[i] = tmp[i];
        }
    }

    // >>>无符号右移，>>有符号右移
    // 再也不用（right - left）/2 + left的方法防止越界了
    public void testMid() {
        int low  = Integer.MIN_VALUE  + 1;
        int high = Integer.MIN_VALUE;
        // 右移补0
        int mid = (low + high) >>> 1;
        // 
        int mid2 = (low + high) >> 1;
        System.out.println(mid);
        System.out.println(mid2);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,7,9,2,4,6,5,8};
        int low = 0;
        int high = arr.length;
        // 选择排序
        // selectSort(arr, low, high);
        
        int[] tmp = new int[arr.length];
        mergeSort(arr, low, high, tmp);

        for(int i = 0; i < high; i++) {
            System.out.print(tmp[i] + " ");
        }
    }
}
