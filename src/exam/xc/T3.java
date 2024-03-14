package exam.xc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
        String[] strings = s.substring(1, s.length() - 1).split(",");
        List<String[]> res = new ArrayList<>();
        int n = strings.length;
        
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        String num = "";
        Long count = 0L;
        for(int i = 0; i < n; i++) {
            //解析当前字符串
            int index = strings[i].indexOf("(");
            String curNum = strings[i].substring(0, index);
            String curCountString = strings[i].substring(index + 1, strings[i].length() - 1);
            int curcount = Integer.parseInt(curCountString);
            if(!curNum.equals(num)) {
                if(count != 0) {
                    stringBuilder.append(num);
                    stringBuilder.append("(");
                    stringBuilder.append(String.valueOf(count));
                    stringBuilder.append(")");
                    stringBuilder.append(",");
                }
                num = curNum;
                count = (long) curcount;
            }
            else {
                count += (long) curcount;
            }
        }
        stringBuilder.append(num);
        stringBuilder.append("(");
        stringBuilder.append(String.valueOf(count));
        stringBuilder.append(")");
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }
}
