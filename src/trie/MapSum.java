package trie;

public class MapSum {

    Trie root;
    /** Initialize your data structure here. */
    public MapSum() {
        this.root = new Trie();
    }
    
    public void insert(String key, int val) {
        char[] charArray = key.toCharArray();
        Trie cur = root;
        for(char c : charArray) {
            if(cur.next[c - 'a'] == null) {
                cur.next[c - 'a'] = new Trie();
            }
            cur = cur.next[c - 'a'];
        }
        cur.isEnd = true;
        cur.val = val;
    }
    
    public int sum(String prefix) {
        char[] charArray = prefix.toCharArray();
        Trie cur = root;
        for(char c : charArray) {
            if(cur.next[c - 'a'] == null) {
                return 0;
            }
            cur = cur.next[c - 'a'];
        }
        //当前cur指向末尾，需要深搜，找到所有后续
        int sum = 0;
        return dfs(cur);
    }

    public int dfs(Trie trie) {
        int length = 0;
        if(trie.isEnd) {
            length += trie.val;
        }
        for(int i = 0; i < 26; i++) {
            if(trie.next[i] != null) {
                length += dfs(trie.next[i]);
            }
        }
        return length;
    }
}

class Trie {
    Trie[] next;
    boolean isEnd;
    int val;

    public Trie(){
        this.next = new Trie[26];
        this.isEnd = false;
        this.val = 0;
    }
}
