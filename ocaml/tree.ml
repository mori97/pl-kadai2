type tree = Leaf of int
          | BranchS of tree * tree
          | BranchM of tree * tree
          | BranchX of tree * tree

(* Kadai 1-2-1 *)
(* 計算木の価値を返す関数 *)
let rec value_of_tree t =
  match t with
    Leaf value -> value
  | BranchS (left, right) -> value_of_tree left + value_of_tree right
  | BranchM (left, right) -> value_of_tree left * value_of_tree right;;

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
          string_of_tree_fewer_parens left ^ "+("
          ^ string_of_tree_fewer_parens right ^ ")"
      | (_, _) ->
          string_of_tree_fewer_parens left ^ "+"
          ^ string_of_tree_fewer_parens right)
  | BranchM (left, right) ->
      (match (left, right) with
        (BranchS (_, _), BranchS (_, _)) ->
          "(" ^ string_of_tree_fewer_parens left ^ ")*("
          ^ string_of_tree_fewer_parens right ^ ")"
      | (BranchS (_, _), BranchM (_, _)) ->
          "(" ^ string_of_tree_fewer_parens left ^ ")*("
          ^ string_of_tree_fewer_parens right ^ ")"
      | (BranchS (_, _), _) ->
          "(" ^ string_of_tree_fewer_parens left ^ ")*"
          ^ string_of_tree_fewer_parens right
      | (_, BranchS (_, _)) ->
          string_of_tree_fewer_parens left ^ "*("
          ^ string_of_tree_fewer_parens right ^ ")"
      | (_, BranchM (_, _)) ->
          string_of_tree_fewer_parens left ^ "*("
          ^ string_of_tree_fewer_parens right ^ ")"
      | (_, _) ->
          string_of_tree_fewer_parens left ^ "*"
          ^ string_of_tree_fewer_parens right)
  | BranchX (left, right) ->
      (match (left, right) with
        (Leaf _, Leaf _) ->
          string_of_tree_fewer_parens left ^ "^"
          ^ string_of_tree_fewer_parens right
      | (Leaf _, BranchX (_, _)) ->
          string_of_tree_fewer_parens left ^ "^"
          ^ string_of_tree_fewer_parens right
      | (Leaf _, _) ->
          string_of_tree_fewer_parens left ^ "^("
          ^ string_of_tree_fewer_parens right ^ ")"
      | (_, Leaf _) ->
          "(" ^ string_of_tree_fewer_parens left ^ ")^"
          ^ string_of_tree_fewer_parens right
      | (_, BranchX (_, _)) ->
          "(" ^ string_of_tree_fewer_parens left ^ ")^"
          ^ string_of_tree_fewer_parens right
      | (_, _) ->
          "(" ^ string_of_tree_fewer_parens left ^ ")^("
          ^ string_of_tree_fewer_parens right ^ ")");;

(* Kadai 1-2-5
let count_leaf t = (* FILL IN HERE *)

let height t = (* FILL IN HERE *)
 *)

(* Kadai 1-2-6
let reduce(t) = (* FILL IN HERE *)
 *)

(* Kadai 1-2-7
let subst(t, n, t') = (* FILL IN HERE *)
*)
