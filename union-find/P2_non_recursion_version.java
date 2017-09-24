import java.util.ArrayDeque;
import java.util.Deque;
/**
 * Created by Xiaonan Wu， Xinyu Han，Rui Liu on 2017/9/19.
 * CSCI 6221 software paradigm homework
 * This program is to use NON-recursion version quick sort to sort 1000 random numbers.
 */
public class P2_non_recursion_version {
    public int[] quickSortNONRecursion(int[] input) {
        if (input == null || input.length <= 1) {
            return input;
        }
        quickSortNONRecursion(input, 0, input.length - 1);
        return input;
    }

    private void quickSortNONRecursion(int[] input, int left, int right) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerFirst(left);
        stack.offerFirst(right);
        while (!stack.isEmpty()) {
            int rightBound = stack.pollFirst();
            int leftBound = stack.pollFirst();
            int pivotPosition = partition(input, leftBound, rightBound);
            if (leftBound < pivotPosition - 1) {
                stack.offerFirst(leftBound);
                stack.offerFirst(pivotPosition - 1);
            }
            if (rightBound > pivotPosition + 1) {
                stack.offerFirst(pivotPosition + 1);
                stack.offerFirst(rightBound);
            }
        }
    }

    private int partition(int[] input, int left, int right) {
        int pivotIndex = selectPivot(left, right);
        int pivotValue = input[pivotIndex];
        swap(input, pivotIndex, right);
        int leftPointer = left;
        int rightPointer = right - 1;
        while (leftPointer <= rightPointer) {
            if (input[leftPointer] < pivotValue) {
                leftPointer++;
            } else if (input[rightPointer] >= pivotValue) {
                rightPointer--;
            } else {
                swap(input, leftPointer++, rightPointer--);
            }
        }
        swap(input, leftPointer, right);
        return leftPointer;
    }

    private int selectPivot(int left, int right) {
        return left + (int)(Math.random() * (right - left + 1));
    }

    private void swap(int[] input, int left, int right) {
        int temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }

    public static void main(String[] args) {
        P2_non_recursion_version test = new P2_non_recursion_version();

        int[] randomNum = test.generateInput();
        //before sorting
        test.printArray(randomNum);
        test.quickSortNONRecursion(randomNum);
        //after sorting
        test.printArray(randomNum);
        System.out.println('\n' +"Sorted ?  "  + test.isSorted(randomNum));
    }

    private int[] generateInput() {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 1000);
        }
        return array;
    }

    private void printArray(int[] array) {
        System.out.println();
        for (int num : array) {
            System.out.print(num);
            System.out.print("  ");
        }
    }

    private boolean isSorted(int[] input) {
        for (int i = 1; i < input.length; i++) {
            if (input[i] < input[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
