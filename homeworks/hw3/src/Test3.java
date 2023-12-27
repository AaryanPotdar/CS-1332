import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test3 {
    private static final int TIMEOUT = 200;
    private ArrayStack<String> arrayStack;
    private LinkedStack<String> linkedStack;
    private ArrayQueue<String> arrayQueue;
    private LinkedQueue<String> linkedQueue;

    @Before
    public void setup() {
        arrayStack = new ArrayStack<>();
        linkedStack = new LinkedStack<>();
        arrayQueue = new ArrayQueue<>();
        linkedQueue = new LinkedQueue<>();
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedQueue() {
        //testing enqueue and size
        String[] test = new String[100];
        for (int i = 0; i < 100; i++) {
            assertEquals(i, linkedQueue.size());
            Integer obj = i;
            String data = obj.toString();
            test[i] = data;
            linkedQueue.enqueue(data);
        }
        //testing dequeue, peek, and size
        int j = 100;
        for (int i = 0; i < 100; i++) {
            assertEquals(j--, linkedQueue.size());
            assertEquals(test[i], linkedQueue.peek());
            assertEquals(test[i], linkedQueue.dequeue());
        }
    }

    @Test(timeout = TIMEOUT)
    public void testLinkedStack() {
        //testing push and size
        String[] test = new String[100];
        for (int i = 0; i < 100; i++) {
            assertEquals(i, linkedStack.size());
            Integer obj = i;
            String data = obj.toString();
            test[i] = data;
            linkedStack.push(data);
        }
        //testing pop, peek, and size
        int j = 100;
        for (int i = 99; i >= 0; i--) {
            assertEquals(j--, linkedStack.size());
            assertEquals(test[i], linkedStack.peek());
            assertEquals(test[i], linkedStack.pop());
        }
    }

    @Test(timeout = TIMEOUT)
    public void testArrayQueue() {
        //testing enqueue and size
        String[] test = new String[100];
        for (int i = 0; i < 100; i++) {
            assertEquals(i, arrayQueue.size());
            Integer obj = i;
            String data = obj.toString();
            test[i] = data;
            arrayQueue.enqueue(data);
        }
        //testing dequeue, peek, and size
        int j = 100;
        for (int i = 0; i < 100; i++) {
            assertEquals(j--, arrayQueue.size());
            assertEquals(test[i], arrayQueue.peek());
            assertEquals(test[i], arrayQueue.dequeue());
        }
    }

    @Test(timeout = TIMEOUT)
    public void testArrayStack() {
        //testing push and size
        String[] test = new String[100];
        for (int i = 0; i < 100; i++) {
            assertEquals(i, arrayStack.size());
            Integer obj = i;
            String data = obj.toString();
            test[i] = data;
            arrayStack.push(data);
        }
        //testing pop, peek, and size
        int j = 100;
        for (int i = 99; i >= 0; i--) {
            assertEquals(j--, arrayStack.size());
            assertEquals(test[i], arrayStack.peek());
            assertEquals(test[i], arrayStack.pop());
        }
    }


    @Test(timeout = TIMEOUT)
    public void testTailAndHeadForLinkedQueue() {
        assertEquals(null, linkedQueue.getTail());
        assertEquals(null, linkedQueue.getHead());

        String temp = "0a";

        linkedQueue.enqueue(temp);   // 0a
        assertEquals("0a", linkedQueue.getHead().getData());
        assertEquals("0a", linkedQueue.getTail().getData());

        linkedQueue.enqueue("1a");   // 0a, 1a
        linkedQueue.enqueue("2a");   // 0a, 1a, 2a
        assertEquals("0a", linkedQueue.getHead().getData());
        assertEquals("2a", linkedQueue.getTail().getData());

        linkedQueue.dequeue();   // 1a, 2a
        linkedQueue.dequeue();   // 2a

        assertEquals("2a", linkedQueue.getHead().getData());
        assertEquals("2a", linkedQueue.getTail().getData());

        linkedQueue.dequeue();   //

        assertEquals(null, linkedQueue.getTail());
        assertEquals(null, linkedQueue.getHead());
    }

    @Test(timeout = TIMEOUT)
    public void testHeadForLinkedStack() {
        assertEquals(null, linkedStack.getHead());

        String temp = "0a";

        linkedStack.push(temp);  // 0a
        linkedStack.push("1a");  // 1a, 0a
        linkedStack.push("2a");  // 2a, 1a, 0a

        assertEquals("2a", linkedStack.getHead().getData());

        assertEquals("2a", linkedStack.pop()); //1a, 0a
        assertEquals("1a", linkedStack.getHead().getData());

        assertEquals("1a", linkedStack.pop()); //0a
        assertEquals("0a", linkedStack.getHead().getData());

        assertEquals("0a", linkedStack.pop()); //
        assertEquals(null, linkedStack.getHead());
    }
}