package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<List<String>> res = new ArrayList<>();
        String[] arr = {"A", "B", "C", "D"};
        List<String> list = Arrays.asList(arr);
        res.add(new ArrayList<>(list));
    }
}
