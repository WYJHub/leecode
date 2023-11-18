package trie;

import java.util.HashMap;
import java.util.Map;

//实现一个前缀树
//使用前缀树匹配一个长度为m的字符串所需时间为o(m)
//初次之外，使用hash表来匹配前缀则需要o（n），n为前缀的数量

public class Trie {
    Map<Character, Trie> next;
    boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        this.next = new HashMap<>();
        this.isEnd = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie cur = this;
        char[] charArray = word.toCharArray();
        for(char c : charArray) {
            if(cur.next.get(c) == null) {
                cur.next.put(c, new Trie());
            }
            cur = cur.next.get(c);
        }
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie searchPrefix = searchPrefix(word);
        return searchPrefix != null && searchPrefix.isEnd;
        // Trie cur = this;
        // char[] charArray = word.toCharArray();
        // for(char c : charArray) {
        //     if(cur.next.get(c) == null) {
        //         return false;
        //     }
        //     cur = cur.next.get(c);
        // }
        // return cur.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
        // Trie cur = this;
        // char[] charArray = prefix.toCharArray();
        // for(char c : charArray) {
        //     if(cur.next.get(c) == null) {
        //         return false;
        //     }
        //     cur = cur.next.get(c);
        // }
        // return true;
    }

    public Trie searchPrefix(String prefix) {
        Trie cur = this;
        char[] charArray = prefix.toCharArray();
        for(char c : charArray) {
            if(cur.next.get(c) == null) {
                return null;
            }
            cur = cur.next.get(c);
        }
        return cur;
    }
}
