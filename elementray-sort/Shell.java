import java.util.Arrays;

/**
 * @author sunyejun
 * @date 2017-09-30
 * @Description
 */
public class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;

        int h = 1;
        while (h < N) {
            h = 3 * h + 1;
        }

        while (h > 0) {
            for (int i = h; i < N; i++) {
                for (int j = i; j > h && (less(a[j], a[j - h])); j -= h) {
                    exch(a, j, j-h);
                }
            }

            h = h / 3;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = {2, 9, 7, 3, 5, 8, 7};
        Shell.sort(a);
        System.out.println(Arrays.asList(a));
    }
}
