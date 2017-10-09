import java.util.Random;

/**
 * @author sunyejun
 * @date 2017-09-30
 * @Description
 */
public class Shuffle {
    public static void sort(int[] a) {
        int N = a.length;
        Random r = new Random();
        for (int i = 0; i < N; i++) {
            exch(a, i, r.nextInt(N - 1));
        }
    }

    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        Shuffle.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
