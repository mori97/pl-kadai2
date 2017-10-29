public class Test7 {
    public static void main(String[] args) {
        Tree[] t = new TestCase().t;
        System.out.println("[subst]");
        for (int i = 0; i < t.length; i += 2) {
            System.out.print((i/2) + ": ");
            System.out.println(t[i].subst(3, t[i+1]));
        }
    }
}
