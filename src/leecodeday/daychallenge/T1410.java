package leecodeday.daychallenge;

import java.util.HashMap;
import java.util.Map;

public class T1410 {

    public Trie root;

    public String entityParser(String text) {
        root = new Trie();
        addString("&quot;", '"');
        addString("&apos;", '\'');
        addString("&amp;", '&');
        addString("&gt;", '>');
        addString("&lt;", '<');
        addString("&frasl;", '/');

        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = text.toCharArray();
        int n = charArray.length;

        int index = 0;
        boolean isCheck = false;
        int start = 0;
        Trie cur = root;
        while(index < n) {
            if(charArray[index] == '&') {
                isCheck = false;
                cur = root;
                start = index;
                while(index < n && !isCheck) {
                    if(cur.next.get(charArray[index]) == null) {
                        break;
                    }
                    cur = cur.next.get(charArray[index]);
                    if(cur.sign != null) {
                        isCheck = true;
                        stringBuilder.append(cur.sign);
                    }
                    index++;
                }

                if(!isCheck) {
                    //检查当前元素是否等于&
                    if(index < n - 1 && charArray[index] == '&') {
                        index--;
                    }
                    stringBuilder.append(text.substring(start, index + 1));
                }
                else {
                    index--;
                }
            }
            else {
                stringBuilder.append(charArray[index]);
            }
            index++;
        }

        return stringBuilder.toString(); 
    }

    public void addString(String key, Character value) {
        Trie cur = root;
        char[] charArray = key.toCharArray();
        for(char c : charArray) {
            if(cur.next.get(c) == null) {
                cur.next.put(c, new Trie());
            }
            cur = cur.next.get(c);
        }
        cur.sign = value;
    }


    public static void main(String[] args) {
        System.out.println(new T1410().entityParser("&&&"));
    }
}

class Trie {
    public Map<Character, Trie> next;
    public Character sign;

    public Trie() {
        this.next = new HashMap<>();
        this.sign = null;
    }
}
