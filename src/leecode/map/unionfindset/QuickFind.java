package leecode.map.unionfindset;

//合并效率较低
public class QuickFind {
    int[] root;

    //O(N)
    public QuickFind(int size) {
        root = new int[size];
        for(int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    //O(1)查询x节点的根节点
    public int find(int x) {
        return root[x];
    }

    //O(N) x和y合并
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        //若根节点相同则已经属于同一联通量，无需合并
        //否则需要合并，这里默认将根节点为rootY的节点合并到rootX下
        if(rootX != rootY) {
            for(int i = 0; i < root.length; i++) {
                if(root[i] == rootY) {
                    root[i] = rootX;
                }
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
