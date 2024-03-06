package dp;

import java.util.ArrayList;
import java.util.List;

public class T118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        ans.add(new ArrayList<>(row));
        for(int i = 1; i < numRows; i++) {
            //第i行需要有i+1个元素
            //索引0对应的元素初始化为1
            for(int j = row.size() - 1; j > 0; j--) {
               row.set(j, row.get(j) + row.get(j - 1)); 
            }
            row.add(1);
            ans.add(new ArrayList<>(row));
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new T118().generate(5);
        System.out.println(list);
    }
}
