package leecode.trie;

public class MagicDictionary {

    Trie root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.root = new Trie();
    }
    
    public void buildDict(String[] dictionary) {
        for(String string : dictionary) {
            char[] charArray = string.toCharArray();
            Trie cur = this.root;
            for(char c : charArray) {
                if(cur.tries[c - 'a'] == null) {
                    cur.tries[c - 'a'] = new Trie();
                }
                cur = cur.tries[c - 'a'];
            }
            cur.isEnd = true;
        }
    }
    
    public boolean search(String searchWord) {
        return dfs(searchWord, root, 0, false);
    }

    public boolean dfs(String searchWord, Trie node, int pos, boolean modified) {
        //深搜
        //两者长度一致时，判断是否以及修改，并且字典树中存在此单词
        if(pos == searchWord.length()) {
            return modified && node.isEnd;
        }
        
        //如果存在当前pos对应的节点
        int index = searchWord.charAt(pos) - 'a';
        if(node.tries[index] != null) {
            if(dfs(searchWord, node.tries[index], pos + 1, modified)) {
                return true;
            }
        }
        //若还未修改过，检查该节点其他非空节点
        if(!modified) {
            modified = true;
            for(int i = 0; i < 26; i++) {
                if(i != index && node.tries[i] != null) {
                    if(dfs(searchWord, node.tries[i], pos + 1, modified)) {
                        return true;
                    }
                }
            }
        }

        //不存在当前pos对应节点
        return false;
    }
}

class Trie {
    Trie[] tries;
    boolean isEnd;

    public Trie() {
        this.tries = new Trie[26];
        this.isEnd = false;
    }
}
