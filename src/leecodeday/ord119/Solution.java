package leecodeday.ord119;

public class Solution {

    public static void changeCuu(Cuu cuu) {
        cuu.setHello(1000);
    }

    public static void changeA(int a) {
        a = -1;
    }
    public static void main(String[] args) {
        Cuu cuu = new Cuu();
        System.out.println(cuu.getHello());
        Solution.changeCuu(cuu);
        System.out.println(cuu.getHello());

        int a = 1;
        changeA(a);
        System.out.println(a);
    }
}


class Cuu {
    private int hello = 1;

    public int getHello() {
        return hello;
    }

    public void setHello(int hello) {
        this.hello = hello;
    }
    
}

