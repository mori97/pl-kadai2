open Tree
open Testcase

let () =
  print_endline "[value_of_tree2]";
  print_test_case (fun t -> string_of_int (value_of_tree2 t))
