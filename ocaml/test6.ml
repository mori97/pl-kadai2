open Tree
open Testcase

let () =
  print_endline "[reduce]";
  print_test_case (fun t -> string_of_tree (reduce t))
