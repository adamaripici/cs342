import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GQTest {

    static GenericQueue<Integer> queue;

    @BeforeEach
    public void queueTest() {
        queue = new GenericQueue<>(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
    }

    @Test
    public void constructorTest() {
        Assertions.assertEquals(0, queue.getHead().data);
        Assertions.assertEquals(6, queue.getLength());
    }

    @Test
    public void enqueueTest() {
        queue.enqueue(6);
        queue.enqueue(7);
        Assertions.assertEquals(0, queue.getHead().data);
        Assertions.assertEquals(7, queue.tail.data);
        Assertions.assertEquals(8, queue.getLength());
    }

    @Test
    public void dequeueTest() {
        queue.dequeue();
        Assertions.assertEquals(1, queue.getHead().data);
        Assertions.assertEquals(5, queue.getLength());
        Assertions.assertEquals(5, queue.tail.data);
    }

    @Test
    public void removeTailTest() {
        System.out.println("start");
        for (int i: queue) {

            System.out.println(i);
        }
        queue.removeTail();
        System.out.println("hi");
        for (int i: queue) {

            System.out.println(i);
        }
        System.out.println("end");
        Assertions.assertEquals(5, queue.getLength());
        Assertions.assertEquals(4, queue.tail.data);
        Assertions.assertEquals(4, queue.removeTail());
        Assertions.assertEquals(0, queue.getHead().data);

        for (int i: queue) {

            System.out.println(i);
        }




    }
    @Test

    public void forEachTest() {
        for (int i: queue) {
            System.out.println(i);
        }

    }


}
