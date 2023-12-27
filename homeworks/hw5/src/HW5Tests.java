import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * This is a basic set of unit tests for MaxHeap.
 *
 * Passing these tests doesn't guarantee any grade on these assignments. These
 * student JUnits that we provide should be thought of as a sanity check to
 * help you get started on the homework and writing JUnits in general.
 *
 * We highly encourage you to write your own set of JUnits for each homework
 * to cover edge cases you can think of for each data structure. Your code must
 * work correctly and efficiently in all cases, which is why it's important
 * to write comprehensive tests to cover as many cases as possible.
 *
 * @author CS 1332 TAs
 * @version 1.0
 */
public class HW5Tests {

    private static final int TIMEOUT = 200;
    private MaxHeap<Integer> heap;

    @Before
    public void setUp() {
        heap = new MaxHeap<>();
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeapNullData() {
        //throws error if the array list is null

        ArrayList<Integer> data = null;

        assertThrows(IllegalArgumentException.class, () -> {
            heap = new MaxHeap<>(data);
        });
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeapOnePieceNullData() {
        //throws error if any element in array list is null

        ArrayList<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(null);

        assertThrows(IllegalArgumentException.class, () -> {
            heap = new MaxHeap<>(data);
        });
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeap() {

        ArrayList<Integer> data = new ArrayList<>();
        data.add(3);
        data.add(4);
        data.add(1);
        data.add(14);
        data.add(9);
        data.add(11);
        data.add(2);
        data.add(0);

        Integer[] checkArray = {null, 14,9,11,4,3,1,2,0, null, null, null, null, null, null, null, null};
        //first index is null, empty is null
        for(int i = 0; i < checkArray.length; i++) {
            System.out.println(checkArray[i]);
        }

        heap = new MaxHeap<>(data);

        assertArrayEquals(checkArray, heap.getBackingArray());
        assertEquals(8, heap.size()); //size is 8
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeapOnlyLeaves() {
        //happens when 3 or 7 or such elements

        ArrayList<Integer> data = new ArrayList<>();
        data.add(3);
        data.add(5);
        data.add(9);

        heap = new MaxHeap<>(data);

        Integer[] checkArray = {null, 9,5,3, null, null, null}; //size = 2n+1 = 7

        assertArrayEquals(checkArray, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testBuildHeapOnlyLeftChild() {
        //happens when 4 elements

        ArrayList<Integer> data = new ArrayList<>();
        data.add(3);
        data.add(5);
        data.add(9);
        data.add(8);

        heap = new MaxHeap<>(data);

        Integer[] checkArray = {null,9,8,3,5, null, null, null, null}; //size = 2n+1 = 9

        assertArrayEquals(checkArray, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddThrowsError() {
        //throws error if data to add is null

        ArrayList<Integer> data = new ArrayList<>();

        data.add(3);
        data.add(4);
        data.add(1);
        data.add(14);
        data.add(9);
        data.add(11);
        data.add(2);
        data.add(0);

        heap = new MaxHeap<>(data);

        assertThrows(IllegalArgumentException.class, () -> {
            heap.add(null);
        });
    }

    @Test(timeout = TIMEOUT)
    public void addToEmptyHeap() {

        heap = new MaxHeap<>();
        heap.add(1);

        Integer[] checkArray = {null, 1, null, null, null, null, null, null, null, null, null, null, null};
        //first index is null, all rest null

        assertArrayEquals(checkArray, heap.getBackingArray());
        assertEquals(1, heap.size()); //size just affected by increment
        //assertEquals(heap.getBackingArray().length, 13); //array length is 13

    }

    @Test(timeout = TIMEOUT)
    public void addToHeapSimple() {

        heap = new MaxHeap<>();
        heap.add(5);
        heap.add(2);
        heap.add(9);
        heap.add(16);

        Integer[] checkArray = {null, 16,9,5,2, null, null, null, null, null, null, null, null}; //first index is null, rest null

        assertArrayEquals(checkArray, heap.getBackingArray());
        assertEquals(4, heap.size()); //size just affected by increment
        //assertEquals(heap.getBackingArray().length, 13); //array length is 13
    }

    @Test(timeout = TIMEOUT)
    public void addToHeapResize() {

        ArrayList<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(3);
        data.add(4);

        heap = new MaxHeap<>(data);
        //array length is 2n+1 = 7

        Integer[] checkArray1 = {null, 4,3,1, null, null, null};

        assertArrayEquals(checkArray1, heap.getBackingArray());
        assertEquals(3, heap.size());
        //assertEquals(heap.getBackingArray().length, 7); //2n+1

        heap.add(2);
        heap.add(5);
        heap.add(6);
        heap.add(8);

        //now need to resize, so length is 2*7 = 14

        Integer[] checkArray2 = {null, 8,4,6,2,3,1,5, null, null, null, null, null, null};

        assertArrayEquals(checkArray2, heap.getBackingArray());
        assertEquals(7, heap.size());
        //assertEquals(heap.getBackingArray().length, 14); //2*(2n+1) = 14

    }

    @Test(timeout = TIMEOUT)
    public void multipleResizes() {

        ArrayList<Integer> data = new ArrayList<>();
        data.add(5);

        heap = new MaxHeap<>(data);
        //array length is 2n+1 = 3

        Integer[] checkArray1 = {null, 5,null};

        assertArrayEquals(checkArray1, heap.getBackingArray());
        assertEquals(1, heap.size());
        //assertEquals(heap.getBackingArray().length, 3); //2n+1

        heap.add(2);
        heap.add(9);

        Integer[] checkArray2 = {null, 9,2,5, null, null}; //new size = 6

        assertArrayEquals(checkArray2, heap.getBackingArray());
        assertEquals(3, heap.size());
        //assertEquals(heap.getBackingArray().length, 6); //2n+1

        //now resize again when you add 3 more times, and new size = 12

        heap.add(6);
        heap.add(1);
        heap.add(19);

        Integer[] checkArray3 = {null, 19,6,9,2,1,5, null, null, null, null, null};

        assertArrayEquals(checkArray3, heap.getBackingArray());
        assertEquals(6, heap.size());
        //assertEquals(heap.getBackingArray().length, 12);
    }

    @Test(timeout = TIMEOUT)
    public void removeThrowsError() {

        //when heap is null
        heap = new MaxHeap<>();

        assertThrows(NoSuchElementException.class, () -> {
            heap.remove();
        });
    }

    @Test(timeout = TIMEOUT)
    public void multipleRemoveThrowsError() {

        //when list is null
        ArrayList<Integer> data = new ArrayList<>();
        data.add(3);
        data.add(4);
        data.add(1);
        heap = new MaxHeap<>(data);
        heap.remove();
        heap.remove();
        heap.remove();
        //now heap is empty

        assertThrows(NoSuchElementException.class, () -> {
            heap.remove(); //so this remove should throw an error
        });
    }


    @Test(timeout = TIMEOUT)
    public void removeJustRootHeap() {

        //when heap only has root element
        heap = new MaxHeap<>();
        heap.add(1);
        heap.remove();
        //now heap is empty

        assertEquals(0, heap.size());
        //assertEquals(heap.getBackingArray().length, 13); //length still initial 13
    }

    @Test(timeout = TIMEOUT)
    public void removeWith2Elements() {

        //when heap only has root and more element
        heap = new MaxHeap<>();
        heap.add(1);
        heap.add(3);
        //now heap root is 3
        assertEquals((Integer) 3, heap.remove());

        Integer[] checkArray = {null,1,null,null,null,null,null,null,null,null,null,null,null};

        assertEquals(1, heap.size());
        //assertEquals(heap.getBackingArray().length, 13); //length still initial 13
        assertArrayEquals(checkArray, heap.getBackingArray());
    }

    @Test(timeout = TIMEOUT)
    public void remove2Children() {

        //5 element heap

        ArrayList<Integer> data = new ArrayList<>();
        data.add(3);
        data.add(5);
        data.add(9);
        data.add(8);
        data.add(10);

        heap = new MaxHeap<>(data);

        assertEquals((Integer) 10, heap.remove()); //should remove the 10

        Integer[] checkArray = {null, 9,8,5,3, null, null, null, null, null, null}; //length = 2n+1 = 11

        assertEquals(4, heap.size()); //5 - 1
        //assertEquals(heap.getBackingArray().length, 11); //length is still 11
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveOnlyLeftChild() {
        //happens when 4 elements

        ArrayList<Integer> data = new ArrayList<>();
        data.add(3);
        data.add(5);
        data.add(9);
        data.add(8);

        heap = new MaxHeap<>(data);

        assertEquals((Integer) 9, heap.remove()); //should remove 9

        Integer[] checkArray = {null,8,5,3, null, null, null, null, null}; //size = 2n+1 = 9

        assertArrayEquals(checkArray, heap.getBackingArray());
        assertEquals(3, heap.size());
        //assertEquals(heap.getBackingArray().length, 9); //length is 9
    }

    @Test(timeout = TIMEOUT)
    public void testGetMaxThrowsError() {
        heap = new MaxHeap<>();

        assertThrows(NoSuchElementException.class, () -> {
            heap.getMax(); //so this get max should return error as heap is empty
        });
    }

    @Test(timeout = TIMEOUT)
    public void testGetMax() {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(3);
        data.add(5);
        data.add(9);
        data.add(8);

        heap = new MaxHeap<>(data);

        assertEquals((Integer) 9, heap.getMax());
    }

    @Test(timeout = TIMEOUT)
    public void testIsEmptyTrue() {
        heap = new MaxHeap<>();

        assertTrue(heap.isEmpty());
    }

    @Test(timeout = TIMEOUT)
    public void testIsEmptyFalse() {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(3);
        data.add(5);
        data.add(9);
        data.add(8);

        heap = new MaxHeap<>(data);

        assertFalse(heap.isEmpty());
    }

    @Test(timeout = TIMEOUT)
    public void testIsClear() {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(3);
        data.add(5);
        data.add(9);
        data.add(8);

        heap = new MaxHeap<>(data);

        heap.clear();

        Integer[] checkArray = {null,null,null,null,null,null,null,null,null,null,null,null, null}; //13 nulls (initial size)

        assertArrayEquals(checkArray, heap.getBackingArray());

        assertEquals(0, heap.size());

        //assertEquals(heap.getBackingArray().length, 9);
    }


}