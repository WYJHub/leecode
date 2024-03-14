package leecodeday.q100;

import java.util.ArrayDeque;
import java.util.Deque;

// 接雨水
public class T42 {

    //一个柱子能够盛下Math.min(leftMax, rightMax) - height[index];

    //双指针空间复杂度最低
    public static int trap(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        int leftMax = height[0], rightMax = height[right];
        while(left < right) {

            //左侧柱子高度低于右侧柱子，必有leftMax < rightMax
            if(height[left] < height[right]) {
                res += leftMax - height[left];
                left++;
                leftMax = Math.max(leftMax, height[left]);
            }
            else {
                res += rightMax - height[right];
                right--;
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return res;
    }


    public static int trap2(int[] height) {
        int res = 0;
        int n = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if(stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int curWidth = i - left - 1;
                int curHeight = Math.min(height[left], height[i]) - height[top];
                res += curHeight * curWidth;
            }
            stack.push(i);
        }
        return res;
    }

    public static int trap1(int[] height) {
        int n = height.length;
        if(n <= 2) {
            return 0;
        }
        int res = 0;
        int left[] = new int[n];
        left[0] = height[0];
        for(int i = 1; i < n; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }

        int right[] = new int[n];
        for(int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }


        for(int i = 0; i < n; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(height));
    }
}
