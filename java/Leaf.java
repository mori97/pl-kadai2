import java.util.function.*;


public class Leaf implements Tree {
    // 葉の価値
    private int value;

    /**
     * コンストラクタ
     * 
     * @param value 葉の価値
     */
    public Leaf(int value) {
        this.value = value;
    }

    /**
     * 葉の価値を返すメソッド
     *
     * @return この葉の価値
     */
    public int value() {
        return this.value;
    }

    /**
     * 計算木の価値を表す計算式を出力する
     *
     * @return  計算式の文字列
     */
    public String toString() {
        return Integer.toString(this.value);
    }

    /**
     * 計算木の価値を表す計算式を、括弧を省いた形で出力する
     *
     * @return 計算式の文字列
     */
    public String toStringFewerParens() {
        return Integer.toString(this.value);
    }

    /**
     * 計算木の葉の数を数える
     *
     * @return 葉の数
     */
    public int countLeaf() {
        return 1;
    }

    /**
     * 計算木の高さを計算する
     *
     * @return 計算木の高さ
     */
    public int height() {
        return 0;
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
        return this;
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
        if (this.value == n) {
            return t;
        } else {
            return this;
        }
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
        return e.apply(this.value);
    }
}
