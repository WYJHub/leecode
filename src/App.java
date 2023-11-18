import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // List<String> res = new ArrayList<>();
        // // int a = 112;
        // // String string = Integer.toString(a);
        // StringBuilder stringBuilder = new StringBuilder();
        // // stringBuilder.append(string);
        // List<Integer> list = Arrays.asList(1,2,3,4,5);
        // for(Integer i : list) {
        //     System.out.println(i);
        // }
        int[] a = new int[]{4,2,1};
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 1; i <= 20; i++) {
            int start = new Random().nextInt(i);
            int end = start + new Random().nextInt(i - start);
            list.add(new int[]{start, end});
        }
        int[][] intervals = list.toArray(new int[list.size()][0]);
        // Arrays.sort(a, (int num1, int num2) -> num1.compareTo(num2));
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                if(interval1[0] == interval2[0]) {
                    return interval2[1] - interval1[1];
                }
                return interval1[0] - interval2[0];
            }
        });
        for(int i = 0; i < 20; i++) {
            System.out.println(intervals[i][0] + " " + intervals[i][1]);
        }

        // for(int i = 0; i < a.length; i++){
        //     System.out.println(a[i]);
        // }
        // int[][] res = new int[0][2];
        // System.out.println(res);
        // System.out.println(res == null);
        // for(int i = 0; i < res.length; i++) {
        //     System.out.println(res[i][0] + " " + res[i][1]);
        // }
        // Collections.reverseOrder();
    }
}
