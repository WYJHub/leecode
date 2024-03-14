package exam.xc;

import java.util.Scanner;

// 游游拿到了一个字符串，她想重排这个字符串后，使得该字符串包含尽可能多的"you"连续子串。你能帮帮她吗？
public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.next();
        int n = s.length();
        int[] count = new int[3];
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c != 'y' && c != 'o' && c != 'u') {
                stringBuilder.append(c);
            }
            else {
                if(c == 'y') {
                    count[0]++;
                } else if(c == 'o') {
                    count[1]++;
                } else {
                    count[2]++;
                }
            }
        }
        int min = Math.min(count[0], Math.min(count[1], count[2]));
        for(int i = 0; i < min; i++) {
            stringBuilder.append("you");
        }
        for(int i = 0; i < 3; i++) {
            int cur = count[i] - min;
            while(cur-- > 0) {
                if(i == 0) {
                    stringBuilder.append('y');
                } else if(i == 1) {
                    stringBuilder.append('o');
                } else {
                    stringBuilder.append('u');
                }
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
//yyoouuuuu