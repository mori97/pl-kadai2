# 工学部専門科目「プログラミング言語」(2017年度)

## 課題2 (締切 1/14 (日) 23:59)

### 課題2-1

配布資料(11)と(12)を参考に課題1の計算木のデータ構造(Java版)に対して，メソッド `<R> R fold(R e, BinaryOperator<R> f1, BinaryOperator<R> f2)` (タイプXの枝を追加している場合には，引数がひとつ増えて，`<R> R fold(IntFunction<R> e, BinaryOperator<R> f1, BinaryOperator<R> f2, BinaryOperator<R> f3)` となる)を定義せよ．ただし `IntFunction<R>` と `BinaryOperator<T>` は以下で定義されるインターフェースで，前者は `int` を受け取って `R` を返す関数，後者は同じ`T`型の2つの引数を受け取り，演算を行い，引数と`T`型の値を返す関数を表すためのインターフェースである．

```{.java}
// java.util.function パッケージに定義されているので，そこから import して使うこと
public interface IntFunction<T> {
    T apply(int i);
}
public interface BinaryOperator<T> extends BiFunction<T,T,T> {
    T apply(T left, T right);
}
```

その上で，課題1-1-1(もしくは課題 1-1-2)の `value` メソッド，1-1-3 の `ToString` メソッドと同じ処理を，`fold` とラムダ式を使って表すにはどのようにすればよいか答えよ．

#### ヒント

`Tree` 型の変数 `t` に対して `t.value()` と同じ値を得るためには，`t` に対する `fold` の呼出しをどのように書けばよいかということである．具体的には

```{.java}
t.<Integer>fold(x -> x, ...);     // value の場合
t.<String>fold(x -> "" + x, ...); // toString の場合
```

のようになるので，`...` 部分を考えて答えよ．

### 課題2-2

課題1の計算木のデータ構造(OCaml版)に対して，以下の型の fold 関数
```{.ocaml}
val fold : (int -> 'a) -> ('a -> 'a -> 'a) -> ('a -> 'a -> 'a) -> tree -> 'a
```
を定義せよ．(タイプXの枝を追加している場合には
```{.ocaml}
val fold : (int -> 'a) -> ('a -> 'a -> 'a) -> ('a -> 'a -> 'a) -> ('a -> 'a -> 'a) -> tree -> 'a
```
となる．)

その上で，課題1-2-1の関数 `value_of_tree t` (もしくは 1-2-2 の `value_of_tree2 t`)，課題1-2-3 の `string_of_tree t` を `fold` を使って定義し直せ．

#### ヒント:
```{.ocaml}
let value_of_tree t = fold (fun x -> x) ...

let string_of_tree t = fold string_of_int ...
```
## プログラム作成上の注意

* プログラムは課題1で作成したものを修正せよ．
* コンパイルができないプログラムを提出した場合には採点の対象外となる．
* Java のパッケージ機能は(コンパイルする環境に依存しがちなので)使わないこと．

## 提出要領

2. Java プログラムおよびそのテストは `java` フォルダに入れること．OCaml プログラムおよびそのテストは `ocaml` フォルダに入れること．
3. プログラムの説明を `report.md` (Markdown もしくは plain text 形式)に書け．課題毎に説明すること．内容だけでなく読みやすさも採点の対象となる．これは，この `README.md` と同じフォルダに置くこと．(上記のURLからダウンロードすると雛形が含まれている．)
4. プログラムの説明を入れたフォルダを圧縮して zip ファイルを作り，PandA で提出すること．
