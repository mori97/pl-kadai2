import java.util.function.*;


public class BranchX implements Tree {
    // 部分木
    private Tree left;
    private Tree right;

    /**
     * コンストラクタ
     *
     * @param left   左の部分木
     * @param right  右の部分木
     */
    public BranchX(Tree left, Tree right) {
        this.left = left;
        this.right = right;
    }

    /**
     * 枝の価値を返すメソッド
     *
     * @return この枝の価値
     */
    public int value() {
        return this.fold(value -> value,
                         (left, right) -> left + right,
                         (left, right) -> left * right,
                         (left, right) -> (int)Math.pow(left, right));
    }

    /**
     * 計算木の価値を表す計算式を出力する
     *
     * @return  計算式の文字列
     */
    public String toString() {
        return String.format("(%s^%s)", left.toString(), right.toString());
    }

    /**
     * 計算木の価値を表す計算式を、括弧を省いた形で出力する
     *
     * @return 計算式の文字列
     */
    public String toStringFewerParens() {
        String leftString, rightString;
        if (left instanceof Leaf) {
            leftString = left.toStringFewerParens();
        } else {
            leftString = String.format("(%s)", left.toStringFewerParens());
        }

        if ((right instanceof Leaf) || (right instanceof BranchX)) {
            rightString = right.toStringFewerParens();
        } else {
            rightString = String.format("(%s)", right.toStringFewerParens());
        }

        return String.format("%s^%s", leftString, rightString);
    }

    /**
     * 計算木の葉の数を数える
     *
     * @return 葉の数
     */
    public int countLeaf() {
        return left.countLeaf() + right.countLeaf();
    }

    /**
     * 計算木の高さを計算する
     *
     * @return 計算木の高さ
     */
    public int height() {
        return Math.max(left.height(), right.height()) + 1;
    }

    /**
     * 木を簡約操作を行い、簡約された計算木を返す。元の計算木は影響されない。
     *
     * ふたつの葉を部分木として持つ枝一箇所を選んで、その部分木をその
     * 部分木の価値を格納した葉で置換する。木に該当箇所がひとつもない場合には，
     * 入力された木がそのまま出力となる。
     *
     * @return 新しい計算木
     */
    public Tree reduce() {
        if ((this.left instanceof Leaf) && (this.right instanceof Leaf)) {
            return new Leaf((int) Math.pow(this.left.value(),
                                           this.right.value()));
        } else if (this.left instanceof Leaf) {
            return new BranchX(this.left, this.right.reduce());
        } else {
            return new BranchX(this.left.reduce(), this.right);
        }
    }

    /**
     * 計算木中の n を格納した葉を全て計算木 t で置き換えたような計算木を
     * 生成する
     *
     * @param   n     値 n を格納する葉を置換する
     * @param   t     置換用の(計算木)部分木
     * @return        新しい計算木
     */
    public Tree subst(int n, Tree t) {
        return new BranchX(this.left.subst(n, t), this.right.subst(n, t));
    }

    /**
     * 畳み込み関数。
     *
     * @param   e    葉の場合に適用する関数。
     * @param   f1   ブランチ S の場合に適用する関数。
     * @param   f2   ブランチ M の場合に適用する関数。
     * @param   f3   ブランチ X の場合に適用する関数。
     */
    public <R> R fold(IntFunction<R> e,
                      BinaryOperator<R> f1,
                      BinaryOperator<R> f2,
                      BinaryOperator<R> f3) {
        R leftTree = this.left.fold(e, f1, f2, f3);
        R rightTree = this.right.fold(e, f1, f2, f3);
        return f3.apply(leftTree, rightTree);
    }
}
