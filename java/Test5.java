public class Test5 {
    public static void main(String[] args) {
        Tree[] t = new TestCase().t;
        System.out.println("[countLeaf]");
        for (int i = 0; i < t.length; i++) {
            System.out.print(i + ": ");
            System.out.println(t[i].countLeaf());
        }
        System.out.println("[height]");
        for (int i = 0; i < t.length; i++) {
            System.out.print(i + ": ");
            System.out.println(t[i].height());
        }
    }
}
