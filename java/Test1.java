public class Test1 {
    public static void main(String[] args) {
        Tree[] t = new TestCase().t;
        System.out.println("[value]");
        for (int i = 0; i < t.length; i++) {
            System.out.print(i + ": ");
            System.out.println(t[i].value());
        }
    }
}
