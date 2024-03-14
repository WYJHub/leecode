package leecode.map.unionfindset;

//按秩优化的并查集，避免节点连成一条直线
public class RankUnionFind {
    int root[];
    int rank[];

    public RankUnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1; 
        }
    }

    //O(logN)
    public int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }
    //O(logN)
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    };
    //O(logN)
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
