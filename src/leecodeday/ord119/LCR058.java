package leecodeday.ord119;

import java.util.Comparator;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.Stack;
import java.util.TreeSet;

public class LCR058 {

    TreeSet<int[]> booked;

    public LCR058() {
        booked = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
    }

    public boolean book(int start, int end) {
        if(booked.isEmpty()) {
            booked.add(new int[]{start, end});
            return true;
        }
        int[] tmp = {end, 0};
        int[] arr = booked.ceiling(tmp);
        // int[] prev = arr == null? booked.last() : booked.lower(arr);
        if(arr == booked.first() || booked.lower(tmp)[1] <= start) {
            booked.add(new int[]{start, end});
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        LCR058 s = new LCR058();
        System.out.println(s.book(10, 20));
        System.out.println(s.book(15, 25));
        System.out.println(s.book(20, 30));
    }
}
