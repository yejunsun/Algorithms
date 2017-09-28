import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author sunyejun
 * @date 2017-09-27
 * @Description
 */
public class ArrayStack<Item> implements Iterable<Item>{
    Item[] s = (Item[])new Object[1];
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public Item pop() {
        if (N == 0) {
            throw new NoSuchElementException();
        }

        if (N == s.length / 4) {
            resize(s.length / 2);
        }
        Item item = s[--N];
        s[N] = null;
        return item;
    }

    public void push(Item item) {
        if (N >= s.length) {
            resize(s.length * 2);
        }

        s[N++] = item;
    }

    public void resize(int capacity) {
        Item[] oldItemList = s;
        s = (Item[]) new Object[capacity];
        for (int i = 0; i < oldItemList.length; i++) {
            s[i] = oldItemList[i];
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReversedListIterator();
    }

    private class ReversedListIterator implements Iterator<Item> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i == 0;
        }

        @Override
        public Item next() {
            return s[--N];
        }

        @Override
        public void remove() {

        }
    }

}
