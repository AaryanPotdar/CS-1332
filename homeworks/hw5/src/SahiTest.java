import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * MaxHeap JUnit Tests
 *
 * @author Sahithya Pasagada
 * @version 1.0
 */
public class SahiTest {
    private static final int TIMEOUT = 200;
    private MaxHeap<Integer> heap;

    @Before
    public void setUp() {
        heap = new MaxHeap<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertEquals(0, heap.size());
        assertArrayEquals(new Comparable[MaxHeap.INITIAL_CAPACITY], heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testBuildHeapNullArray() {
        ArrayList<Integer> data = null;
        heap = new MaxHeap<>(data);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testBuildHeapNullElements() {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(12);
        data.add(1);
        data.add(5);
        data.add(100);
        data.add(null);
        data.add(15);
        heap = new MaxHeap<>(data);
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeapEmptyArray() {
        ArrayList<Integer> data = new ArrayList<>();
        heap = new MaxHeap<>(data);
        assertEquals(0, heap.size());
        Integer[] expected = new Integer[1];
        expected[0] = null;
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeapEmpty() {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(16);

        /*
         *
         * 16
         *
         */

        heap = new MaxHeap<>(data);

        assertEquals(1, heap.size());

        Integer[] expected = new Integer[3];
        expected[1] = 16;
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeapSmallerOneElement() {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(16);
        data.add(11);

        /*
         *
         * 16 / 11
         *
         */

        heap = new MaxHeap<>(data);

        assertEquals(2, heap.size());

        Integer[] expected = new Integer[2 * 2 + 1];
        expected[1] = 16;
        expected[2] = 11;
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeapLargerOneElement() {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(16);
        data.add(18);

        /*
         *
         * 18 / 16
         *
         */

        heap = new MaxHeap<>(data);

        assertEquals(2, heap.size());

        Integer[] expected = new Integer[2 * 2 + 1];
        expected[1] = 18;
        expected[2] = 16;
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeapFullyComplete() {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(16);
        data.add(18);
        data.add(12);
        data.add(20);
        data.add(13);
        data.add(10);
        data.add(15);

        /*
         * 20 / \ 18 15 / \ / \ 16 13 10 12
         *
         */

        heap = new MaxHeap<>(data);

        assertEquals(7, heap.size());
        assertFalse(heap.isEmpty());
        assertEquals((Integer) 20, heap.getMax());

        Integer[] expected = new Integer[2 * 7 + 1];
        expected[1] = 20;
        expected[2] = 18;
        expected[3] = 15;
        expected[4] = 16;
        expected[5] = 13;
        expected[6] = 10;
        expected[7] = 12;
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeapCompleteOneElementBottom() {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(16);
        data.add(18);
        data.add(12);
        data.add(20);

        /*
         * 20 / \ 18 12 / 16
         *
         */

        heap = new MaxHeap<>(data);

        assertEquals(4, heap.size());
        assertFalse(heap.isEmpty());
        assertEquals((Integer) 20, heap.getMax());

        Integer[] expected = new Integer[2 * 4 + 1];
        expected[1] = 20;
        expected[2] = 18;
        expected[3] = 12;
        expected[4] = 16;
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeapCompleteTwoElementBottom() {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(16);
        data.add(18);
        data.add(12);
        data.add(20);
        data.add(13);

        /*
         * 20 / \ 18 12 / \ 16 13
         *
         */

        heap = new MaxHeap<>(data);

        assertEquals(5, heap.size());
        assertFalse(heap.isEmpty());
        assertEquals((Integer) 20, heap.getMax());

        Integer[] expected = new Integer[2 * 5 + 1];
        expected[1] = 20;
        expected[2] = 18;
        expected[3] = 12;
        expected[4] = 16;
        expected[5] = 13;
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeapCompleteThreeElementBottom() {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(16);
        data.add(18);
        data.add(12);
        data.add(20);
        data.add(13);
        data.add(17);

        /*
         * 20 / \ 18 17 / \ / 16 13 12
         *
         */

        heap = new MaxHeap<>(data);

        assertEquals(6, heap.size());

        Integer[] expected = new Integer[2 * 6 + 1];
        expected[1] = 20;
        expected[2] = 18;
        expected[3] = 17;
        expected[4] = 16;
        expected[5] = 13;
        expected[6] = 12;
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeapCompleteAllSmaller() {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(16);
        data.add(15);
        data.add(14);
        data.add(13);
        data.add(2);
        data.add(6);

        /*
         * 16 / \ 15 14 / \ / 13 2 6
         *
         */

        heap = new MaxHeap<>(data);

        assertEquals(6, heap.size());
        assertFalse(heap.isEmpty());
        assertEquals((Integer) 16, heap.getMax());

        Integer[] expected = new Integer[2 * 6 + 1];
        expected[1] = 16;
        expected[2] = 15;
        expected[3] = 14;
        expected[4] = 13;
        expected[5] = 2;
        expected[6] = 6;
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeapCompleteAllBigger() {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(16);
        data.add(17);
        data.add(18);
        data.add(19);
        data.add(28);
        data.add(34);

        /*
         * 34 / \ 28 18 / \ / 19 17 16
         *
         */

        heap = new MaxHeap<>(data);

        assertEquals(6, heap.size());

        Integer[] expected = new Integer[2 * 6 + 1];
        expected[1] = 34;
        expected[2] = 28;
        expected[3] = 18;
        expected[4] = 19;
        expected[5] = 17;
        expected[6] = 16;
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeapLarger() {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(6);
        data.add(12);
        data.add(3);
        data.add(4);
        data.add(8);
        data.add(99);
        data.add(76);
        data.add(5);
        data.add(43);
        data.add(2);
        data.add(121);
        data.add(210);
        data.add(312);
        heap = new MaxHeap<>(data);

        assertEquals(13, heap.size());

        Integer[] expected = new Integer[2 * 13 + 1];
        expected[1] = 312;
        expected[2] = 121;
        expected[3] = 210;
        expected[4] = 43;
        expected[5] = 12;
        expected[6] = 99;
        expected[7] = 76;
        expected[8] = 5;
        expected[9] = 4;
        expected[10] = 2;
        expected[11] = 8;
        expected[12] = 3;
        expected[13] = 6;
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddEmpty() {
        /*
         * 4
         */
        heap.add(4);

        assertEquals(1, heap.size());

        Integer[] expected = new Integer[MaxHeap.INITIAL_CAPACITY];
        expected[1] = 4;
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddToOneElementLarger() {
        /*
         * 4
         */
        heap.add(4);

        /*
         * 6 / 4
         */

        heap.add(6);

        assertEquals(2, heap.size());
        assertFalse(heap.isEmpty());
        assertEquals((Integer) 6, heap.getMax());

        Integer[] expected = new Integer[MaxHeap.INITIAL_CAPACITY];
        expected[1] = 6;
        expected[2] = 4;
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddToOneElementSmaller() {
        /*
         * 4
         */
        heap.add(4);

        /*
         * 4 / 2
         */

        heap.add(2);

        assertEquals(2, heap.size());

        Integer[] expected = new Integer[MaxHeap.INITIAL_CAPACITY];
        expected[1] = 4;
        expected[2] = 2;
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddNotFull() {
        heap.add(6);

        /*
         * 6
         */
        assertEquals(1, heap.size());
        Integer[] expected = new Integer[MaxHeap.INITIAL_CAPACITY];
        expected[1] = 6;
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(12);

        /*
         * 12 / 6
         */

        assertEquals(2, heap.size());
        expected[1] = 12;
        expected[2] = 6;
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(3);

        /*
         * 12 / \ 6 3
         */

        assertEquals(3, heap.size());
        expected[1] = 12;
        expected[2] = 6;
        expected[3] = 3;
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(4);

        /*
         * 12 / \ 6 3 / 4
         */

        assertEquals(4, heap.size());
        expected[1] = 12;
        expected[2] = 6;
        expected[3] = 3;
        expected[4] = 4;
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(8);

        /*
         * 12 / \ 8 3 / \ 4 6
         */

        assertEquals(5, heap.size());
        expected[1] = 12;
        expected[2] = 8;
        expected[3] = 3;
        expected[4] = 4;
        expected[5] = 6;
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(99);

        /*
         * 99 / \ 8 12 / \ / 4 6 3
         */

        assertEquals(6, heap.size());
        expected[1] = 99;
        expected[2] = 8;
        expected[3] = 12;
        expected[4] = 4;
        expected[5] = 6;
        expected[6] = 3;
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(76);

        /*
         * 99 / \ 8 76 / \ / \ 4 6 3 12
         */

        assertEquals(7, heap.size());
        expected[1] = 99;
        expected[2] = 8;
        expected[3] = 76;
        expected[4] = 4;
        expected[5] = 6;
        expected[6] = 3;
        expected[7] = 12;
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(5);
        /*
         * 99 / \ 8 76 / \ / \ 5 6 3 12 / 4
         */
        assertEquals(8, heap.size());
        expected[1] = 99;
        expected[2] = 8;
        expected[3] = 76;
        expected[4] = 5;
        expected[5] = 6;
        expected[6] = 3;
        expected[7] = 12;
        expected[8] = 4;
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(43);
        /*
         * 99 / \ 43 76 / \ / \ 8 6 3 12 / \ 4 5
         */

        assertEquals(9, heap.size());
        expected[1] = 99;
        expected[2] = 43;
        expected[3] = 76;
        expected[4] = 8;
        expected[5] = 6;
        expected[6] = 3;
        expected[7] = 12;
        expected[8] = 4;
        expected[9] = 5;
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(2);
        /*
         * 99 / \ 43 76 / \ / \ 8 6 3 12 / \ / 4 5 2
         */

        assertEquals(10, heap.size());
        expected[1] = 99;
        expected[2] = 43;
        expected[3] = 76;
        expected[4] = 8;
        expected[5] = 6;
        expected[6] = 3;
        expected[7] = 12;
        expected[8] = 4;
        expected[9] = 5;
        expected[10] = 2;
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(121);
        /*
         * 121 / \ 99 76 / \ / \ 8 43 3 12 / \ / \ 4 5 2 6
         */

        assertEquals(11, heap.size());
        expected[1] = 121;
        expected[2] = 99;
        expected[3] = 76;
        expected[4] = 8;
        expected[5] = 43;
        expected[6] = 3;
        expected[7] = 12;
        expected[8] = 4;
        expected[9] = 5;
        expected[10] = 2;
        expected[11] = 6;
        assertArrayEquals(expected, heap.getBackingArray());

    }

    @Test(timeout = TIMEOUT)
    public void testAddCapacityAtCapacity() {
        heap.add(6);
        heap.add(12);
        heap.add(3);
        heap.add(4);
        heap.add(8);
        heap.add(99);
        heap.add(76);
        heap.add(5);
        heap.add(43);
        heap.add(2);
        heap.add(121);
        heap.add(210);

        /*
         * 210 / \ 99 121 / \ / \ 8 43 76 12 / \ / \ / 4 5 2 6 3
         */

        assertEquals(12, heap.size());

        Integer[] expected = new Integer[MaxHeap.INITIAL_CAPACITY];
        expected[1] = 210;
        expected[2] = 99;
        expected[3] = 121;
        expected[4] = 8;
        expected[5] = 43;
        expected[6] = 76;
        expected[7] = 12;
        expected[8] = 4;
        expected[9] = 5;
        expected[10] = 2;
        expected[11] = 6;
        expected[12] = 3;
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddCapacityResize() {
        heap.add(6);
        heap.add(12);
        heap.add(3);
        heap.add(4);
        heap.add(8);
        heap.add(99);
        heap.add(76);
        heap.add(5);
        heap.add(43);
        heap.add(2);
        heap.add(121);
        heap.add(210);
        heap.add(312);

        /*
         * 312 / \ 99 210 / \ / \ 8 43 121 12 / \ / \ / \ 4 5 2 6 3 76
         */

        assertEquals(13, heap.size());
        Integer[] expected = new Integer[MaxHeap.INITIAL_CAPACITY * 2];
        expected[1] = 312;
        expected[2] = 99;
        expected[3] = 210;
        expected[4] = 8;
        expected[5] = 43;
        expected[6] = 121;
        expected[7] = 12;
        expected[8] = 4;
        expected[9] = 5;
        expected[10] = 2;
        expected[11] = 6;
        expected[12] = 3;
        expected[13] = 76;
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeapThenAddResize() {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(76);
        data.add(32);
        data.add(89);

        /*
         * 89 / \ 32 76
         */

        heap = new MaxHeap<>(data);
        assertEquals(3, heap.size());

        Integer[] expected = new Integer[7];
        expected[1] = 89;
        expected[2] = 32;
        expected[3] = 76;
        assertArrayEquals(expected, heap.getBackingArray());

        heap.add(56);
        heap.add(22);
        heap.add(165);
        assertEquals(6, heap.size());

        /*
         * 165 / \ 56 89 / \ / 32 22 76
         */

        expected[1] = 165;
        expected[2] = 56;
        expected[3] = 89;
        expected[4] = 32;
        expected[5] = 22;
        expected[6] = 76;
        assertArrayEquals(expected, heap.getBackingArray());

        expected = new Integer[14];
        heap.add(786);
        heap.add(45);

        /*
         * 786 / \ 56 165 / \ / \ 45 22 76 89 / 32
         */

        assertEquals(8, heap.size());
        expected[1] = 786;
        expected[2] = 56;
        expected[3] = 165;
        expected[4] = 45;
        expected[5] = 22;
        expected[6] = 76;
        expected[7] = 89;
        expected[8] = 32;
        assertArrayEquals(expected, heap.getBackingArray());

    }

    @Test(timeout = TIMEOUT)
    public void testAddAlwaysRoot() {
        heap.add(20);
        heap.add(30);
        heap.add(50);
        heap.add(80);
        heap.add(100);
        heap.add(200);
        heap.add(300);

        /*
         * 300 / \ 80 200 / \ / \ 20 50 30 100
         *
         *
         */

        assertEquals(7, heap.size());

        Integer[] expected = new Integer[MaxHeap.INITIAL_CAPACITY];
        expected[1] = 300;
        expected[2] = 80;
        expected[3] = 200;
        expected[4] = 20;
        expected[5] = 50;
        expected[6] = 30;
        expected[7] = 100;
        assertArrayEquals(expected, heap.getBackingArray());

    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddNullData() {
        heap.add(34);
        heap.add(33);
        heap.add(90);
        heap.add(null);
        heap.add(23);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveEmpty() {
        heap.remove();
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromOneElement() {
        heap.add(4);

        assertEquals(1, heap.size());
        Integer[] expected = new Integer[MaxHeap.INITIAL_CAPACITY];
        expected[1] = 4;
        assertArrayEquals(expected, heap.getBackingArray());

        assertEquals((Integer) 4, heap.remove());
        assertEquals(0, heap.size());
        expected[1] = null;
        expected[2] = null;
        assertArrayEquals(expected, heap.getBackingArray());

    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromTwoElements() {
        heap.add(885);
        heap.add(404);

        /*
         * 885 / 404
         */

        assertEquals(2, heap.size());
        assertFalse(heap.isEmpty());
        assertEquals((Integer) 885, heap.getMax());
        Integer[] expected = new Integer[MaxHeap.INITIAL_CAPACITY];
        expected[1] = 885;
        expected[2] = 404;
        assertArrayEquals(expected, heap.getBackingArray());

        assertEquals((Integer) 885, heap.remove());
        assertEquals(1, heap.size());
        expected[1] = 404;
        expected[2] = null;
        assertArrayEquals(expected, heap.getBackingArray());

    }

    @Test(timeout = TIMEOUT)
    public void testRemoveTwoElements() {
        heap.add(87);
        heap.add(65);
        heap.add(45);
        heap.add(23);

        /*
         * 87 / \ 65 45 / 23
         *
         */

        assertEquals(4, heap.size());
        Integer[] expected = new Integer[MaxHeap.INITIAL_CAPACITY];
        expected[1] = 87;
        expected[2] = 65;
        expected[3] = 45;
        expected[4] = 23;
        assertArrayEquals(expected, heap.getBackingArray());

        assertEquals((Integer) 87, heap.remove());

        /*
         * 65 / \ 23 45
         *
         *
         *
         */

        assertEquals(3, heap.size());
        expected[1] = 65;
        expected[2] = 23;
        expected[3] = 45;
        expected[4] = null;
        expected[5] = null;
        assertArrayEquals(expected, heap.getBackingArray());

        assertEquals((Integer) 65, heap.remove());

        /*
         * 45 / 23
         *
         */

        assertEquals(2, heap.size());
        expected[1] = 45;
        expected[2] = 23;
        expected[3] = null;
        expected[4] = null;
        expected[5] = null;
        assertArrayEquals(expected, heap.getBackingArray());

    }

    @Test(timeout = TIMEOUT)
    public void testRemoveWithTwoGoodChildren() {
        heap.add(87);
        heap.add(32);
        heap.add(42);
        /*
         *
         * 87 / \ 32 42
         *
         */

        assertEquals(3, heap.size());
        Integer[] expected = new Integer[MaxHeap.INITIAL_CAPACITY];
        expected[1] = 87;
        expected[2] = 32;
        expected[3] = 42;
        expected[4] = null;
        expected[5] = null;
        assertArrayEquals(expected, heap.getBackingArray());

        assertEquals((Integer) 87, heap.remove());
        /*
         *
         * 42 / 32
         *
         */
        assertEquals(2, heap.size());
        expected[1] = 42;
        expected[2] = 32;
        expected[3] = null;
        assertArrayEquals(expected, heap.getBackingArray());

    }

    @Test(timeout = TIMEOUT)
    public void testRemoveWithTwoBadChildren() {
        heap.add(87);
        heap.add(32);
        heap.add(42);
        heap.add(12);
        heap.add(14);
        assertFalse(heap.isEmpty());
        assertEquals((Integer) 87, heap.getMax());
        /*
         *
         * 87 / \ 32 42 / \ 12 14
         *
         */

        assertEquals(5, heap.size());
        Integer[] expected = new Integer[MaxHeap.INITIAL_CAPACITY];
        expected[1] = 87;
        expected[2] = 32;
        expected[3] = 42;
        expected[4] = 12;
        expected[5] = 14;
        assertArrayEquals(expected, heap.getBackingArray());

        assertEquals((Integer) 87, heap.remove());
        /*
         *
         * 14 / \ 32 42 / 12
         *
         */

        /*
         *
         * 42 / \ 32 14 / 12
         *
         */
        assertFalse(heap.isEmpty());
        assertEquals((Integer) 42, heap.getMax());
        assertEquals(4, heap.size());
        expected[1] = 42;
        expected[2] = 32;
        expected[3] = 14;
        expected[4] = 12;
        expected[5] = null;
        assertArrayEquals(expected, heap.getBackingArray());

    }

    @Test(timeout = TIMEOUT)
    public void testRemoveWithOneGoodChildOneBadChild() {
        heap.add(87);
        heap.add(10);
        heap.add(42);
        heap.add(8);
        heap.add(7);
        /*
         *
         * 87 / \ 10 42 / \ 8 7
         *
         */

        assertEquals(5, heap.size());
        Integer[] expected = new Integer[MaxHeap.INITIAL_CAPACITY];
        expected[1] = 87;
        expected[2] = 10;
        expected[3] = 42;
        expected[4] = 8;
        expected[5] = 7;
        assertArrayEquals(expected, heap.getBackingArray());

        assertEquals((Integer) 87, heap.remove());
        /*
         *
         * 7 / \ 10 42 / 8
         *
         */

        /*
         *
         * 42 / \ 10 7 / 8
         *
         */

        assertEquals(4, heap.size());
        expected[1] = 42;
        expected[2] = 10;
        expected[3] = 7;
        expected[4] = 8;
        expected[5] = null;
        assertArrayEquals(expected, heap.getBackingArray());

    }

    @Test(timeout = TIMEOUT)
    public void testAddRemoveMix() {
        heap.add(43);
        heap.add(88);
        heap.add(13);
        assertEquals(3, heap.size());
        assertEquals((Integer) 88, heap.remove());
        assertEquals(2, heap.size());
        heap.add(23);
        heap.add(992);
        heap.add(87);
        heap.add(12);
        heap.add(432);
        assertEquals(7, heap.size());
        assertEquals((Integer) 992, heap.remove());
        assertEquals((Integer) 432, heap.remove());
        assertEquals(5, heap.size());
        heap.add(845);
        heap.add(1);
        heap.add(233);
        heap.add(10);
        assertEquals(9, heap.size());
        assertEquals((Integer) 845, heap.remove());
        assertEquals((Integer) 233, heap.remove());
        assertEquals((Integer) 87, heap.remove());
        assertEquals(6, heap.size());

        Integer[] expected = new Integer[MaxHeap.INITIAL_CAPACITY];
        expected[1] = 43;
        expected[2] = 13;
        expected[3] = 23;
        expected[4] = 1;
        expected[5] = 12;
        expected[6] = 10;
        assertArrayEquals(expected, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveCapacityResize() {
        heap.add(6);
        heap.add(12);
        heap.add(3);
        heap.add(4);
        heap.add(8);
        heap.add(99);
        heap.add(76);
        heap.add(5);
        heap.add(43);
        heap.add(2);
        heap.add(121);
        heap.add(210);
        heap.add(312);

        /*
         * 312 / \ 99 210 / \ / \ 8 43 121 12 / \ / \ / \ 4 5 2 6 3 76
         */

        assertEquals(13, heap.size());
        Integer[] expected = new Integer[MaxHeap.INITIAL_CAPACITY * 2];
        expected[1] = 312;
        expected[2] = 99;
        expected[3] = 210;
        expected[4] = 8;
        expected[5] = 43;
        expected[6] = 121;
        expected[7] = 12;
        expected[8] = 4;
        expected[9] = 5;
        expected[10] = 2;
        expected[11] = 6;
        expected[12] = 3;
        expected[13] = 76;
        assertArrayEquals(expected, heap.getBackingArray());

        assertEquals((Integer) 312, heap.remove());
        assertEquals((Integer) 210, heap.remove());
        assertEquals(11, heap.size());

        expected[1] = 121;
        expected[2] = 99;
        expected[3] = 76;
        expected[4] = 8;
        expected[5] = 43;
        expected[6] = 3;
        expected[7] = 12;
        expected[8] = 4;
        expected[9] = 5;
        expected[10] = 2;
        expected[11] = 6;
        expected[12] = null;
        expected[13] = null;
        assertArrayEquals(expected, heap.getBackingArray());

    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeapLargerRemove() {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(6);
        data.add(12);
        data.add(3);
        data.add(4);
        data.add(8);
        data.add(99);
        data.add(76);
        data.add(5);
        data.add(43);
        data.add(2);
        data.add(121);
        data.add(210);
        data.add(312);
        heap = new MaxHeap<>(data);

        assertEquals(13, heap.size());

        assertEquals((Integer) 312, heap.remove());
        assertEquals((Integer) 210, heap.remove());
        assertEquals((Integer) 121, heap.remove());
        assertEquals((Integer) 99, heap.remove());
        assertEquals(9, heap.size());

        Integer[] expected = new Integer[2 * 13 + 1];
        expected[1] = 76;
        expected[2] = 43;
        expected[3] = 8;
        expected[4] = 5;
        expected[5] = 12;
        expected[6] = 6;
        expected[7] = 2;
        expected[8] = 3;
        expected[9] = 4;
        expected[10] = null;
        expected[11] = null;
        expected[12] = null;
        expected[13] = null;
        assertArrayEquals(expected, heap.getBackingArray());

    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAll() {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(6);
        data.add(12);
        data.add(3);
        data.add(4);
        data.add(8);
        data.add(99);
        data.add(76);
        data.add(5);
        data.add(43);
        data.add(2);
        data.add(121);
        data.add(210);
        data.add(312);
        heap = new MaxHeap<>(data);

        assertEquals(13, heap.size());
        assertFalse(heap.isEmpty());
        assertEquals((Integer) 312, heap.getMax());

        assertEquals((Integer) 312, heap.remove());
        assertEquals((Integer) 210, heap.remove());
        assertEquals((Integer) 121, heap.remove());
        assertEquals((Integer) 99, heap.remove());
        assertFalse(heap.isEmpty());
        assertEquals((Integer) 76, heap.getMax());
        assertEquals((Integer) 76, heap.remove());
        assertEquals((Integer) 43, heap.remove());
        assertEquals((Integer) 12, heap.remove());
        assertEquals((Integer) 8, heap.remove());
        assertEquals((Integer) 6, heap.remove());
        assertFalse(heap.isEmpty());
        assertEquals((Integer) 5, heap.getMax());
        assertEquals((Integer) 5, heap.remove());
        assertEquals((Integer) 4, heap.remove());
        assertEquals((Integer) 3, heap.remove());
        assertEquals((Integer) 2, heap.remove());

        assertEquals(0, heap.size());
        assertTrue(heap.isEmpty());

        Integer[] expected = new Integer[2 * 13 + 1];
        expected[1] = null;
        expected[2] = null;
        expected[3] = null;
        expected[4] = null;
        expected[5] = null;
        expected[6] = null;
        expected[7] = null;
        expected[8] = null;
        expected[9] = null;
        expected[10] = null;
        expected[11] = null;
        expected[12] = null;
        expected[13] = null;
        assertArrayEquals(expected, heap.getBackingArray());

    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testGetMaxEmpty() {
        heap.getMax();
    }

    @Test(timeout = TIMEOUT)
    public void testIsEmpty() {
        assertTrue(heap.isEmpty());
    }

    @Test(timeout = TIMEOUT)
    public void testClear() {
        heap.add(14);
        heap.add(13);
        heap.add(32);
        assertEquals(3, heap.size());
        heap.clear();
        assertEquals(0, heap.size());
    }

}
