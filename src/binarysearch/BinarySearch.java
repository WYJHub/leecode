package binarysearch;

import java.util.Arrays;
import java.util.List;

public class BinarySearch{

    public static void main(String[] args) {
        List<int[]> asList = Arrays.asList(new int[]{1,2,2,2,2,3,4});
        int[] arr = new int[]{1,2,2,2,2,3,4};
        //寻找2的左边界
        System.out.println(binarysearch1(arr, 2));

        //寻找2的右边界
        System.out.println(binarysearch3(arr, 2));
        //寻找大于等于2的索引
        System.out.println(binarysearch1(arr, 2 - 1));
    }

    //寻找target左边界
    public static int binarysearch1(int[] arr, int target) {
        int left = 0, right = arr.length;
        //注意right是arr.length,其对应位置是没有值的，即左闭右开写法
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == target) {
                //找到target,不要立刻返回
                right = mid; //收缩右侧，逼近左侧
                // left = mid + 1; //收缩左侧，逼近右侧
            }
            else if(arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }

    //右边界
    public static int binarysearch3(int[] arr, int target) {
        int left = 0, right = arr.length;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == target) {
                left = mid + 1; //收缩左侧，逼近右侧
            }
            else if(arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left - 1;
    }
    

    //寻找大于等于target的第一个数，可以等价于寻找大于target - 1的数
    public static int binarysearch2(int[] arr, int target) {
        int left = 0, right = arr.length;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == target) {
                //由于需要找到target左边界，此时无法继续判断，不能向下分析
            }
            else if(arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }


}