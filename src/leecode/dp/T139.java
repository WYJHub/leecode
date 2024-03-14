package leecode.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class T139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int maxLen = 0;
        String eleString;
        for(int i = 0; i < wordDict.size(); i++) {
            eleString = wordDict.get(i);
            set.add(eleString);
            maxLen = Math.max(maxLen, eleString.length());
        }
        // System.out.println(maxLen);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i = 1; i <= n; i++) {
            for(int j = Math.min(i, maxLen); j >= 1; j--) {      
                // if(i == 8) {
                //     System.out.println(s.substring(i - j, i));
                // }  
                if(dp[i - j] && set.contains(s.substring(i - j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        // for(int i = 0; i <= n; i++) {
        //     System.out.print(dp[i] + " ");
        // }
        return dp[n];
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        // list.add("leet");
        // list.add("code");
        // new T139().wordBreak("leetcode", list);
        String s = new String("12323123");
        
        list.add("apple");
        list.add("pen");
        new T139().wordBreak("applepenapple", list);
    }
}
