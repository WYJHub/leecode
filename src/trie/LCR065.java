package trie;

public class LCR065 {
    // 后缀树
    public int minimumLengthEncoding(String[] words) {
        int miniEncoding = 0;

        //构建前缀树
        Trie root = new Trie();
        for(String word : words) {
            char[] charArray = word.toCharArray();
            int n = charArray.length;
            Trie cur = root;
            for(int i = n - 1; i >= 0; i--) {
                if(cur.next[charArray[i] - 'a'] == null) {
                    cur.next[charArray[i] - 'a'] = new Trie();
                }
                cur = cur.next[charArray[i] - 'a'];
                if(cur.isEnd) {
                    miniEncoding -= (n - i + 1);
                    cur.isEnd = false;
                }
            }
            cur.isEnd = true;
            //遍历检查该节点是否有后续
            for(int i = 0; i < 26; i++) {
                if(cur.next[i] != null) {
                    cur.isEnd = false;
                }
            }
            miniEncoding += cur.isEnd? n + 1 : 0;
        }

        return miniEncoding;
    }
}

class Trie {
    Trie[] next;
    boolean isEnd;

    public Trie() {
        this.next = new Trie[26];
        this.isEnd = false;
    }
}
