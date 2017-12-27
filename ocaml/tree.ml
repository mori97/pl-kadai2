type tree = Leaf of int
          | BranchS of tree * tree
          | BranchM of tree * tree
          | BranchX of tree * tree

(* Kadai 2-2 *)
(* 畳み込み関数 *)
let rec fold lFunc sFunc mFunc xFunc t =
    match t with
      Leaf value -> lFunc value
    | BranchS (left, right) ->
        sFunc (fold lFunc sFunc mFunc xFunc left) (fold lFunc sFunc mFunc xFunc right)
    | BranchM (left, right) ->
        mFunc (fold lFunc sFunc mFunc xFunc left) (fold lFunc sFunc mFunc xFunc right)
    | BranchX (left, right) ->
        xFunc (fold lFunc sFunc mFunc xFunc left) (fold lFunc sFunc mFunc xFunc right);;

(* Kadai 1-2-1 *)
(* 計算木の価値を返す関数 *)
let rec value_of_tree t =
  match t with
    Leaf value -> value
  | BranchS (left, right) -> value_of_tree left + value_of_tree right
  | BranchM (left, right) -> value_of_tree left * value_of_tree right
  (* testcase に BranchX のテストを追加すると test1 がエラーを吐いてしまうので、
   * ダミーの値 (0) を返すようにしている *)
  | BranchX (_, _) -> 0;;

(* Kadai 1-2-2 *)
(* 計算木の価値を返す関数 *)
let rec value_of_tree2 t =
  let rec pow n m = (* n の m 乗 *)
    if m <= 0 then 1 else n * pow n (m - 1) in
  match t with
    Leaf value -> value
  | BranchS (left, right) -> value_of_tree2 left + value_of_tree2 right
  | BranchM (left, right) -> value_of_tree2 left * value_of_tree2 right
  | BranchX (left, right) -> pow (value_of_tree2 left) (value_of_tree2 right);;

(* Kadai 1-2-3 *)
(* 計算木の価値を表す計算式を出力する *)
let rec string_of_tree t =
  match t with
    Leaf value -> string_of_int value
  | BranchS (left, right) ->
     "(" ^ string_of_tree left ^ "+" ^ string_of_tree right ^ ")"
  | BranchM (left, right) ->
     "(" ^ string_of_tree left ^ "*" ^ string_of_tree right ^ ")"
  | BranchX (left, right) ->
     "(" ^ string_of_tree left ^ "^" ^ string_of_tree right ^ ")";;

(* Kadai 1-2-4 *)
(* 計算木の価値を表す計算式を、括弧を省いた形で出力する *)
let rec string_of_tree_fewer_parens t =
  match t with
    Leaf value -> string_of_int value
  | BranchS (left, right) ->
      (match (left, right) with
        (_, BranchS(_, _)) ->
          (* 右の部分だけを括弧で囲む場合 *)
          string_of_tree_fewer_parens left ^ "+("
          ^ string_of_tree_fewer_parens right ^ ")"
      | (_, _) ->
          (* 括弧で囲む必要がない場合 *)
          string_of_tree_fewer_parens left ^ "+"
          ^ string_of_tree_fewer_parens right)
  | BranchM (left, right) ->
      (match (left, right) with
        (BranchS (_, _), BranchS (_, _))
      | (BranchS (_, _), BranchM (_, _)) ->
          (* 両方を括弧で囲む場合 *)
          "(" ^ string_of_tree_fewer_parens left ^ ")*("
          ^ string_of_tree_fewer_parens right ^ ")"
      | (BranchS (_, _), _) ->
          (* 左の部分だけを括弧で囲む場合 *)
          "(" ^ string_of_tree_fewer_parens left ^ ")*"
          ^ string_of_tree_fewer_parens right
      | (_, BranchS (_, _))
      | (_, BranchM (_, _)) ->
          (* 右の部分だけを括弧で囲む場合 *)
          string_of_tree_fewer_parens left ^ "*("
          ^ string_of_tree_fewer_parens right ^ ")"
      | (_, _) ->
          (* 括弧で囲む必要がない場合 *)
          string_of_tree_fewer_parens left ^ "*"
          ^ string_of_tree_fewer_parens right)
  | BranchX (left, right) ->
      (match (left, right) with
        (Leaf _, Leaf _)
      | (Leaf _, BranchX (_, _)) ->
          (* 括弧で囲む必要がない場合 *)
          string_of_tree_fewer_parens left ^ "^"
          ^ string_of_tree_fewer_parens right
      | (Leaf _, _) ->
          (* 右の部分だけを括弧で囲む場合 *)
          string_of_tree_fewer_parens left ^ "^("
          ^ string_of_tree_fewer_parens right ^ ")"
      | (_, Leaf _)
      | (_, BranchX (_, _)) ->
          (* 左の部分だけを括弧で囲む場合 *)
          "(" ^ string_of_tree_fewer_parens left ^ ")^"
          ^ string_of_tree_fewer_parens right
      | (_, _) ->
          (* 両方を括弧で囲む場合 *)
          "(" ^ string_of_tree_fewer_parens left ^ ")^("
          ^ string_of_tree_fewer_parens right ^ ")");;

(* Kadai 1-2-5 *)
(* 計算木の葉の数を数える *)
let rec count_leaf t =
  match t with
    Leaf _ -> 1
  | BranchS (left, right)
  | BranchM (left, right)
  | BranchX (left, right) -> count_leaf left + count_leaf right;;

(* 計算木の高さを返す関数 *)
let rec height t =
  let max x y = if x > y then x else y in
  match t with
    Leaf _ -> 0
  | BranchS (left, right)
  | BranchM (left, right)
  | BranchX (left, right) -> max (height left) (height right) + 1;;

(* Kadai 1-2-6 *)
(* 木の簡約操作を行う *)
let rec reduce t =
    match t with
      Leaf _ -> t
    | BranchS (left, right)  ->
        (match (left, right) with
          (Leaf v1, Leaf v2) -> Leaf (v1 + v2)
        | (Leaf _, _) -> BranchS (left, reduce right)
        | (_, _) -> BranchS (reduce left, right))
    | BranchM (left, right)  ->
        (match (left, right) with
          (Leaf v1, Leaf v2) -> Leaf (v1 * v2)
        | (Leaf _, _) -> BranchM (left, reduce right)
        | (_, _) -> BranchM (reduce left, right))
    | BranchX (left, right)  ->
        (match (left, right) with
          (Leaf v1, Leaf v2) ->
            let rec pow n m = (* n の m 乗 *)
              if m <= 0 then 1 else n * pow n (m - 1) in
            Leaf (pow v1 v2)
        | (Leaf _, _) -> BranchX (left, reduce right)
        | (_, _) -> BranchX (reduce left, right));;

(* Kadai 1-2-7 *)
(* 計算木 t 中の n を格納した葉を全て計算木 t' で置き換える *)
let rec subst (t, n, t') =
    match t with
      Leaf value ->
        if value == n then t' else t
    | BranchS (left, right) ->
        BranchS (subst (left, n, t'), subst (right, n, t'))
    | BranchM (left, right) ->
        BranchM (subst (left, n, t'), subst (right, n, t'))
    | BranchX (left, right) ->
        BranchX (subst (left, n, t'), subst (right, n, t'))
