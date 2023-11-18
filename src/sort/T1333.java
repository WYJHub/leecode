package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


// sort的lambda排序
//有Collections.sort()内层为list.sort
//list.sort()内层为Arrays.sort
//Arrays.sort()


//lambda表达式为(o1, o1) -> {return o1 - o2}, 默认升序排列
public class T1333 {

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> resList = new ArrayList<>();
        int n = restaurants.length;
        List<int[]> restaurantsList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(restaurants[i][2] >= veganFriendly && restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance) {
                restaurantsList.add(restaurants[i]);
            }
        }

        /**
         * 在sort中默认为r1 - r2,
         * 若r1 - r2 < 0，则认为 r1 < r2, 将r1排在前面，即按从小到大的顺序排列
         * 为了能够降序排列，修改r1 - r2为 r2 - r1
         */
        restaurantsList.sort((r1, r2) -> {
            if(r1[1] != r2[1]) {
                return r2[1] - r1[1];
            }
            return r2[0] - r1[0];
        });

        for(int[] restaurant : restaurantsList) {
            resList.add(restaurant[0]);
        }
        return resList;
    }
}
