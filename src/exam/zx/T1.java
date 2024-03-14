package exam.zx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Map.Entry;

import org.w3c.dom.Node;

public class T1 {

    /**
     4 2
     2 1 1
     2 3 1
     3 4 1
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();//首领星球编号
        
        ArrayList<HashMap<Integer, Integer>> edges = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            edges.add(new HashMap<Integer, Integer>());
        }
        sc.nextLine();
        while(sc.hasNextLine()) {
            String a= sc.nextLine();
            if(a.isEmpty()) {
                break;
            }
            // System.out.println(a.charAt(0));
            String[] split = a.split(" ");
            edges.get(Integer.parseInt(split[0])).put(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        }
        sc.close();
        //寻找K到其他所有节点的最短路径，并求出最小值
        HashMap<Integer, Integer> distanceMap = new T1().dijkstra(K, N, edges);

        if(distanceMap.size() < N) {
            System.out.println(-1);
        }
        int max = 0;
        for(int value : distanceMap.values()) {
            max = Math.max(value, max);
        }
        System.out.println(max);
    }

    public HashMap<Integer, Integer> dijkstra(int K, int N, ArrayList<HashMap<Integer, Integer>> edges) {
        HashMap<Integer, Integer> distanceMap = new HashMap<>();
        distanceMap.put(K, 0);
        //已经求过距离的点
		HashSet<Integer> selectedNodes = new HashSet<>();
		//distanceMap中找到不在selectedNodes中的最小距离的点
		int minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
		while (minNode != -1) {
			int distance = distanceMap.get(minNode);
			for (Entry<Integer, Integer> edge : edges.get(minNode).entrySet()) {
                if(!distanceMap.containsKey(edge.getKey())) {
                    distanceMap.put(edge.getKey(), distance + edge.getValue());
                }
                distanceMap.put(edge.getKey(), distance + edge.getValue());
			}
			selectedNodes.add(minNode);
			minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
		}
        return distanceMap;
    }

    public static int getMinDistanceAndUnselectedNode(HashMap<Integer, Integer> distanceMap, HashSet<Integer> touchedNodes) {
		int minNode = -1;
		int minDistance = Integer.MAX_VALUE;
		for (Entry<Integer, Integer> entry : distanceMap.entrySet()) {
			Integer node = entry.getKey();
			int distance = entry.getValue();
			if (!touchedNodes.contains(node) && distance < minDistance) {
				minNode = node;
				minDistance = distance;
			}
		}
		return minNode;
	}

}
