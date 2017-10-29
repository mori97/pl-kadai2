srcs := tree.ml testcase.ml
tests := $(patsubst %,test%,1 2 3 4 5 6 7)
objs := $(wildcard *.cmx) $(wildcard *.cmi) $(wildcard *.o)
targets := $(wildcard *.out)

all: $(targets)

test: $(tests)

$(tests): %: %.out
	./$<

%.out: $(srcs) %.ml
	ocamlopt $^ -o $@

clean:
	rm -f $(objs)

distclean: clean
	rm -f $(targets)

.PHONY: all test $(tests) clean distclean
