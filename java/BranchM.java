public class BranchM implements Tree {
    // 部分木
    private Tree left;
    private Tree right;

    /**
     * コンストラクタ
     *
     * @param left   左の部分木
     * @param right  右の部分木
     */
    public BranchM(Tree left, Tree right) {
        this.left = left;
        this.right = right;
    }

    /**
     * 枝の価値を返すメソッド
     *
     * @return この枝の価値
     */
    public int value() {
        return left.value() * right.value();
    }

    /**
     * 計算木の価値を表す計算式を出力する
     *
     * @return  計算式の文字列
     */
    public String toString() {
        return String.format("(%s*%s)", left.toString(), right.toString());
    }

    /**
     * 計算木の価値を表す計算式を、括弧を省いた形で出力する
     *
     * @return 計算式の文字列
     */
    public String toStringFewerParens() {
        String leftString, rightString;
        if (left instanceof BranchS) {
            leftString = String.format("(%s)", left.toStringFewerParens());
        } else {
            leftString = left.toStringFewerParens();
        }

        if ((right instanceof BranchS) || (right instanceof BranchM)) {
            rightString = String.format("(%s)", right.toStringFewerParens());
        } else {
            rightString = right.toStringFewerParens();
        }

        return String.format("%s*%s", leftString, rightString);
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
}
