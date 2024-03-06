package sort;

import java.util.Random;

public class QuickSort {


    //归并排序复习,需要一个临时数组来存放合并后的值
    // [start, end)范围内进行排序, 注意是左闭右开写法
    public static void mergeSort1(int[] arr, int start, int end, int[] temp) {
        //只有一个元素不考虑
        if(end - start <= 1) return;
        //无符号右移
        int mid = (start + end) >>> 1;
        
        mergeSort1(arr, start, mid, temp);
        mergeSort1(arr, mid, end, temp);

        for(int i = start, p = start, q = mid; i < end; i++) {
            if(q >= end || (p < mid && arr[q] >= arr[p])) {
                temp[i] = arr[p];
                p++;
            }
            else {
                temp[i] = arr[q];
                q++;
            }
        }

        for(int i = start; i < end; i++) {
            arr[i] = temp[i];
        }
    }


    public static void mergeSort(int[] arr, int start, int end, int[] temp) {
        if(end - start <= 1) return;
        
        int mid = (start + end) >>> 1;
        mergeSort(arr, start, mid, temp);
        mergeSort(arr, mid, end, temp);

        for(int i = start, p = start, q = mid; i < end; i++) {
            if(q >= end || p < mid && arr[p] < arr[q]) {
                temp[i] = arr[p++];
            }
            else {
                temp[i] = arr[q++];
            }
        }
        
        for(int i = start; i < end; i++) {
            arr[i] = temp[i];
        }
    }

    
    public static void quickSort(int[] arr, int low, int high) {
        if(high <= low) {
            return;
        }
        int index = low + new Random().nextInt(high - low + 1);
        swap(arr, index, high);
        int pivot = arr[high], i = low;
        for(int j = low; j < high; j++) {
            if(arr[j] < pivot) {
                swap(arr, i++, j);
            }
        }
        swap(arr, i, high);
        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }

    

    public static void quickSort2(int[] arr, int low, int high) {
        if(high <= low) {
            return;
        }
        int index = low + new Random().nextInt(high - low + 1);
        int pivot = arr[index];
        swap(arr, index, high);

        int left = low, right = high - 1;
        while(left < right) {
            while(left < right && arr[right] > pivot) {
                right--;
            }
            while(left < right && arr[left] <= pivot) {
                left++;
            }
            if(left < right) {
                swap(arr, left, right);
            }
        }
        if(arr[left] < arr[high])left = left + 1;
        swap(arr, left, high);
        for(int i = low; i <= high; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        quickSort2(arr, low, left - 1);
        quickSort2(arr, left + 1, high);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,7,9,2,4,6,5};
        int low = 0;
        int high = arr.length;
        // 选择排序
        // selectSort(arr, low, high);
        
        System.out.println("归并排序打印:");
        int[] tmp = new int[arr.length];
        mergeSort1(arr, low, high, tmp);

        for(int i = 0; i < high; i++) {
            System.out.print(tmp[i] + " ");
        }
        System.out.println("快排打印:");
        arr = new int[]{1,3,7,9,2,4,6,5};
        high = high - 1;
        // quickSort(arr, low, high);
        for(int i = low; i <= high; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
