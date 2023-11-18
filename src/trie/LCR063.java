package trie;

import java.util.List;

// sentence 仅由小写字母和空格组成。
public class LCR063 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        //先将dictionary中所有前缀插入字典树
        for(String word : dictionary) {
            Trie cur = trie;
            char[] charArray = word.toCharArray();
            for(char c : charArray) {
                if(cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new Trie();
                }
                cur = cur.next[c - 'a'];
            }
            cur.isEnd = true;
        }
        
        String[] split = sentence.split(" ");
        for(String word : split) {
            word = findPrefix(word, trie);
        }
        return String.join(" ", split);
    }

    public String findPrefix(String word, Trie trie) {
        Trie cur = trie;
        char[] charArray = word.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(char c : charArray) {
            if(cur.next[c - 'a'] == null) {
                return word;
            }
            stringBuilder.append(c);
            if(cur.next[c - 'a'].isEnd == true) {
                break;
            }
            cur = cur.next[c - 'a'];
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
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
