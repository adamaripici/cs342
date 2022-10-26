import java.util.Iterator;

public class ReverseGLLIterator<E> implements Iterator<E> {
    GenericList<E>.Node<E> current;

    public ReverseGLLIterator(GenericList<E>.Node<E> head) {
        current = head;
        while (current.next != null) {
            current = current.next;
        }

    }

    // checks to see if there is another value in the data structure and returns
    // true or false
    //iterate the list in reverse (tail to head)
    public boolean hasNext() {
        return current != null;
    }

    // public next(), return the current value in the data structure
    // and advances to the next item. this is the class that will be returned when the
    // iterator() method is called from the iterable<t> interfaces

    public E next() {
        E data = current.data;
        current = current.next;
        return data;
    }
}
