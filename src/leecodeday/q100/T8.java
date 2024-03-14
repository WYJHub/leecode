package leecodeday.q100;

public class T8 {
    public int myAtoi(String s) {
        s = s.trim();
        System.out.println(s.length());
        int res = 0;
        //处理第一个字符
        int sign = 1;
        boolean signExist = false;
        boolean outBound = false;
        if(s.charAt(0) < '0' || s.charAt(0) > '9') {
            if(s.charAt(0) == '+') {
                signExist = true;
            }
            if(s.charAt(0) == '-') {
                signExist = true;
                sign = -1;
            }
        }
        //存在符号起点为1，不存在则起点为0
        int index = signExist? 1 : 0;
        int len = s.length();
        while(index < len) {
            if(s.charAt(index) < '0' || s.charAt(index) > '9') {
                break;
            }
            int check = res;
            res = res * 10 + (s.charAt(index) - '0');
            if(res / 10 != check) {
                //发生了越界
                outBound = true;
                break;
            }
            index++;
        }
        if(outBound) {
            if(sign == 1) {
                return  Integer.MAX_VALUE;
            }
            else {
                return Integer.MIN_VALUE;
            }
        }


        return signExist? sign * res : res;
    }

    public static void main(String[] args) {
        new T8().myAtoi("  1231  123");
    }
}