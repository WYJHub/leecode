package leecodeday.daychallenge;

import java.util.ArrayList;
import java.util.List;

public class T1462 {
    List<List<Integer>> edges;
    int[] visited;
    int[][] exist;

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        //图中没有环
        int n = queries.length;

        List<Boolean> res = new ArrayList<Boolean>();
        edges = new ArrayList<List<Integer>>();
        visited = new int[numCourses];
        exist = new int[numCourses][numCourses];

        for(int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        int edgeSum = prerequisites.length;
        for(int i = 0; i < edgeSum; i++) {
            int u = prerequisites[i][0], v = prerequisites[i][1];
            edges.get(u).add(v);
        }

        for(int i = 0; i < numCourses; i++) {
            if(visited[i] == 0) {
                dfs(i);
            }
        }

        for(int i = 0; i < n; i++) {
            res.add(exist[queries[i][0]][queries[i][1]] == 1);
        }

        return res;
    }

    public void dfs(int u) {
        visited[u] = 1;

        for(int v : edges.get(u)) {
            if(visited[v] == 0) {
                dfs(v);
            }
            exist[u][v] = 1;
            for(int i = 0; i < exist.length; i++) {
                exist[u][i] = Math.max(exist[u][v] * exist[v][i], exist[u][i]);
            }
        }
    }

    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = new int[][]{{1,2}, {1, 0}, {2, 0}};
        int[][] queries = new int[][]{{1,0},{1,2}};
        List<Boolean> res = new T1462().checkIfPrerequisite(numCourses, prerequisites, queries);

        for(Boolean r : res) {
            System.out.println(r);
        }
    }
}
