package leecode.map.unionfindset;

public class UnionFind {
    int root[];

    //O(N)
    public UnionFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    //O(H)
    public int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }

    //O(H)
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    };

    //O(H)
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

}
