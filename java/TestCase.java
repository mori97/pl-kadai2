public class TestCase {
    public Tree[] t;
    public TestCase() {
        t = new Tree[] {
            new BranchS(new BranchM(new Leaf(2), new Leaf(4)), new Leaf(3)),
            new BranchM(new BranchS(new Leaf(2), new Leaf(4)), new Leaf(3)),
            new BranchS(new BranchS(new Leaf(1), new Leaf(2)), new Leaf(3)),
            new BranchS(new Leaf(1), new BranchS(new Leaf(2), new Leaf(3))),
            new BranchM(new BranchM(new Leaf(1), new Leaf(2)), new Leaf(3)),
            new BranchM(new Leaf(1), new BranchM(new Leaf(2), new Leaf(3))),
            new BranchM(new BranchS(new Leaf(1), new Leaf(2)), new BranchS(new Leaf(3), new Leaf(4))),
            new BranchM(new Leaf(6), new Leaf(7)),
            new BranchS(new BranchM(new Leaf(1), new Leaf(2)), new BranchM(new Leaf(3), new Leaf(4))),
            new BranchM(new BranchS(new Leaf(1), new BranchM(new Leaf(2), new Leaf(3))), new BranchM(new BranchM(new Leaf(4), new Leaf(5)), new BranchS(new Leaf(6), new Leaf(7)))),
            // 課題 1-1-3
            new BranchS(new Leaf(2), new BranchX(new Leaf(2), new BranchM(new Leaf(2), new Leaf(3))))
        };
    }
}
