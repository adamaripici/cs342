public class GenericStack<T> extends GenericList<T>{

    Node<T> tail; // reference to the tail of the list

    public GenericStack(T val) {
        super(val);
        Node<T> newNode = new Node<T>(val);
        setHead(newNode);
        setLength(1);
        tail = newNode;
    }
    // retrieves and removes the tail of the list using the tail data member
    public T removeTail() {
        if (getHead() == null) { //if the first node is null return null
            return null;
        } else if (tail == getHead()) { //if there is only one node sethead to null and return null
            setHead(null);
            setLength(0);
            return null;
        } else {
            Node<T> curr = getHead();
            while (curr.next != null) {
                curr = curr.next;
            }
            tail = curr;
            curr.next = null;
            setLength(getLength()-1);
            return curr.data;
        }
    }

   //add to front of the list
    public void add(T data) {
        Node<T> newNode = new Node(data);
        if (getHead() == null) {
            setHead(newNode);
            tail = newNode;
        } else {
            newNode.next = getHead();
            setHead(newNode);

        }
        setLength(getLength()+1);
    }

    //call method add(t data)
    public void push(T data) {
        add(data);
    }

    //call method delete()
    public T pop() {
        return delete();

    }
}
