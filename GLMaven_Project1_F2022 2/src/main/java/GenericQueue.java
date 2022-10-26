public class GenericQueue<T> extends GenericList<T> {
    Node<T> tail; // reference to the tail of the list

    public GenericQueue(T val) {
        super(val);
        Node<T> newNode = new Node<T>(val);
        setHead(newNode);
        setLength(1);
        tail = newNode;
    }


    public void add(T data) {
        Node<T> newNode = new Node(data);
        if (getHead() == null) {
            setHead(newNode);
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        setLength(getLength()+1);
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
            Node<T> secondLast = getHead();
            T data = tail.data;
            while (secondLast.next != tail) {
                secondLast = secondLast.next;
            }

            tail = secondLast;
            tail.next = null;

            super.setLength(super.getLength()-1);
            return data;
        }
    }

    //call method add(T data)
    public void enqueue(T data) {
        add(data);

    }

    // call method delete()
    public T dequeue() {
        return delete();
    }

}
