package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class LCR045 {
    int val = 0;
    int curHeight = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root,0);
        return val;
    }

    public void dfs(TreeNode root, int height) {
        if(root == null) {
            return;
        }
        height++;
        dfs(root.left, height);
        dfs(root.right, height);
        
        if(height > curHeight) {
            curHeight = height;
            val = root.val;
        }
    }
    // bfs
    public int findBottomLeftValue1(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        int res = 0;
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur.right != null) queue.offer(cur.right);
            if(cur.left != null) queue.offer(cur.left);
            res = cur.val;
        }
        return res;
    }
}


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
