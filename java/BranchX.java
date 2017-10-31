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
        return (int)Math.pow(left.value(), right.value());
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
}
