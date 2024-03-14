package leecode.map.unionfindset;

//路径压缩并查集
public class PathCompressionUnionFind {
    int root[];

    public PathCompressionUnionFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    //优化了find函数，O(logN)，递规找到真正的根节点，路径压缩,root[x]存放真正的根节点
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    //O(logN)
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    };

    //O(logN)
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
