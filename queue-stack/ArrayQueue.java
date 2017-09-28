import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author sunyejun
 * @date 2017-09-28
 * @Description
 */
public class ArrayQueue<Item> implements Iterable<Item> {

    private Item[] s = (Item[]) new Object[1];
    private int head = -1, tail = -1, N = 0;

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private int i = head;

        @Override
        public boolean hasNext() {
            return i <= tail && i != -1;
        }

        @Override
        public Item next() {
            return s[i--];
        }

        @Override
        public void remove() {

        }
    }



    private class Node {
        public Item Item;
        public Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for(int i = head; i <= tail; i++) {
            copy[i - head] = s[i];
        }
        s = copy;
    }

    public void enqueue(Item item) {
        if (tail == s.length - 1) {
            resize(N * 2);
        }
        s[++tail] = item;
        if (isEmpty()) {
            head = 0;
        }
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (N == s.length / 2) {
            resize(N * 2);
        }
        Item item = s[head--];
        N--;
        if (isEmpty()) {
            tail = -1;
        }
        return item;
    }
}
