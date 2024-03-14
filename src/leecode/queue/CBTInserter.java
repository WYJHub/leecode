package leecode.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class CBTInserter {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> next = new ArrayDeque<>();
        queue.offer(root);
        
        int max = Integer.MIN_VALUE;

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur.left != null) {
                next.offer(cur.left);
            }
            if(cur.right != null) {
                next.offer(cur.right);
            }
            max = Math.max(max, cur.val);
            if(queue.isEmpty()) {
                values.add(max);
                max = Integer.MIN_VALUE;
                queue.addAll(next);
                next.clear();
            }
        }
        return values;
    }

    public List<Integer> largestValues1(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int len = queue.size();
            int max = Integer.MIN_VALUE;

            while(len > 0) {
                len--;
                TreeNode cur = queue.poll();
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
                max = Math.max(max, cur.val);
            }
            values.add(max);
        }
        return values;
    }

    //存储最后倒数第二层节点
    Queue<TreeNode> queue = new ArrayDeque<>();
    int depth = 0;
    TreeNode root;
    public CBTInserter(TreeNode root) {
        //保证输入的树是完全二叉树
        this.root = root;
        queue.offer(root);
        while(queue.peek().left != null && queue.peek().right != null) {
            TreeNode cur = queue.poll();
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
    }
    
    public int insert(int v) {
        while(queue.peek().left != null && queue.peek().right != null) {
            TreeNode cur = queue.poll();
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        if(queue.peek().left == null) {
            queue.peek().left = new TreeNode(v);
        }
        else if(queue.peek().left != null && queue.peek().right == null) {
            queue.peek().right = new TreeNode(v);
        }

        return queue.peek().val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}
