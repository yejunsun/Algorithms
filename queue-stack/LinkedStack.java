import java.util.NoSuchElementException;

/**
 * @author sunyejun
 * @date 2017-09-27
 * @Description
 */
public class LinkedStack<Item> {

    private Node first = null;

    private class Node{
        public Item item;
        public Node next;
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
