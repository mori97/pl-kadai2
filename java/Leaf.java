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
}
