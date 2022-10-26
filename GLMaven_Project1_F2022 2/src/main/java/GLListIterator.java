import java.util.ListIterator;

// this is the class that will be returned when the listiterator method is called in the
//  genericlist class
// implement all the abstract methods inherited from the interface
public class GLListIterator<E> implements ListIterator<E> {
    GenericList<E>.Node<E> current;
    GenericList<E>.Node<E> head;
    int count = 0;
    public GLListIterator(GenericList<E>.Node<E> head, int index) {
        this.count = index;
        this.current = head;
        for (int i = 0; i < index; i ++) {
            current = current.next;
        }

    }


    //checks if the next element exists
    @Override
    public boolean hasNext() {
        if (current.next == null) {
            return false;
        }
        return true;
    }

    // moves the cursor iterator to the next element and returns the next element in the list
    @Override
    public E next() {
        E val = current.data;

        current = current.next;
        count++;
        return val;
    }

    //returns true if the list has more elements while traversing the list in the backward direction
    @Override
    public boolean hasPrevious() {

        return current != null;
    }

    @Override
    public E previous() {
        GenericList<E>.Node<E> tmp = head;
        while (tmp.next != current) {
            tmp = tmp.next;
        }
        E val = current.data;


        count--;
        if (current == head) {
            current = null;
        } else {
            current = tmp;
        }
        return val;
    }

    //return the index of the next val
    @Override
    public int nextIndex() {
        return count+1;
    }

    @Override
    public int previousIndex() {
        return count-1;
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(E e) {

    }

    @Override
    public void add(E e) {

    }


}
