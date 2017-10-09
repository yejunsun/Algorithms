import java.util.Arrays;

/**
 * @author sunyejun
 * @date 2017-09-30
 * @Description
 */
public class Selection {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i; j < a.length && less(a[j], a[min]); j++) {
                min = j;
            }
            exch(a, min, i);
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
        Selection.sort(a);
        System.out.println(Arrays.asList(a));
    }
}
