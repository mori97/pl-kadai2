public class Test4 {
    public static void main(String[] args) {
        Tree[] t = new TestCase().t;
        System.out.println("[toStringFewerParens]");
        for (int i = 0; i < t.length; i++) {
            System.out.print(i + ": ");
            System.out.println(t[i].toStringFewerParens());
        }
    }
}
