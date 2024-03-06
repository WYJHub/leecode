# LeetCode

## hot100

### 1.hash

两数之和：入门级

字母异位词分组

最长连续序列

### 2.双指针

### 3.滑动窗口

无重复字符的最长子串



找到字符串中所有字母异位词

### 4.子串

#### 1.和为k的子数组：前缀和 + hash

#### 2.滑动窗口最大值 hard（x）

给你一个整数数组nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 `k` 个数字。滑动窗口每次只向右移动一位。

返回 *滑动窗口中的最大值* 。



1. 最直观的想法，利用优先队列存储元素及其索引，while循环来保证当前堆顶元素一定在当前滑窗范围内，最后通过peek直接获取当前窗口的最大值。时间复杂度O(nlogn)

   ```java
       //时间复杂度(O(NlogN))，优先队列->堆，插入与删除均为LogN，共计N次操作，即NlogN
       public int[] maxSlidingWindow(int[] nums, int k) {
           int n = nums.length;
           //创建优先队列
           //使用优先队列的目的是方便取出当前队列中最大元素。 ---> 创建大顶堆
           //但是由于指定窗口范围为[i, i + k - 1]，队列中除了元素本身还需要存储元素索引，以确定当前堆顶元素索引是否在当前窗口内
           
           PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
               @Override
               public int compare(int[] pair1, int[] pair2) {
                   if(pair1[0] != pair2[0]) {
                       return pair2[0] - pair1[0];
                   }
                   return pair2[1] - pair1[1];
               }
           });
           
           //队列初始化,放入k个元素
           for(int i = 0; i < k; i++) {
               queue.offer(new int[]{nums[i], i});
           }
           
           int[] res = new int[n - k + 1];
           res[0] = queue.peek()[0];
           for(int i = k; i < n; i++) {
               queue.offer(new int[]{nums[i], i});
               //查看堆顶元素是否属于当前框
               while(queue.peek()[1] < i - k + 1) {
                   queue.poll();
               }
               res[i - k + 1] = queue.peek()[0];
           }
           return res;
   ```

   

2. 单调队列

   ```java
       //单调队列
       public int[] maxSlidingWindow1(int[] nums, int k) {
           int n = nums.length;
           int[] res = new int[n - k + 1];
           LinkedList<Integer> queue = new LinkedList<>();
   
           for(int i = 0; i < k; i++) {
               //如果当前元素，大于等于队尾元素，丢弃队尾元素
               while(!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                   queue.pollLast();
               }
               queue.offerLast(i);
           }
           //这样queue中保存的就是从最大值开始后，峰值点记录
           res[0] = nums[queue.peekFirst()];
           for(int i = k; i < n; i++) {
               while(!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                   queue.pollLast();
               }
               queue.offerLast(i);
               while(queue.peekFirst() < i - k + 1) {
                   queue.pollFirst();
               }
               res[i - k + 1] = nums[queue.peekFirst()];
           }
           return res;
       }
   ```

   

3. 分块+预处理

#### 3.最小覆盖子串（x）



### 5.普通数组

#### 1.最大子数组和

 (序列包含正负数,求最大连续子串的和)：动态规划，f[i] = Math.max(f[i - 1] + nums[i], nums[i])

#### 2.合并区间

排序

```java
Arrays.sort(intervals, new Comparator<int[]>()) {
	@Override
    public int compare(int[] o1, int[] o2) {
    	if(o1[0] != o2[0]) {
            return o1[1] - o2[1];
        }
        return o1[0] - o2[0];
    }
}
```

ArrayList<int[]> res;

```
list 转 int[][]
```

#### 3.轮转数组

数组翻转

```
reverse(nuums, 0, nums.length - 1);
reverse(nums, 0, k - 1);
reverse(nums, k, nums.length - 1);
```

#### 4.除自身以外数组的乘积

使用L、R数组记录index索引位置对应元素左侧乘积以及右侧乘积。

空间复杂度O（n）



题中提到忽略返回数组的空间，则可以进一步优化，采用返回数组来记录L（即左侧乘积），然后使用R来遍历取值得到右侧乘积，同时更新res。达到O(1)空间复杂度。

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
        int[] res = new int[n];
        //左侧元素乘积
        res[0] = 1;        
        for(int i = 1; i < n; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        
        //右侧元素乘积
        int R = 1;
        for(int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * R;
            R = R * nums[i];
        }
        return res;
    }
}
```



1. 缺失的第一个正数

   不考虑空间可以直接使用set存储所有元素，然后遍历查询一遍 nums[i] + 1是否存在。

   

   实现时间复杂度为 `O(n)` 并且**只使用常数级别额外空间**的解决方案

   

   分析：

   对于一个长度为N的整数数组，其没有出现的最小正整数在[1,N + 1]之间。

   ```java
   class Solution {
       public int firstMissingPositive(int[] nums) {
   		int N = nums.length;
           //将小于等于0的数全部转换为N + 1
           for(int i = 0; i < N; i++) {
               if(nums[i] <= 0) {
                   nums[i] = N + 1;
               }
           }
   		//将1 - n之间的数，对应位置（index - 1）的数转换为负数     
           for(int i = 0; i < N; i++) {
               int num = Math.abs(nums[i]);
               if(num <= N) {
                   nums[num - 1] = -Math.abs(nums[num - 1]);
               }
           }
           
           //通过第一个不为负数数的位置来判断最小正整数出现的位置
           for(int i = 0; i < N; i++) {
               if(nums[i] > 0) {
                   return i + 1;
               }
           }
           return N + 1;
       }
   }
   ```

   

### 6.矩阵

### 7.链表

#### 1.相交链表（√）

双指针分别指向headA和headB，然后分别向后移动，直到为空，转移到另一条链表上，最长为O(m + n)。

#### 2.反转链表（√）

```java
if(head == null || head.next == null) {
	return head;
}

ListNode prev = null;
ListNode cur = head;
while(cur != null) {
	ListNode next = cur.next;
	cur.next = prev;
	prev = cur;
	cur = next;
}

return prev;
```

递归

```
public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
```

#### 3.回文链表（√）

O(1)空间复杂度

使用快慢指针，确定链表中点。

反转后半片段（不包含中点）

然后进行判断，若出现不同则返回false

return true

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //结束后slow指向 1,2,3,4 -> 2
        // 1,2,3,4,5 -> 3
        ListNode right = reveseList(slow.next);
        ListNode left = head;
        while(right != null) {
            if(left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public ListNode reveseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
```

#### 4.环形链表Ⅰ/Ⅱ

Ⅰ 快慢指针判断是否出现重复或者为空即可。

Ⅱ 假定入环前距离为a。

慢指针入环后，此时无论快指针在任意位置，在慢指针走完一圈前，快指针都将追上慢指针。

假定slow在走距离b后与快指针相遇。余下环距离假定为c。

假设此时从出发共经过时间t。

t = a + b

2t = a + n (b + c) + b

可知 a = n(b + c) - b = (n - 1)(b + c) + c

此时创建新指针cur指向head，cur与slow同时向后移动。

在cur走过a距离后，slow指针从b段末端走至c段末端，即两者会在入环点相遇，此时返回即可。

#### 5.合并两个有序链表（√）

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            }
            else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        if(list1 != null) {
            cur.next = list1;
        }
        else {
            cur.next = list2;
        }
        return dummy.next;
    }
}
```

#### 6.两数之和（√）

1.用栈存储，取出相加， 空间复杂度O（n）

2.反转链表，然后相加，注意进位，最后再反转，空间复杂度O(1)

#### 7.删除链表的倒数第N个节点（√）

双指针，left指向head, right前进n次，

然后left和right同时向后移动，当right为null时，left指向倒数第n个节点

#### 8.两两交换链表中的节点

创建一个dummy节点，dummy.next = head;

初始化

temp = dummy

temp -> node1 -> node2

然后替换为temp ->node2 -> node1

然后temp指向node1

直至temp后没有元素或仅剩一个元素。

```java
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode temp = dummy;

        while(temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }

        return dummy.next;
    }
}
```

#### 9.K个一组翻转链表

遍历且翻转

```java
//记录当前片段头节点，需要连接下一片段头节点
curHead = head;

cur = head;
count = 0;
prev = null;
while(cur != null) {
    count++;
    ListNode next = cur.next;
    prev.next = cur.next;
    cur.next = prev;
    cur = next;
    if(count == k) {
        //说明当前片段数量达到k
        nextHead = cur;
        count = 0;
        //当前节点指向下一个头
        curHead.next = nextHead;
        
    }
}
```



### 8.二叉树

### 9.图论

### 10.回溯

### 11.二分查找

### 12.栈

### 13.堆

### 14.贪心算法

### 15.动态规划

### 16.多维动态规划

### 17.技巧