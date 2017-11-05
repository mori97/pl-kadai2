type tree = Leaf of int
          | BranchS of tree * tree
          | BranchM of tree * tree

(* Kadai 1-2-1 *)
(* 計算木の価値を返す関数 *)
let rec value_of_tree t =
  match t with
    Leaf value -> value
  | BranchS (left, right) -> value_of_tree left + value_of_tree right
  | BranchM (left, right) -> value_of_tree left * value_of_tree right;;

(* Kadai 1-2-2
let value_of_tree2(t) = (* FILL IN HERE *)
*)

(* Kadai 1-2-3
let string_of_tree(t) = (* FILL IN HERE *)
*)

(* Kadai 1-2-4
let string_of_tree_fewer_parens(t) = (* FILL IN HERE *)
 *)

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
