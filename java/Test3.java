public class Test3 {
    public static void main(String[] args) {
        Tree[] t = new TestCase().t;
        System.out.println("[toString]");
        for (int i = 0; i < t.length; i++) {
            System.out.print(i + ": ");
            System.out.println(t[i].toString());
        }
    }
}
