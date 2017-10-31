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
}
