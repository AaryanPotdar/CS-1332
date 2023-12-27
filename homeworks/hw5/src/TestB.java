import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class TestB {
    private static final int TIMEOUT = 200;
    private MaxHeap<Integer> heap;

    @Before
    public void setUp() {
        heap = new MaxHeap<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertEquals(0, heap.size());
        assertArrayEquals(new Comparable[MaxHeap.INITIAL_CAPACITY],
                heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeap() {
        ArrayList<Integer> data = new ArrayList<>();
        data.addAll(Arrays.asList(5, 7, 9, 1, 12, 11, 10, 8, 6, 3, 2, 4));
        heap = new MaxHeap<>(data);
        assertEquals(12, heap.size());
        Integer[] expected = new Integer[] {null,12, 8, 11, 6, 7, 9, 10, 1, 5, 3, 2, 4,
                null, null, null, null, null, null, null, null, null, null, null, null};
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testBuildHeapNullList() {
        heap = new MaxHeap<>(null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testBuildHeapNullData() {
        ArrayList<Integer> data = new ArrayList<>();
        data.addAll(Arrays.asList(1, 2, 3, null));
        heap = new MaxHeap<>(data);
    }

    @Test(timeout = TIMEOUT)
    public void testAdd() {
        Integer[] expected = new Integer[13];

        heap.add(5);
        assertEquals(1, heap.size());
        expected[1] = 5;
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(4);
        assertEquals(2, heap.size());
        expected[2] = 4;
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(9);
        assertEquals(3, heap.size());
        expected[1] = 9;
        expected[3] = 5;
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(1);
        expected[4] = 1;
        assertEquals(4, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(12);
        expected[1] = 12;
        expected[2] = 9;
        expected[5] = 4;
        assertEquals(5, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(11);
        expected[3] = 11;
        expected[6] = 5;
        assertEquals(6, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddResize() {
        Integer[] expected = new Integer[13];

        heap.add(5);
        assertEquals(1, heap.size());
        expected[1] = 5;
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(4);
        assertEquals(2, heap.size());
        expected[2] = 4;
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(9);
        assertEquals(3, heap.size());
        expected[1] = 9;
        expected[3] = 5;
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(1);
        expected[4] = 1;
        assertEquals(4, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(12);
        expected[1] = 12;
        expected[2] = 9;
        expected[5] = 4;
        assertEquals(5, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(11);
        expected[3] = 11;
        expected[6] = 5;
        assertEquals(6, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(10);
        expected[7] = 10;
        assertEquals(7, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(8);
        expected[4] = 8;
        expected[8] = 1;
        assertEquals(8, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(6);
        expected[9] = 6;
        assertEquals(9, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(3);
        expected[10] = 3;
        assertEquals(10, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(2);
        expected[11] = 2;
        assertEquals(11, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(4);
        expected[12] = 4;
        assertEquals(12, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(13);
        Integer[] newExpected = new Integer[26];
        for (int i = 0; i < expected.length; ++i) {
            newExpected[i] = expected[i];
        }
        expected = newExpected;
        expected[1] = 13;
        expected[3] = 12;
        expected[6] = 11;
        expected[13] = 5;
        assertEquals(13, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test (timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddNull() {
        heap.add(null);
    }

    @Test (timeout = TIMEOUT)
    public void testRemove() {
        ArrayList<Integer> data = new ArrayList<>();
        data.addAll(Arrays.asList(5, 7, 9, 1, 12, 11, 10, 8, 6, 3, 2, 4));
        heap = new MaxHeap<>(data);
        Integer[] expected = new Integer[] {null,12, 8, 11, 6, 7, 9, 10, 1, 5, 3, 2, 4,
                null, null, null, null, null, null, null, null, null, null, null, null};
        assertEquals(data.size(), heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        expected = new Integer[] {null,11, 8, 10, 6, 7, 9, 4, 1, 5, 3, 2, null,
                null, null, null, null, null, null, null, null, null, null, null, null};
        assertEquals((Integer) 12, heap.remove());
        assertEquals(11, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        expected = new Integer[] {null,10, 8, 9, 6, 7, 2, 4, 1, 5, 3, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null};
        assertEquals((Integer) 11, heap.remove());
        assertEquals(10, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        expected = new Integer[] {null, 9, 8, 4, 6, 7, 2, 3, 1, 5, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null};
        assertEquals((Integer) 10, heap.remove());
        assertEquals(9, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        expected = new Integer[] {null, 8, 7, 4, 6, 5, 2, 3, 1, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null};
        assertEquals((Integer) 9, heap.remove());
        assertEquals(8, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        expected = new Integer[] {null, 7, 6, 4, 1, 5, 2, 3, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null};
        assertEquals((Integer) 8, heap.remove());
        assertEquals(7, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        expected = new Integer[] {null, 6, 5, 4, 1, 3, 2, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null};
        assertEquals((Integer) 7, heap.remove());
        assertEquals(6, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        expected = new Integer[] {null, 5, 3, 4, 1, 2, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null};
        assertEquals((Integer) 6, heap.remove());
        assertEquals(5, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        expected = new Integer[] {null, 4, 3, 2, 1, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null};
        assertEquals((Integer) 5, heap.remove());
        assertEquals(4, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        expected = new Integer[] {null, 3, 1, 2, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null};
        assertEquals((Integer) 4, heap.remove());
        assertEquals(3, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        expected = new Integer[] {null, 2, 1, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null};
        assertEquals((Integer) 3, heap.remove());
        assertEquals(2, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        expected = new Integer[] {null, 1, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null};
        assertEquals((Integer) 2, heap.remove());
        assertEquals(1, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());

        expected = new Integer[] {null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null};
        assertEquals((Integer) 1, heap.remove());
        assertEquals(0, heap.size());
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test (timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveEmpty() {
        heap.remove();
    }

    @Test (timeout = TIMEOUT)
    public void testGetMax() {
        ArrayList<Integer> data = new ArrayList<>();
        data.addAll(Arrays.asList(5, 7, 9, 1, 12, 11, 10, 8, 6, 3, 2, 4));
        heap = new MaxHeap<>(data);
        assertEquals(12, heap.size());
        assertEquals((Integer) 12, heap.getMax());
    }

    @Test (timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testGetMaxEmpty() {
        heap.getMax();
    }

    @Test (timeout = TIMEOUT)
    public void testIsEmpty() {
        assertTrue(heap.isEmpty());
    }

    @Test (timeout = TIMEOUT)
    public void testClear() {
        ArrayList<Integer> data = new ArrayList<>();
        data.addAll(Arrays.asList(5, 7, 9, 1, 12, 11, 10, 8, 6, 3, 2, 4));
        heap = new MaxHeap<>(data);
        assertEquals(12, heap.size());
        heap.clear();
        assertEquals(0, heap.size());
        Integer[] expected = new Integer[13];
        assertArrayEquals(expected, heap.getBackingArray());
    }
}
