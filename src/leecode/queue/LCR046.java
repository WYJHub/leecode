package leecode.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LCR046 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rList = new ArrayList<>();
        if(root == null) {
            return rList;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int len = queue.size();
            rList.add(queue.peek().val);
            while(len-- > 0) {
                TreeNode cur = queue.poll();
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
            }
        }
        
        return rList;
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