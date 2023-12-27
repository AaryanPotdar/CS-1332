import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Your implementation of an AVL.
 *
 * @author Aaryan Potdar
 * @version 1.0
 * @userid apotdar31
 * @GTID 903795148
 *
 * Collaborators: LIST ALL COLLABORATORS YOU WORKED WITH HERE
 *
 * Resources: LIST ALL NON-COURSE RESOURCES YOU CONSULTED HERE
 */
public class AVL<T extends Comparable<? super T>> {

    // Do not add new instance variables or modify existing ones.
    private AVLNode<T> root;
    private int size;

    /**
     * Constructs a new AVL.
     *
     * This constructor should initialize an empty AVL.
     *
     * Since instance variables are initialized to their default values, there
     * is no need to do anything for this constructor.
     */
    public AVL() {
        // DO NOT IMPLEMENT THIS CONSTRUCTOR!
    }

    /**
     * Constructs a new AVL.
     *
     * This constructor should initialize the AVL with the data in the
     * Collection. The data should be added in the same order it is in the
     * Collection.
     *
     * @param data the data to add to the tree
     * @throws java.lang.IllegalArgumentException if data or any element in data
     *                                            is null
     */
    public AVL(Collection<T> data) {
        if (data == null) {
            throw new IllegalArgumentException("Input data is null");
        }

        for (T temp : data) {
            if (temp == null) {
                root = null;
                size = 0;
                throw new IllegalArgumentException("data is null");
            }
            add(temp);
        }
    }

    /**
     * Adds the element to the tree.
     *
     * Start by adding it as a leaf like in a regular BST and then rotate the
     * tree as necessary.
     *
     * If the data is already in the tree, then nothing should be done (the
     * duplicate shouldn't get added, and size should not be incremented).
     *
     * Remember to recalculate heights and balance factors while going back
     * up the tree after adding the element, making sure to rebalance if
     * necessary.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * @param data the data to add
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Input data is null");
        }
        root = addHelper(data, root);
    }

    /**
     * Recursive helper method for add function.
     * @param data data to be added
     * @param node node to iterate using
     * @return returns AVL node
     */
    private AVLNode<T> addHelper(T data, AVLNode<T> node) {
        if (node == null) {
            size++;
            node = new AVLNode<T>(data);
        } else if (data.compareTo(node.getData()) < 0) {
            node.setLeft(addHelper(data, node.getLeft()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(addHelper(data, node.getRight()));
        }
        balance(node);
        return node;
    }

    /**
     * Balance method.
     * @param temp AVL node to iterate over.
     */
    private void balance(AVLNode<T> temp) {
        update(temp);
        if (temp.getBalanceFactor() > 1) {
            if (temp.getLeft().getBalanceFactor() < 0) {
                leftRotate(temp.getLeft());
            }
            rightRotate(temp);
        } else if (temp.getBalanceFactor() < -1) {
            if (temp.getRight().getBalanceFactor() > 0) {
                rightRotate(temp.getRight());
            }
            leftRotate(temp);
        }
    }

    /**
     * Right rotate method.
     * @param temp node to rotate
     */
    private void rightRotate(AVLNode<T> temp) {
        AVLNode<T> newNode = new AVLNode<>(temp.getData());

        newNode.setRight(temp.getRight());
        newNode.setLeft(temp.getLeft().getRight());
        temp.setRight(newNode);
        temp.setData(temp.getLeft().getData());
        temp.setLeft(temp.getLeft().getLeft());
        update(newNode);
        update(temp);
    }

    /**
     * Left rotate method.
     * @param temp node to rotate
     */
    private void leftRotate(AVLNode<T> temp) {
        AVLNode<T> newNode = new AVLNode<>(temp.getData());

        newNode.setLeft(temp.getLeft());
        newNode.setRight(temp.getRight().getLeft());
        temp.setLeft(newNode);
        temp.setData(temp.getRight().getData());
        temp.setRight(temp.getRight().getRight());
        update(newNode);
        update(temp);
    }

    /**
     * Method to update node height and bf.
     * @param node node to update.
     */
    private void update(AVLNode<T> node) {
        if (node == null) {
            return;
        }
        int lH = heightHelp(node.getLeft());
        int rH = heightHelp(node.getRight());
        node.setHeight(1 + Math.max(lH, rH));
        node.setBalanceFactor(lH - rH);

    }

    /**
     * Removes and returns the element from the tree matching the given
     * parameter.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the predecessor to
     * replace the data, NOT successor. As a reminder, rotations can occur
     * after removing the predecessor node.
     *
     * Remember to recalculate heights and balance factors while going back
     * up the tree after removing the element, making sure to rebalance if
     * necessary.
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * @param data the data to remove
     * @return the data that was removed
     * @throws java.lang.IllegalArgumentException if data is null
     * @throws java.util.NoSuchElementException   if the data is not found
     */
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot remove null data from tree.");
        }
        AVLNode<T> dummy = new AVLNode<>(null);
        root = recurseRemove(root, data, dummy);
        return dummy.getData();
    }

    /**
     * Recursive helper method of remove function.
     * @param node node to iterate using
     * @param data data to be removed
     * @param dummy dummy node to save data to be removed
     * @return AVL node
     */
    private AVLNode<T> recurseRemove(AVLNode<T> node, T data, AVLNode<T> dummy) {
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
                AVLNode<T> dummy2 = new AVLNode<>(null);
                node.setLeft(recPredecessor(node.getLeft(), dummy2));
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
        balance(node);
        return node;
    }

    /**
     * Helper method that removes using predecessor in two child case.
     * @param node node to iterate using
     * @param dummy2 dummy node to save data to be removed
     * @return return AVL node
     */
    private AVLNode<T> recPredecessor(AVLNode<T> node, AVLNode<T> dummy2) {
        if (node.getRight() == null) {
            dummy2.setData(node.getData());
            node = node.getLeft();
        } else {
            node.setRight(recPredecessor(node.getRight(), dummy2));
            balance(node);
        }
        return node;
    }

    /**
     * Returns the element from the tree matching the given parameter.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * @param data the data to search for in the tree
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
     * Recursive helper method for get function.
     * @param data data to get
     * @param node node to iterate using
     * @return data
     */
    private T recurseGet(T data, AVLNode<T> node) {
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
     * Hint: Should you use value equality or reference equality?
     *
     * @param data the data to search for in the tree.
     * @return true if the parameter is contained within the tree, false
     * otherwise
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public boolean contains(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Input data is null");
        }
        return recurseContains(data, root);
    }

    /**
     * Recursive helper method for contains function.
     * @param data data to check for
     * @param node node to iterate using
     * @return True if tree contains data or else false
     */
    private boolean recurseContains(T data, AVLNode<T> node) {
        if (node == null) {
            return false;
        }
        int value = data.compareTo(node.getData());
        if (data.equals(node.getData())) {
            return true;
        } else if (value < 0) {
            return recurseContains(data, node.getLeft());
        } else if (value > 0) {
            return recurseContains(data, node.getRight());
        }
        return false;
    }
    /**
     * Returns the height of the root of the tree.
     *
     * Should be O(1).
     *
     * @return the height of the root of the tree, -1 if the tree is empty
     */
    public int height() {
        return heightHelp(root);
    }

    /**
     * Helper method for getting height of node.
     * @param curr node to get height of
     * @return int height
     */
    private int heightHelp(AVLNode<T> curr) {
        int val = curr == null ? -1 : curr.getHeight();
        return val;
    }

    /**
     * Clears the tree.
     *
     * Clears all data and resets the size.
     */
    public void clear() {
        size = 0;
        root = null;
    }

    /**
     * Returns the data on branches of the tree with the maximum depth. If you
     * encounter multiple branches of maximum depth while traversing, then you
     * should list the remaining data from the left branch first, then the
     * remaining data in the right branch. This is essentially a preorder
     * traversal of the tree, but only of the branches of maximum depth.
     *
     * This must be done recursively.
     *
     * Your list should not have duplicate data, and the data of a branch should be
     * listed in order going from the root to the leaf of that branch.
     *
     * Should run in worst case O(n), but you should not explore branches that
     * do not have maximum depth. You should also not need to traverse branches
     * more than once.
     *
     * Hint: How can you take advantage of the balancing information stored in
     * AVL nodes to discern deep branches?
     *
     * Example Tree:
     *                           10
     *                       /        \
     *                      5          15
     *                    /   \      /    \
     *                   2     7    13    20
     *                  / \   / \     \  / \
     *                 1   4 6   8   14 17  25
     *                /           \          \
     *               0             9         30
     *
     * Returns: [10, 5, 2, 1, 0, 7, 8, 9, 15, 20, 25, 30]
     *
     * @return the list of data in branches of maximum depth in preorder
     * traversal order
     */
    public List<T> deepestBranches() {
        List<T> nodeList = new ArrayList<>();
        deepBHelper(root, nodeList);
        return nodeList;
    }

    /**
     * Recursive helper method for deepest Branches function.
     * @param node node to iterate using
     * @param list list to add data of deepest branches
     */
    private void deepBHelper(AVLNode<T> node, List<T> list) {
        if (node == null) {
            //base case
            return;
        }
        list.add(node.getData());
        if (node.getBalanceFactor() == 0) {
            deepBHelper(node.getLeft(), list);
            deepBHelper(node.getRight(), list);
        } else if (node.getBalanceFactor() > 0) {
            deepBHelper(node.getLeft(), list);
        } else {
            deepBHelper(node.getRight(), list);
        }
    }

    /**
     * Returns a sorted list of data that are within the threshold bounds of
     * data1 and data2. That is, the data should be > data1 and < data2.
     *
     * This must be done recursively.
     *
     * Should run in worst case O(n), but this is heavily dependent on the
     * threshold data. You should not explore branches of the tree that do not
     * satisfy the threshold.
     *
     * Example Tree:
     *                           10
     *                       /        \
     *                      5          15
     *                    /   \      /    \
     *                   2     7    13    20
     *                  / \   / \     \  / \
     *                 1   4 6   8   14 17  25
     *                /           \          \
     *               0             9         30
     *
     * sortedInBetween(7, 14) returns [8, 9, 10, 13]
     * sortedInBetween(3, 8) returns [4, 5, 6, 7]
     * sortedInBetween(8, 8) returns []
     *
     * @param data1 the smaller data in the threshold
     * @param data2 the larger data in the threshold
     * @return a sorted list of data that is > data1 and < data2
     * @throws IllegalArgumentException if data1 or data2 are null
     * or if data1 > data2
     */
    public List<T> sortedInBetween(T data1, T data2) {
        if (data1 == null || data2 == null || data1.compareTo(data2) > 0) {
            throw new IllegalArgumentException("illegal input for data1 or data2");
        }
        List<T> values = new ArrayList<>();
        if (size == 0 || data1.compareTo(data2) == 0) {
            return values;
        }
        siBHelper(root, values, data1, data2);
        return values;
    }

    /**
     * Recursive helper method for sorted In  Between function.
     * @param node node to iterate using
     * @param list list to add data to
     * @param d1 data1
     * @param d2 data2
     */
    private void siBHelper(AVLNode<T> node, List<T> list, T d1, T d2) {
        if (node == null) {
            //base case
            return;
        }
        if (node.getData().compareTo(d1) > 0) {
            siBHelper(node.getLeft(), list, d1, d2);
        }
        if (node.getData().compareTo(d1) > 0 && node.getData().compareTo(d2) < 0) {
            list.add(node.getData());
        }
        if (node.getData().compareTo(d2) < 0) {
            siBHelper(node.getRight(), list, d1, d2);
        }

    }

    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the root of the tree
     */
    public AVLNode<T> getRoot() {
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