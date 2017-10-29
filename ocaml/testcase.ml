open Tree

let test_case =
  [ BranchS (BranchM (Leaf 2, Leaf 4), Leaf 3);
    BranchM (BranchS (Leaf 2, Leaf 4), Leaf 3);
    BranchS (BranchS (Leaf 1, Leaf 2), Leaf 3);
    BranchS (Leaf 1, BranchS (Leaf 2, Leaf 3));
    BranchM (BranchM (Leaf 1, Leaf 2), Leaf 3);
    BranchM (Leaf 1, BranchM (Leaf 2, Leaf 3));
    BranchM (BranchS (Leaf 1, Leaf 2), BranchS (Leaf 3, Leaf 4));
    BranchM (Leaf 6, Leaf 7);
    BranchS (BranchM (Leaf 1, Leaf 2), BranchM (Leaf 3, Leaf 4));
    BranchM (BranchS (Leaf 1, BranchM (Leaf 2, Leaf 3)), BranchM (BranchM (Leaf 4, Leaf 5), BranchS (Leaf 6, Leaf 7)));
  ]

let rec print_list f l i =
  match l with
    [] -> ()
  | hd::tl ->
     print_int i;
     print_string ": ";
     print_endline (f hd);
     print_list f tl (i+1)
let print_test_case f =
  print_list f test_case 0
