import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

// it should implement the Java Iterable<T> interface: this will allow clients of your LL to use a forEach loop to iterate
// this class will contain only two data fields: Node<T> head (this is the head of the list and should be private)
// int length (the length of the list and should be private)


public abstract class GenericList<T> implements Iterable<T> {
    private Node<T> head; //head of the list
    private int length = 0; //length of the list

    // the constructors for each class will take one parameter. that parameter will be a val
    // that will go in the first node of the list encapsulated by each instance of the class.
    // each constructor should initialize  the linked list head, with the value passed in by
    // the constructor and set the head and tail data members
    //
    public GenericList(T val) {
        Node<T> newNode = new Node<T>(val);
        head = newNode;
        length=+1;
    }

    // this class should define a generic inner class Node<t> it will include two fields: T data and Node<T> next
    // this inner class will also provide a single arg constructor: public Node(T val) //sets data equal to va;
    class Node<T> {
        T data;
        Node<T> next;
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    //  getters/setter for private data members head and length
    public int getLength() {
        return this.length;
    }

    public void setLength(int length){
        this.length = length;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }


    // public methods:

    // prints the items of the list, one per line. if the list is empty, print "Empty List"
    public void print() {
        Node<T> temp = head;
        if (temp == null) {
            System.out.println("Empty list");
        }
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // adds the value to the list. This method is abstract since the implementation depends on what the data structure is
    public abstract void add(T data);

    // returns the first value of the list and deletes the node. If the list is empty, return null
    public T delete() {
        if (head == null) {
            return null;
        }
        T val = head.data;
        head = head.next;
        length--;
        return val;
    }

    // this method stores and return all values currently in the list into an ArrayList and returns it.
    // At the end of this method, your list should be empty
    public ArrayList<T> dumpList() {
        ArrayList<T> arr = new ArrayList<T>();

        Node<T> curr = head;
        for (int i = 0; i < length; i ++) {
            arr.add(curr.data);
            curr = curr.next;
        }
        return arr;
    }

    // returns the value at the specified index or null if the index is out of bounds
    public T get(int index) {
        if (index > length-1 || index < 0) {
            return null;
        }
        Node<T> curr = head;
        if (index == 0) {
            return head.data;
        }
        for (int i = 0; i < index - 1; i ++) {
            curr = curr.next;
        }
        T val = curr.data;
        return val;
    }

    // replace the element at specified position in the list with the specified element
    // and return the element previously at the specified position.
    // return null if index is out of bounds
    public T set(int index, T element) {
        if (index > length - 1 || index < 0) {
            return null;
        }
        Node<T> tmp = head;
        for (int i = 0; i< index-1; i ++) {
            tmp = tmp.next;
        }
        T val = tmp.data;
        tmp.data = element;
        return val;
    }

    //

   // returns a list-iterator of the elements of this list starting at the specified position
    public ListIterator<T> listIterator(int index) {
        if (index >= length) {
            return null;
        }
        return new GLListIterator(head,index);
    }

    public Iterator<T> iterator() {
        return new GLLIterator(head);
    }

    // returns an iterator over the elements of the
    // list in reverse order (tail to head)
    public Iterator<T> descendingIterator() {
        return new ReverseGLLIterator<>(head);
    }
}
