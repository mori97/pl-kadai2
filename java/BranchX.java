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
}
