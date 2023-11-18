package interview75;

public class LCR122 {
    public String pathEncryption(String path) {
        StringBuilder sb = new StringBuilder();
        char[] chars = path.toCharArray();
        for(char c : chars) {
            sb.append(c == '.' ? ' ': c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        
        // String b = new String("122");
        String a = "122";
        String b = "122";
        System.out.println(a == b);
    }
}