import java.util.Arrays;

/**
 * @author sunyejun
 * @date 2017-09-30
 * @Description
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
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
        Insertion.sort(a);
        System.out.println(Arrays.asList(a));
    }
}
