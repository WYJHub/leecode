package sort;

import java.util.Random;

public class QuickSort {

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
        int high = arr.length - 1;
        // 选择排序
        // selectSort(arr, low, high);
        
        // int[] tmp = new int[arr.length];
        // mergeSort(arr, low, high, tmp);

        // for(int i = 0; i < high; i++) {
        //     System.out.print(tmp[i] + " ");
        // }
        quickSort(arr, low, high);
        for(int i = low; i <= high; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
