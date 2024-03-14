package leecode.hash;

public class HashMapTest {
    public static void main(String[] args) throws ClassNotFoundException {
        int[] table = null;
        int[] tab = new int[1];
        if((tab = table) == null) {
            System.out.println("将table的值传递给tab并且判断传递后tab是否为null");
            System.out.println(tab);
        }

        ClassLoader classLoader = LRU.class.getClassLoader();
        //类加载器加载类，该方法仅仅只是将.class文件记载到jvm中，不会执行static中的内容
        // classLoader.loadClass("hash.LRU");
        //使用类的全限定名来加载类，Class.forName会加载静态代码块，可以看到有语句输出
        Class.forName("hash.LRU");
    }
}
