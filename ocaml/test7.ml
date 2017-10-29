open Tree
open Testcase

let () =
  let rec separate l =
    match l with
      [] -> []
    | x::[] -> []
    | x::y::tl -> (x, 3, y)::(separate tl) in
  let l = separate test_case in
  print_endline "[subst]";
  print_list (fun t -> (string_of_tree (subst t))) l 0
