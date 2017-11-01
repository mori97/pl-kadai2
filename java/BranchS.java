public class BranchS implements Tree {
    // 部分木
    private Tree left;
    private Tree right;

    /**
     * コンストラクタ
     *
     * @param left   左の部分木
     * @param right  右の部分木
     */
    public BranchS(Tree left, Tree right) {
        this.left = left;
        this.right = right;
    }

    /**
     * 枝の価値を返すメソッド
     *
     * @return この枝の価値
     */
    public int value() {
        return left.value() + right.value();
    }

    /**
     * 計算木の価値を表す計算式を出力する
     *
     * @return  計算式の文字列
     */
    public String toString() {
        return String.format("(%s+%s)", left.toString(), right.toString());
    }

    /**
     * 計算木の価値を表す計算式を、括弧を省いた形で出力する
     *
     * @return 計算式の文字列
     */
    public String toStringFewerParens() {
        if (right instanceof BranchS) {
            return String.format("%s+(%s)",
                                 left.toStringFewerParens(),
                                 right.toStringFewerParens());
        } else {
            return String.format("%s+%s",
                                 left.toStringFewerParens(),
                                 right.toStringFewerParens());
        }
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
            return new Leaf(this.left.value() + this.right.value());
        } else if (this.left instanceof Leaf) {
            return new BranchS(this.left, this.right.reduce());
        } else {
            return new BranchS(this.left.reduce(), this.right);
        }
    }
}
