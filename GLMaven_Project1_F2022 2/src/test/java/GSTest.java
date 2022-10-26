import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GSTest {

    static GenericStack<Integer> stack;

    @BeforeEach
    public void stackTest() {
        stack = new GenericStack<>(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
    }

    @Test
    public void constructorTest() {
        Assertions.assertEquals(5, stack.getHead().data);
        Assertions.assertEquals(6, stack.getLength());
    }
    @Test
    public void popTest() {
        stack.pop();
        Assertions.assertEquals(0, stack.tail.data);
        Assertions.assertEquals(4, stack.getHead().data);
        Assertions.assertEquals(5, stack.getLength());
    }
    @Test
    public void pushTest() {
        stack.push(6);
        Assertions.assertEquals(6, stack.getHead().data);
        Assertions.assertEquals(7, stack.getLength());
    }
    @Test
    public void removeTailTest() {
        stack.removeTail();
        Assertions.assertEquals(0, stack.removeTail());
        Assertions.assertEquals(0, stack.tail.data);
        Assertions.assertEquals(4, stack.getLength());
        Assertions.assertEquals(5, stack.getHead().data);
    }

    @Test
    public void forEachTest() {
        for (int i: stack) {
            System.out.println(i);
        }

    }



}