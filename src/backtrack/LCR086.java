package backtrack;

import java.util.ArrayList;
import java.util.List;

public class LCR086 {
    
    //回文串检索，记忆化搜索
    int[][] f;
    //存储结果
    List<List<String>> res = new ArrayList<>();
    //存储当前划分结果
    List<String> cur = new ArrayList<>();
    int n;

}
// public class LCR086 {
//     int[][] f;
//     List<List<String>> res = new ArrayList<>();
//     List<String> cur = new ArrayList<>();
//     int n;

//     public String[][] partition(String s) {
//         n = s.length();
//         f = new int[n][n];
//         dfs(s, 0);
//         String[][] resArray = new String[res.size()][];
    
//         for (int i = 0; i < res.size(); i++) {
//             List<String> innerList = res.get(i);
//             int innerSize = innerList.size();
//             String[] innerArray = new String[innerSize];
//             for (int j = 0; j < innerSize; j++) {
//                 innerArray[j] = innerList.get(j);
//             }
//             resArray[i] = innerArray;
//         }
//         return resArray;
//     }

//     public void dfs(String s, int i) {
//         if(i == n) {
//             res.add(new ArrayList<>(cur));
//             return;
//         }

//         for(int j = i; j < n; j++) {
//             if(isPalindrome(s, i, j) == 1) {
//                 cur.add(s.substring(i, j + 1));
//                 dfs(s, j + 1);
//                 cur.remove(cur.size() - 1);
//             }
//         }
//     }

//     public int isPalindrome(String s, int i, int j) {
//         if(f[i][j] != 0) {
//             return f[i][j];
//         }

//         if(i >= j) {
//             f[i][j] = 1;
//         }
//         else if(s.charAt(i) == s.charAt(j)) {
//             f[i][j] = isPalindrome(s, i + 1, j - 1);
//         }
//         else {
//             f[i][j] = -1;
//         }
//         return f[i][j];
//     }
// }
