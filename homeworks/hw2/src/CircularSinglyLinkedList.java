import java.util.NoSuchElementException;

/**
 * Your implementation of a CircularSinglyLinkedList without a tail pointer.
 *
 * @author Aaryan Potdar
 * @version 1.0
 * @userid apotdar31
 * @GTID 903795148
 *
 * Collaborators: utilized Junits created by other students shared on the GT githiub
 *
 * Resources: LIST ALL NON-COURSE RESOURCES YOU CONSULTED HERE
 */
public class CircularSinglyLinkedList<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private CircularSinglyLinkedListNode<T> head;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the data to the specified index.
     *
     * Must be O(1) for indices 0 and size and O(n) for all other cases.
     *
     * @param index the index at which to add the new data
     * @param data  the data to add at the specified index
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index > size
     * @throws java.lang.IllegalArgumentException  if data is null
     */
    public void addAtIndex(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds. Cannot add node as index is "
                    + (index < 0 ? "negative" : "to large"));
        }
        if (data == null) {
            throw new IllegalArgumentException("Cannot add null value to the list");
        }
        if (index == 0) {
            addToFront(data);
        } else if (index == size) {
            addToBack(data);
        } else {
            CircularSinglyLinkedListNode<T> curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.getNext();
            }
            CircularSinglyLinkedListNode<T> newNode = new CircularSinglyLinkedListNode<>(data, curr.getNext());
            curr.setNext(newNode);
            size++;
        }
    }

    /**
     * Adds the data to the front of the list.
     *
     * Must be O(1).
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot null data to the list");
        }
        if (head == null) { //empty list
            head = new CircularSinglyLinkedListNode<>(data);
            head.setNext(head);
        } else {
            CircularSinglyLinkedListNode<T> newNode;
            newNode = new CircularSinglyLinkedListNode<>(head.getData(), head.getNext());
            head.setNext(newNode);
            head.setData(data);
        }
        size++;
    }

    /**
     * Adds the data to the back of the list.
     *
     * Must be O(1).
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot add null data to the list");
        } else {
            addToFront(data); //add to front
            head = head.getNext(); // rotate the list
        }
    }

    /**
     * Removes and returns the data at the specified index.
     *
     * Must be O(1) for index 0 and O(n) for all other cases.
     *
     * @param index the index of the data to remove
     * @return the data formerly located at the specified index
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index >= size
     */
    public T removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds. Cannot add node as index is "
                    + (index < 0 ? "negative" : "to large"));
        }
        if (index == 0) {
            return removeFromFront();
        } else {
            CircularSinglyLinkedListNode<T> curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.getNext();
            }
            T data = curr.getNext().getData();
            curr.setNext(curr.getNext().getNext()); //node removed
            size--;
            return data;
        }
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Must be O(1).
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot remove node from an empty list");
        }
        if (size == 1) {
            T data = head.getData();
            head = null;
            size--;
            return data;
        }
        T data = head.getData();
        head.setData(head.getNext().getData()); //delete head data, keep node
        head.setNext(head.getNext().getNext()); // copy next data, delete next node
        size--;
        return data;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Must be O(n).
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot remove node from an empty list");
        } else if (size == 1) {
            T data = head.getData();
            head = null;
            size--;
            return data;
        } else {
            return removeAtIndex(size - 1);
        }
    }

    /**
     * Returns the data at the specified index.
     *
     * Should be O(1) for index 0 and O(n) for all other cases.
     *
     * @param index the index of the data to get
     * @return the data stored at the index in the list
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index >= size
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if (index == 0) {
            return head.getData();
        }
        CircularSinglyLinkedListNode<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }
        return curr.getData();
    }

    /**
     * Returns whether the list is empty.
     *
     * Must be O(1).
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Clears the list.
     *
     * Clears all data and resets the size.
     *
     * Must be O(1).
     */
    public void clear() {
        size = 0;
        head = null;
    }

    /**
     * Removes and returns the last copy of the given data from the list.
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the list.
     *
     * Must be O(n).
     *
     * @param data the data to be removed from the list
     * @return the data that was removed
     * @throws java.lang.IllegalArgumentException if data is null
     * @throws java.util.NoSuchElementException   if data is not found
     */
    public T removeLastOccurrence(T data) {
        if (data == null) {
            throw new IllegalArgumentException("The linked list does not contain null data.");
        }
        if (size == 0) {
            return null;
        } else {
            CircularSinglyLinkedListNode<T> curr = head;
            CircularSinglyLinkedListNode<T> prev = null;
            if (head.getData().equals(data)) {
                prev = curr;
            }
            while (curr.getNext() != head) {
                if (curr.getNext().getData().equals(data)) {
                    prev = curr;
                }
                curr = curr.getNext();
            }
            if (prev != null) {
                T result = prev.getNext().getData();
                prev.setNext(prev.getNext().getNext());
                if (size - 1 == 0) {
                    clear();
                }
                size--;
                return result;
            } else {
                throw new NoSuchElementException("Node to be removed not found.");
            }
        }
    }

    /**
     * Returns an array representation of the linked list.
     *
     * Must be O(n) for all cases.
     *
     * @return the array of length size holding all of the data (not the
     * nodes) in the list in the same order
     */
    public T[] toArray() {
        T[] myArr = (T[]) new Object[size]; //create new array
        CircularSinglyLinkedListNode<T> curr = head;
        for (int i = 0; i < size; i++) {
            myArr[i] = curr.getData();
            curr = curr.getNext();
        }
        return myArr;
    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public CircularSinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY!
        return head;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY!
        return size;
    }
}
