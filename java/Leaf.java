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
}
