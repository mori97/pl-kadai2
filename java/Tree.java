import java.util.function.*;


public interface Tree {
    public int value();
    public String toString();             // Kadai 1-1-3
    public String toStringFewerParens();  // Kadai 1-1-4
    public int countLeaf();               // Kadai 1-1-5
    public int height();
    public Tree reduce();                 // Kadai 1-1-6
    public Tree subst(int n, Tree t);     // Kadai 1-1-7
    public <R> R fold(IntFunction<R> e,
                      BinaryOperator<R> f1,
                      BinaryOperator<R> f2,
                      BinaryOperator<R> f3);    // kadai 2-1
}
