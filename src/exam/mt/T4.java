package exam.mt;

import java.util.*;

public class T4 {
    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // List<String> list = new ArrayList<>();
        // //处理带空格的字符串的输入
        // while(in.hasNext()) {
        //     list.add(in.next());
        // }
        // for(int i = 0; i < list.size(); i++) {
        //     System.out.println(list.get(i));
        // }

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            String[] ss = s.split(" ");
            Arrays.sort(ss);
            for(int i = 0; i < ss.length; i++) {
                System.out.print(ss[i] + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
