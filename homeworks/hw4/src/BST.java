import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Your implementation of a BST.
 *
 * @author AARYAN POTDAR
 * @version 1.0
 * @userid apotdar31
 * @GTID 903795148
 *
 * Collaborators: LIST ALL COLLABORATORS YOU WORKED WITH HERE
 *
 * Resources: JUnits tests on github shared in the class piazza
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /**
     * Constructs a new BST.
     *
     * This constructor should initialize an empty BST.
     *
     * Since instance variables are initialized to their default values, there
     * is no need to do anything for this constructor.
     */
    public BST() {
        // DO NOT IMPLEMENT THIS CONSTRUCTOR!
    }

    /**
     * Constructs a new BST.
     *
     * This constructor should initialize the BST with the data in the
     * Collection. The data should be added in the same order it is in the
     * Collection.
     *
     * Hint: Not all Collections are indexable like Lists, so a regular for loop
     * will not work here. However, all Collections are Iterable, so what type
     * of loop would work?
     *
     * @param data the data to add
     * @throws java.lang.IllegalArgumentException if data or any element in data
     *                                            is null
     */
    public BST(Collection<T> data) {
        if (data == null) {
            throw new IllegalArgumentException("Input data cannot be null");
        }
        size = 0;
        for (T val : data) {
            add(val);
        }
    }

    /**
     * Adds the data to the tree.
     *
     * This must be done recursively.
     *
     * The data becomes a leaf in the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data the data to add
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot add null data");
        }
        root = recurseAdd(root, data);
    }

    /**
     * Recursive helper method for add operation.
     * @param curr node to iterate on
     * @param data data to add
     * @return returns new node
     */
    private BSTNode<T> recurseAdd(BSTNode<T> curr, T data) {
        if (curr == null) {
            size++;
            return new BSTNode<>(data);
        }
        if (data.compareTo(curr.getData()) < 0) {
            curr.setLeft(recurseAdd(curr.getLeft(), data));
        } else if (data.compareTo(curr.getData()) > 0) {
            curr.setRight(recurseAdd(curr.getRight(), data));
        }
        return curr;
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the successor to
     * replace the data. You MUST use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data the data to remove
     * @return the data that was removed
     * @throws java.lang.IllegalArgumentException if data is null
     * @throws java.util.NoSuchElementException   if the data is not in the tree
     */
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot remove null data from tree.");
        }
        BSTNode<T> dummy = new BSTNode<T>(null);
        root = recurseRemove(root, data, dummy);
        return dummy.getData();
    }

    /**
     * Recursive helper method for remove operation.
     * @param node node to iterate using
     * @param data data to be removed
     * @param dummy dummy node to return the data to be removed
     * @return BST node
     */
    private BSTNode<T> recurseRemove(BSTNode<T> node, T data, BSTNode<T> dummy) {
        if (node == null) {
            throw new NoSuchElementException("Data to be removed not in BST");
        } else if (data.compareTo(node.getData()) < 0) {
            node.setLeft(recurseRemove(node.getLeft(), data, dummy));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(recurseRemove(node.getRight(), data, dummy));
        } else {
            dummy.setData(node.getData());
            size--;
            if (node.getLeft() != null && node.getRight() != null) {
                // 2 child case, remove using successor
                BSTNode<T> dummy2 = new BSTNode<T>(null);
                node.setRight(recSuccessor(node.getRight(), dummy2));
                node.setData(dummy2.getData());
            } else if (node.getLeft() != null) {
                // only left child
                return node.getLeft();
            } else if (node.getRight() != null) {
                // only right child
                return node.getRight();
            } else {
                return null;
            }
        }
        return node;
    }

    /**
     * Recursive helper method for retrieving successor node
     * @param node node to iterate using
     * @param dummy2 dummy node to return data
     * @return BST node
     */
    private BSTNode<T> recSuccessor(BSTNode<T> node, BSTNode<T> dummy2) {
        if (node.getLeft() == null) {
            dummy2.setData(node.getData());
            return node.getRight();
        } else {
            node.setLeft(recSuccessor(node.getLeft(), dummy2));
        }
        return node;
    }

    /**
     * Returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data the data to search for
     * @return the data in the tree equal to the parameter
     * @throws java.lang.IllegalArgumentException if data is null
     * @throws java.util.NoSuchElementException   if the data is not in the tree
     */
    public T get(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Input data is null");
        }
        return recurseGet(data, root);
    }

    /**
     * Recursive helper method for get operation.
     * @param data data to search for
     * @param node node to iterate tree using
     * @return data found
     */
    private T recurseGet(T data, BSTNode<T> node) {
        if (node == null) {
            throw new NoSuchElementException("Data was not found in the tree");
        }
        int value = data.compareTo(node.getData());
        if (data.equals(node.getData())) {
            return node.getData();
        } else if (value < 0) {
            return recurseGet(data, node.getLeft());
        } else if (value > 0) {
            return recurseGet(data, node.getRight());
        }
        return null;
    }

    /**
     * Returns whether or not data matching the given parameter is contained
     * within the tree.
     *
     * This must be done recursively.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data the data to search for
     * @return true if the parameter is contained within the tree, false
     * otherwise
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public boolean contains(T data) {
        try {
            get(data);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    /**
     * Generate a pre-order traversal of the tree.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @return the preorder traversal of the tree
     */
    public List<T> preorder() {
        List<T> list = new ArrayList<>();
        preorderRec(list, root);
        return list;
    }

    /**
     * Recursive helper method for preorder traversal.
     * @param list list to populate
     * @param curr node in BST
     */
    private void preorderRec(List<T> list, BSTNode<T> curr) {
        if (curr == null) {
            return;
        } else {
            list.add(curr.getData());
            preorderRec(list, curr.getLeft());
            preorderRec(list, curr.getRight());
        }
    }

    /**
     * Generate an in-order traversal of the tree.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @return the inorder traversal of the tree
     */
    public List<T> inorder() {
        List<T> list = new ArrayList<>();
        inorderRec(list, root);
        return list;
    }

    /**
     * Recursive helper method for inorder traversal.
     * @param list list to add to
     * @param curr node in BST
     */
    private void inorderRec(List<T> list, BSTNode<T> curr) {
        if (curr == null) {
            return;
        } else {
            inorderRec(list, curr.getLeft());
            list.add(curr.getData());
            inorderRec(list, curr.getRight());
        }
    }

    /**
     * Generate a post-order traversal of the tree.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @return the postorder traversal of the tree
     */
    public List<T> postorder() {
        List<T> list = new ArrayList<>();
        postorderRec(list, root);
        return list;
    }

    /**
     * Recursive helper method for postorder traversal.
     * @param list list to add to
     * @param curr node in BST
     */
    private void postorderRec(List<T> list, BSTNode<T> curr) {
        if (curr == null) {
            return;
        } else {
            postorderRec(list, curr.getLeft());
            postorderRec(list, curr.getRight());
            list.add(curr.getData());
        }
    }

    /**
     * Generate a level-order traversal of the tree.
     *
     * This does not need to be done recursively.
     *
     * Hint: You will need to use a queue of nodes. Think about what initial
     * node you should add to the queue and what loop / loop conditions you
     * should use.
     *
     * Must be O(n).
     *
     * @return the level order traversal of the tree
     */
    public List<T> levelorder() {
        Queue<BSTNode<T>> tempQueue = new LinkedList<>();
        List<T> data = new ArrayList<>();
        tempQueue.add(root);
        while (!tempQueue.isEmpty()) {
            BSTNode<T> temp = tempQueue.poll();
            data.add(temp.getData());
            if (temp.getLeft() != null) {
                tempQueue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                tempQueue.add(temp.getRight());
            }
        }
        return data;
    }

    /**
     * Returns the height of the root of the tree.
     *
     * This must be done recursively.
     *
     * A node's height is defined as max(left.height, right.height) + 1. A
     * leaf node has a height of 0 and a null child has a height of -1.
     *
     * Must be O(n).
     *
     * @return the height of the root of the tree, -1 if the tree is empty
     */
    public int height() {
        return heightRec(root);
    }

    /**
     * Recursive helper method for get height operation.
     * @param node node to iterate through tree
     * @return int height
     */
    public int heightRec(BSTNode<T> node) {
        if (node == null) {
            return -1;
        } else {
            int left = heightRec(node.getLeft());
            int right = heightRec(node.getRight());
            return 1 + (left > right ? left : right);
        }
    }

    /**
     * Clears the tree.
     *
     * Clears all data and resets the size.
     *
     * Must be O(1).
     */
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Finds and retrieves the k-largest elements from the BST in sorted order,
     * least to greatest.
     *
     * This must be done recursively.
     *
     * In most cases, this method will not need to traverse the entire tree to
     * function properly, so you should only traverse the branches of the tree
     * necessary to get the data and only do so once. Failure to do so will
     * result in an efficiency penalty.
     *
     * EXAMPLE: Given the BST below composed of Integers:
     *
     *                50
     *              /    \
     *            25      75
     *           /  \
     *          12   37
     *         /  \    \
     *        10  15    40
     *           /
     *          13
     *
     * kLargest(5) should return the list [25, 37, 40, 50, 75].
     * kLargest(3) should return the list [40, 50, 75].
     *
     * Should have a running time of O(log(n) + k) for a balanced tree and a
     * worst case of O(n + k), with n being the number of data in the BST
     *
     * @param k the number of largest elements to return
     * @return sorted list consisting of the k largest elements
     * @throws java.lang.IllegalArgumentException if k < 0 or k > size
     */
    public List<T> kLargest(int k) {
        if (k > size) {
            throw new IllegalArgumentException(k + "is bigger than size of tree");
        }
        if (k < 0) {
            throw new IllegalArgumentException(k + "is negative");
        }
        List<T> list = new ArrayList(k);
        return kLargestRec(list, root, k);
    }

    /**
     * Recursive helper method for finding kLargest elememts.
     * @param list list to add elements to
     * @param node node to iterate through BST
     * @param k the number of largest elements to return
     * @return returns a list of k largest elements in the BST
     */
    private List<T> kLargestRec(List<T> list, BSTNode<T> node, int k) {
        if (node == null) {
            return list;
        } else {
            kLargestRec(list, node.getRight(), k);
            if (list.size() == k) {
                return list;
            } else {
                list.add(0, node.getData());
                kLargestRec(list, node.getLeft(), k);
            }
        }
        return list;
    }


    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}
