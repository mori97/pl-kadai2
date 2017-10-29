open Tree
open Testcase

let () =
  print_endline "[count_leaf]";
  print_test_case (fun t -> string_of_int (count_leaf t));
  print_endline "[height]";
  print_test_case (fun t -> string_of_int (height t))
