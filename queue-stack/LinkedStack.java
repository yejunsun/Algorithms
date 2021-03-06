import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author sunyejun
 * @date 2017-09-27
 * @Description
 */
public class LinkedStack<Item> implements Iterable<Item> {

    private Node first = null;

    private class Node{
        public Item item;
        public Node next;
    }

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

    public boolean isEmpty() {
        return first == null;
    }

    public Item pop() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        Item item = first.item;
        first = first.next;
        return item;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }
}
