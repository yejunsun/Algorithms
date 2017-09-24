/**
 * @author sunyejun
 * @date 2017-09-20
 * @Description
 */
public class QuickUnion {
    private int[] id;

    // N array access
    public QuickUnion(int N) {
        id = new int[N];
        for (int i=0; i<N-1; i++) {
            id[i] = i;
        }
    }

    //
    public int root(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    //N
    public boolean find(int p, int q) {
        return root(p) == root(q);
    }

    //N
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
}
