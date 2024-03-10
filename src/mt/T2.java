package mt;

import java.util.HashSet;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        String s = in.next();
        String t = in.next();
        // System.out.println(n);
        // System.out.println(s);
        // System.out.println(t);
        int curV = 0;
        int maxIncrement = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == t.charAt(i)) {
                curV += 1;
                set.add(i);
            }
            else {
                for(int j = 0; j < i; j++) {
                    if(!set.contains(j)) {
                        if(s.charAt(j) == t.charAt(i)) {
                            // System.out.println(s.charAt(j) + " " + s.charAt(i));
                            if(s.charAt(i) == t.charAt(j)) {
                                maxIncrement = 2;
                            }
                            else {
                                maxIncrement = Math.max(1, maxIncrement);
                            }
                        }
                        else if(s.charAt(i) == t.charAt(j)) {
                            // System.out.println(s.charAt(i) + " " + s.charAt(j));
                            maxIncrement = Math.max(1, maxIncrement);
                        }
                    }
                }
            }
        }
        System.out.println(curV + maxIncrement);
    }
}
