package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// 给定两个数组，arr1 和 arr2，

// arr2 中的元素各不相同
// arr2 中的每个元素都出现在 arr1 中
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

 

// 示例：

// 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
// 输出：[2,2,2,1,4,3,3,9,6,7,19]
public class LCR075 {
    //计数排序 0 <= arr1[i], arr2[i] <= 1000 数据范围确定，以空间换时间
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 0;
        for(int element : arr1) {
            max = Math.max(max, element);
        }
        int[] frequency = new int[max + 1];
        for(int element : arr1) {
            frequency[element]++;
        }
        int[] res = new int[arr1.length];
        int index = 0;
        for(int element : arr2) {
            int n = frequency[element];
            while(n-- > 0) {
                res[index++] = element;
            }
            frequency[element] = 0;
        }

        for(int i = 0; i <= max; i++) {
            int n = frequency[i];
            while(n-- > 0) {
                res[index++] = i;
            }
        }
        return res;
    }

    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        // 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾
        // arr1排序
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        // 记录在arr2中出现的数字
        for(int element : arr2) {
            map.put(element, 0);
        }
        //遍历arr1
        for(int element : arr1) {
            Integer integer = map.get(element);
            if(integer == null) {
                list.add(element);
            }
            else {
                map.put(element, integer + 1);
                System.out.println(integer);
            }
        }
        List<Integer> preList = new ArrayList<>();
        for(int element : arr2) {
            int n = map.get(element);
            for(int i = 0; i < n; i++) {
                preList.add(element);
            }
        }

        list.sort((o1, o2) -> {
            return  o1 - o2;
        });

        int index = 0;
        int[] res = new int[arr1.length];
        for(int i = 0; i < preList.size(); i++) {
            res[index] = preList.get(i);
            index++;
        }
        for(int i = 0; i < list.size(); i++) {
            res[index] = list.get(i);
            index++;
        }
        return res;
    }
}
