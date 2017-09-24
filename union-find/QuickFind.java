/**
 * @author sunyejun
 * @date 2017-09-20
 * @Description use to solve dynamic connectivity problems
 */
public class QuickFind {
    private int[] id;

    // N array access
    public QuickFind(int N) {
        id = new int[N];
        for (int i = 0; i < N - 1; i++) {
            id[i] = i;
        }
    }

    // 2 array access
    public boolean find(int p, int q) {
        return id[p] == id[q];
    }

    // 2N + 2 array access
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length - 1; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }
}
