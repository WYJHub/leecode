package leecodeday.competition.r231231;

import java.util.HashMap;
import java.util.Map;

public class T2 {
    //返回出现至少三次的最长特殊子字符串的长度， 连续串,
    public int maximumLength(String s) {
        //不存在返回-1
        int maxLength = -1;
        Map<Character, HashMap<Integer, Integer>> map = new HashMap<>();
        int n = s.length();
        int curLen = 0;
        for(int i = 0; i < n; i++) {
            curLen++;
            if(i == n - 1 || s.charAt(i + 1) != s.charAt(i)) {
                // System.out.println(curLen);
                char c = s.charAt(i);
                HashMap<Integer, Integer> cMap = map.getOrDefault(c, new HashMap<>());;
                //根据当前curLen更新该字符对应的数据
                int count = 1;
                for(int k = curLen; k > 0; k--) {
                    int strNum = cMap.getOrDefault(k, 0) + count;
                    // System.out.println(strNum);
                    if(strNum >= 3 && k > maxLength) {
                        maxLength = k;
                    }
                    cMap.put(k, strNum);
                    count++;
                }
                map.put(c, cMap);
                curLen = 0;
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String s = new String("aaaa");
        T2 t = new T2();
        int maximumLength = t.maximumLength(s);
        System.out.println(maximumLength);
    }
}
