public class TestCase {
    public Tree[] t;
    public TestCase() {
        t = new Tree[10];
        t[0] = new BranchS(new BranchM(new Leaf(2), new Leaf(4)), new Leaf(3));
        t[1] = new BranchM(new BranchS(new Leaf(2), new Leaf(4)), new Leaf(3));
        t[2] = new BranchS(new BranchS(new Leaf(1), new Leaf(2)), new Leaf(3));
        t[3] = new BranchS(new Leaf(1), new BranchS(new Leaf(2), new Leaf(3)));
        t[4] = new BranchM(new BranchM(new Leaf(1), new Leaf(2)), new Leaf(3));
        t[5] = new BranchM(new Leaf(1), new BranchM(new Leaf(2), new Leaf(3)));
        t[6] = new BranchM(new BranchS(new Leaf(1), new Leaf(2)), new BranchS(new Leaf(3), new Leaf(4)));
        t[7] = new BranchM(new Leaf(6), new Leaf(7));
        t[8] = new BranchS(new BranchM(new Leaf(1), new Leaf(2)), new BranchM(new Leaf(3), new Leaf(4)));
        t[9] = new BranchM(new BranchS(new Leaf(1), new BranchM(new Leaf(2), new Leaf(3))), new BranchM(new BranchM(new Leaf(4), new Leaf(5)), new BranchS(new Leaf(6), new Leaf(7))));
    }
}
