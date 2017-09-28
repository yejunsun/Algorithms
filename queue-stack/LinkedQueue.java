import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author sunyejun
 * @date 2017-09-28
 * @Description
 */
public class LinkedQueue<Item> implements Iterable<Item>{

    private Node first,last;

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }


    private class Node{
        public Item item;
        public Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Item dequeue() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            oldLast.next = last;
        } else {
            first = last;
        }
    }
}
