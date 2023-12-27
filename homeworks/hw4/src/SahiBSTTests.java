import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class SahiBSTTests {

    private static final int TIMEOUT = 200;
    private BST<Integer> tree;

    @Before
    public void setup() {
        tree = new BST<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertEquals(0, tree.size());
        assertNull(tree.getRoot());
    }

    @Test(timeout = TIMEOUT)
    public void testConstructor() {
        /*
              2
             /
            0
             \
              1
        */

        List<Integer> data = new ArrayList<>();
        data.add(2);
        data.add(0);
        data.add(1);
        tree = new BST<>(data);

        assertEquals(3, tree.size());

        assertEquals((Integer) 2, tree.getRoot().getData());
        assertEquals((Integer) 0, tree.getRoot().getLeft().getData());
        assertEquals((Integer) 1, tree.getRoot().getLeft().getRight()
                .getData());
    }

    //Add only root
    @Test(timeout = TIMEOUT)
    public void testAddRoot() {
        tree.add(10);
        assertEquals(1, tree.size());

        assertEquals((Integer) 10, tree.getRoot().getData());
        assertNull(tree.getRoot().getLeft());
        assertNull(tree.getRoot().getRight());

    }

    //duplicates
    @Test(timeout = TIMEOUT)
    public void testAddDuplicates() {
        tree.add(10);
        tree.add(4);
        tree.add(4);
        assertEquals(2, tree.size());

        assertEquals((Integer) 10, tree.getRoot().getData());
        assertEquals((Integer) 4, tree.getRoot().getLeft().getData());
    }

    //Add left child only
    @Test(timeout = TIMEOUT)
    public void testAddLeftChild() {
        tree.add(10);
        tree.add(4);
        assertEquals(2, tree.size());

        assertEquals((Integer) 10, tree.getRoot().getData());
        assertEquals((Integer) 4, tree.getRoot().getLeft().getData());

    }

    //Add right child only
    @Test(timeout = TIMEOUT)
    public void testAddRightChild() {
        tree.add(10);
        tree.add(16);
        assertEquals(2, tree.size());

        assertEquals((Integer) 10, tree.getRoot().getData());
        assertEquals((Integer) 16, tree.getRoot().getRight().getData());

    }

    //Add all on left of root
    @Test(timeout = TIMEOUT)
    public void testAddLeftOfRoot() {
        tree.add(10);
        tree.add(1);
        tree.add(4);
        tree.add(3);

        assertEquals(4, tree.size());

        BSTNode<Integer> root = tree.getRoot();
        BSTNode<Integer> nodeTwo = root.getLeft();
        BSTNode<Integer> nodeThree = nodeTwo.getRight();
        BSTNode<Integer> nodeFour = nodeThree.getLeft();

        assertEquals((Integer) 10, root.getData());
        assertEquals((Integer) 1, nodeTwo.getData());
        assertEquals((Integer) 4, nodeThree.getData());
        assertEquals((Integer) 3, nodeFour.getData());

    }

    //add all on right of root
    @Test(timeout = TIMEOUT)
    public void testAddRightOfRoot() {
        tree.add(10);
        tree.add(14);
        tree.add(12);
        tree.add(16);
        tree.add(19);

        assertEquals(5, tree.size());
    	
	    /*
	        10
	          \
	           14
	          /  \ 
	         12  16
	               \
	         	19
		*/

        BSTNode<Integer> root = tree.getRoot();
        BSTNode<Integer> nodeTwo = root.getRight();
        BSTNode<Integer> nodeThree = nodeTwo.getLeft();
        BSTNode<Integer> nodeFour = nodeTwo.getRight();
        BSTNode<Integer> nodeFive = nodeFour.getRight();

        assertEquals((Integer) 10, root.getData());
        assertEquals((Integer) 14, nodeTwo.getData());
        assertEquals((Integer) 12, nodeThree.getData());
        assertEquals((Integer) 16, nodeFour.getData());
        assertEquals((Integer) 19, nodeFive.getData());

    }

    //degenerate left
    @Test(timeout = TIMEOUT)
    public void testAddDegenerateLeft() {
        tree.add(10);
        tree.add(9);
        tree.add(8);
        tree.add(7);
        tree.add(6);

        assertEquals(5, tree.size());

        BSTNode<Integer> root = tree.getRoot();
        BSTNode<Integer> nodeTwo = root.getLeft();
        BSTNode<Integer> nodeThree = nodeTwo.getLeft();
        BSTNode<Integer> nodeFour = nodeThree.getLeft();
        BSTNode<Integer> nodeFive = nodeFour.getLeft();

        assertEquals((Integer) 10, root.getData());
        assertEquals((Integer) 9, nodeTwo.getData());
        assertEquals((Integer) 8, nodeThree.getData());
        assertEquals((Integer) 7, nodeFour.getData());
        assertEquals((Integer) 6, nodeFive.getData());

    }

    //degenerate right 
    @Test(timeout = TIMEOUT)
    public void testAddDegenerateRight() {
        tree.add(10);
        tree.add(11);
        tree.add(12);
        tree.add(13);
        tree.add(14);

        assertEquals(5, tree.size());

        BSTNode<Integer> root = tree.getRoot();
        BSTNode<Integer> nodeTwo = root.getRight();
        BSTNode<Integer> nodeThree = nodeTwo.getRight();
        BSTNode<Integer> nodeFour = nodeThree.getRight();
        BSTNode<Integer> nodeFive = nodeFour.getRight();

        assertEquals((Integer) 10, root.getData());
        assertEquals((Integer) 11, nodeTwo.getData());
        assertEquals((Integer) 12, nodeThree.getData());
        assertEquals((Integer) 13, nodeFour.getData());
        assertEquals((Integer) 14, nodeFive.getData());

    }

    //add unordered
    @Test(timeout = TIMEOUT)
    public void testAddUnordered() {
        Integer[] elements = {4, 6, 2, 3, 8, 15, 1};

        for (Integer i : elements) {
            tree.add(i);
        }
    	
    	/*
		         4
		       /   \
		     2      6
		    / \      \ 
		   1   3      8
		                \
		         	  15
    	 */

        assertEquals(7, tree.size());

        BSTNode<Integer> root = tree.getRoot();
        BSTNode<Integer> nodeTwo = root.getLeft();
        BSTNode<Integer> nodeThree = nodeTwo.getLeft();
        BSTNode<Integer> nodeFour = nodeTwo.getRight();

        BSTNode<Integer> nodeFive = root.getRight();
        BSTNode<Integer> nodeSix = nodeFive.getRight();
        BSTNode<Integer> nodeSeven = nodeSix.getRight();

        assertEquals((Integer) 4, root.getData());
        assertEquals((Integer) 2, nodeTwo.getData());
        assertEquals((Integer) 1, nodeThree.getData());
        assertEquals((Integer) 3, nodeFour.getData());

        assertEquals((Integer) 6, nodeFive.getData());
        assertEquals((Integer) 8, nodeSix.getData());
        assertEquals((Integer) 15, nodeSeven.getData());

    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromTreeWithOneNode() {
        tree.add(10);

        assertEquals(1, tree.size());

        assertSame(10, tree.remove(10));

        assertEquals(0, tree.size());

        assertNull(tree.getRoot());

    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAllLeftNodes() {
        Integer[] elements = {4, 6, 2, 3, 8, 15, 1};

        for (Integer i : elements) {
            tree.add(i);
        }
    	
    	 /*
		         4
		       /   \
		     2      6
		    / \      \ 
		   1   3      8
		                \
		         	  15
    	 */

        assertEquals(7, tree.size());

        assertSame(2, tree.remove(2));
        assertEquals(6, tree.size());
    	
		 /*
		        4
		      /   \
		    3      6
		   /        \ 
		  1          8
		              \
		               15
		*/

        BSTNode<Integer> root = tree.getRoot();
        BSTNode<Integer> nodeTwo = root.getLeft();
        BSTNode<Integer> nodeThree = nodeTwo.getLeft();
        BSTNode<Integer> nodeFour = root.getRight();
        BSTNode<Integer> nodeFive = nodeFour.getRight();
        BSTNode<Integer> nodeSix = nodeFive.getRight();

        assertEquals((Integer) 4, root.getData());
        assertEquals((Integer) 3, nodeTwo.getData());
        assertEquals((Integer) 1, nodeThree.getData());
        assertEquals((Integer) 6, nodeFour.getData());
        assertEquals((Integer) 8, nodeFive.getData());
        assertEquals((Integer) 15, nodeSix.getData());

        assertSame(1, tree.remove(1));
        assertEquals(5, tree.size());
    	
    	/*
		        4
  	              /   \
		     3     6
		            \ 
		             8
		              \
		               15
		*/

        root = tree.getRoot();
        nodeTwo = root.getLeft();
        nodeThree = root.getRight();
        nodeFour = nodeThree.getRight();
        nodeFive = nodeFour.getRight();

        assertEquals((Integer) 4, root.getData());
        assertEquals((Integer) 3, nodeTwo.getData());
        assertEquals((Integer) 6, nodeThree.getData());
        assertEquals((Integer) 8, nodeFour.getData());
        assertEquals((Integer) 15, nodeFive.getData());
    	
	    /*
	        4
		 \   
	          6
	            \ 
	             8
	              \
	               15
	    */

        assertSame(3, tree.remove(3));
        assertEquals(4, tree.size());

        root = tree.getRoot();
        nodeTwo = root.getRight();
        nodeThree = nodeTwo.getRight();
        nodeFour = nodeThree.getRight();

        assertEquals((Integer) 4, root.getData());
        assertEquals((Integer) 6, nodeTwo.getData());
        assertEquals((Integer) 8, nodeThree.getData());
        assertEquals((Integer) 15, nodeFour.getData());


        assertSame(8, tree.remove(8));
        assertEquals(3, tree.size());
    	
	    /*
	        4
		 \   
	          6
	            \ 
	             15
	    */

        root = tree.getRoot();
        nodeTwo = root.getRight();
        nodeThree = nodeTwo.getRight();

        assertEquals((Integer) 4, root.getData());
        assertEquals((Integer) 6, nodeTwo.getData());
        assertEquals((Integer) 15, nodeThree.getData());


    }

    @Test(timeout = TIMEOUT)
    public void testRemoveLeaves() {
        Integer[] elements = {4, 6, 2, 3, 8, 15, 1};

        for (Integer i : elements) {
            tree.add(i);
        }
    	
    	/*
		        4
		      /   \
		    2      6
		   / \      \ 
		  1   3      8
		               \
		        	 15
       */

        assertEquals(7, tree.size());
        assertSame(1, tree.remove(1));
        assertSame(3, tree.remove(3));
        assertSame(15, tree.remove(15));
    	
    	/*
		        4
		      /   \
		    2      6
		            \ 
		             8
		        	   
		        	   
	    */
        assertEquals(4, tree.size());

        BSTNode<Integer> root = tree.getRoot();
        BSTNode<Integer> nodeTwo = root.getLeft();
        BSTNode<Integer> nodeThree = root.getRight();
        BSTNode<Integer> nodeFour = nodeThree.getRight();

        assertEquals((Integer) 4, root.getData());
        assertEquals((Integer) 2, nodeTwo.getData());
        assertEquals((Integer) 6, nodeThree.getData());
        assertEquals((Integer) 8, nodeFour.getData());

    }

    @Test(timeout = TIMEOUT)
    public void testRemoveRootWithMultipleNodes() {
        tree.add(7);
        tree.add(9);
        tree.add(8);
        tree.add(1);
        tree.add(0);
    	
    	/*
    	    7
    	   / \	
    	  1   9
    	 /   /
    	0   8
    	 
    	*/

        assertEquals(5, tree.size());

        BSTNode<Integer> root = tree.getRoot();
        BSTNode<Integer> nodeTwo = root.getLeft();
        BSTNode<Integer> nodeThree = nodeTwo.getLeft();
        BSTNode<Integer> nodeFour = root.getRight();
        BSTNode<Integer> nodeFive = nodeFour.getLeft();

        assertEquals((Integer) 7, root.getData());
        assertEquals((Integer) 1, nodeTwo.getData());
        assertEquals((Integer) 0, nodeThree.getData());
        assertEquals((Integer) 9, nodeFour.getData());
        assertEquals((Integer) 8, nodeFive.getData());

        assertSame(7, tree.remove(7));
        assertEquals(4, tree.size());

        root = tree.getRoot();
        nodeTwo = root.getLeft();
        nodeThree = nodeTwo.getLeft();
        nodeFour = root.getRight();

        assertEquals((Integer) 8, root.getData());
        assertEquals((Integer) 1, nodeTwo.getData());
        assertEquals((Integer) 0, nodeThree.getData());
        assertEquals((Integer) 9, nodeFour.getData());

    }

    @Test(timeout = TIMEOUT)
    public void testRemoveWhenLeftSideEmpty() {
        tree.add(7);
        tree.add(9);
        tree.add(8);
        tree.add(11);
        tree.add(10);
    	
	    /*
		    7
		     \	
		      9
		     / \
		    8  11
		      /
		     10
		*/

        assertEquals(5, tree.size());

        BSTNode<Integer> root = tree.getRoot();
        BSTNode<Integer> nodeTwo = root.getRight();
        BSTNode<Integer> nodeThree = nodeTwo.getLeft();
        BSTNode<Integer> nodeFour = nodeTwo.getRight();
        BSTNode<Integer> nodeFive = nodeFour.getLeft();

        assertEquals((Integer) 7, root.getData());
        assertEquals((Integer) 9, nodeTwo.getData());
        assertEquals((Integer) 8, nodeThree.getData());
        assertEquals((Integer) 11, nodeFour.getData());
        assertEquals((Integer) 10, nodeFive.getData());

        assertSame(11, tree.remove(11));
        assertEquals(4, tree.size());
    	
    	/*
		    7
		     \	
		      9
		     / \
		    8  10
		 	   
		 	 
	   */

        root = tree.getRoot();
        nodeTwo = root.getRight();
        nodeThree = nodeTwo.getLeft();
        nodeFour = nodeTwo.getRight();

        assertEquals((Integer) 7, root.getData());
        assertEquals((Integer) 9, nodeTwo.getData());
        assertEquals((Integer) 8, nodeThree.getData());
        assertEquals((Integer) 10, nodeFour.getData());

        assertSame(9, tree.remove(9));
        assertEquals(3, tree.size());

        root = tree.getRoot();
        nodeTwo = root.getRight();
        nodeThree = nodeTwo.getLeft();

        assertEquals((Integer) 7, root.getData());
        assertEquals((Integer) 10, nodeTwo.getData());
        assertEquals((Integer) 8, nodeThree.getData());

        assertSame(10, tree.remove(10));
        assertEquals(2, tree.size());
    	
    	/*
	 	7
	     	 \	
	          8
 	
    	 */

        root = tree.getRoot();
        nodeTwo = root.getRight();

        assertEquals((Integer) 7, root.getData());
        assertEquals((Integer) 8, nodeTwo.getData());

        assertSame(7, tree.remove(7));
        assertEquals(1, tree.size());
    	
    	/*
	
	          8
 	
    	 */

        root = tree.getRoot();
        assertEquals((Integer) 8, root.getData());

    }

    @Test(timeout = TIMEOUT)
    public void testRemoveWhenRightSideEmpty() {
        tree.add(12);
        tree.add(4);
        tree.add(8);
        tree.add(7);
        tree.add(3);
        tree.add(6);

        assertEquals(6, tree.size());
    	
    	/*
		        12
		      /    
		     4      
		   /  \
		  3     8
		       /
		      7
		     /
		    6
       */

        assertSame(6, tree.remove(6));
        assertEquals(5, tree.size());
    	
		/*
		        12
		      /    
		     4      
		   /  \
		  3     8
		       /
		      7
		       
		
		*/

        BSTNode<Integer> root = tree.getRoot();
        BSTNode<Integer> nodeTwo = root.getLeft();
        BSTNode<Integer> nodeThree = nodeTwo.getLeft();
        BSTNode<Integer> nodeFour = nodeTwo.getRight();
        BSTNode<Integer> nodeFive = nodeFour.getLeft();

        assertEquals((Integer) 12, root.getData());
        assertEquals((Integer) 4, nodeTwo.getData());
        assertEquals((Integer) 3, nodeThree.getData());
        assertEquals((Integer) 8, nodeFour.getData());
        assertEquals((Integer) 7, nodeFive.getData());


        assertSame(4, tree.remove(4));
        assertEquals(4, tree.size());
    	
		/*
		        12
		      /    
		     7      
		   /  \
		  3     8            
		
		*/

        root = tree.getRoot();
        nodeTwo = root.getLeft();
        nodeThree = nodeTwo.getLeft();
        nodeFour = nodeTwo.getRight();

        assertEquals((Integer) 12, root.getData());
        assertEquals((Integer) 7, nodeTwo.getData());
        assertEquals((Integer) 3, nodeThree.getData());
        assertEquals((Integer) 8, nodeFour.getData());

        assertSame(12, tree.remove(12));
        assertEquals(3, tree.size());
    	
		/*
		               
		     7      
		   /  \
		  3     8            
		
		*/

        root = tree.getRoot();
        nodeTwo = root.getLeft();
        nodeThree = root.getRight();

        assertEquals((Integer) 7, root.getData());
        assertEquals((Integer) 3, nodeTwo.getData());
        assertEquals((Integer) 8, nodeThree.getData());

    }

    @Test(timeout = TIMEOUT)
    public void testAddRemoveKLargestMix() {
        tree.add(78);
        tree.add(72);
        tree.add(75);
        tree.add(67);
        tree.add(120);
        tree.add(87);
        tree.add(32);
        tree.add(178);
        tree.add(185);
        tree.add(80);

        assertEquals(10, tree.size());
    	
    	/* 
	    	     78
	    	   /    \	
	    	 72     120
	    	/  \    /  \
	       67  75  87  178
	      /       /      \
	     32      80      185
  
      */

        BSTNode<Integer> root = tree.getRoot();
        BSTNode<Integer> nodeTwo = root.getLeft();
        BSTNode<Integer> nodeThree = nodeTwo.getLeft();
        BSTNode<Integer> nodeFour = nodeTwo.getRight();
        BSTNode<Integer> nodeFive = nodeThree.getLeft();
        BSTNode<Integer> nodeSix = root.getRight();
        BSTNode<Integer> nodeSeven = nodeSix.getLeft();
        BSTNode<Integer> nodeEight = nodeSix.getRight();
        BSTNode<Integer> nodeNine = nodeSeven.getLeft();
        BSTNode<Integer> nodeTen = nodeEight.getRight();

        assertEquals((Integer) 78, root.getData());
        assertEquals((Integer) 72, nodeTwo.getData());
        assertEquals((Integer) 67, nodeThree.getData());
        assertEquals((Integer) 75, nodeFour.getData());
        assertEquals((Integer) 32, nodeFive.getData());
        assertEquals((Integer) 120, nodeSix.getData());
        assertEquals((Integer) 87, nodeSeven.getData());
        assertEquals((Integer) 178, nodeEight.getData());
        assertEquals((Integer) 80, nodeNine.getData());
        assertEquals((Integer) 185, nodeTen.getData());

        assertEquals(tree.inorder(), tree.kLargest(10));

        List<Integer> expected = new ArrayList<>();
        expected.add(185);
        assertEquals(expected, tree.kLargest(1));

        expected.remove(0);
        expected.add(87);
        expected.add(120);
        expected.add(178);
        expected.add(185);
        assertEquals(expected, tree.kLargest(4));


        assertSame(120, tree.remove(120));
        assertEquals(9, tree.size());
        
        /* 
			 78
		       /    \	
		      72     178
		     /  \    /  \
		    67  75  87  185
		   /       /      
		 32      80      
	
	   */

        root = tree.getRoot();
        nodeTwo = root.getLeft();
        nodeThree = nodeTwo.getLeft();
        nodeFour = nodeTwo.getRight();
        nodeFive = nodeThree.getLeft();
        nodeSix = root.getRight();
        nodeSeven = nodeSix.getLeft();
        nodeEight = nodeSix.getRight();
        nodeNine = nodeSeven.getLeft();

        assertEquals((Integer) 78, root.getData());
        assertEquals((Integer) 72, nodeTwo.getData());
        assertEquals((Integer) 67, nodeThree.getData());
        assertEquals((Integer) 75, nodeFour.getData());
        assertEquals((Integer) 32, nodeFive.getData());
        assertEquals((Integer) 178, nodeSix.getData());
        assertEquals((Integer) 87, nodeSeven.getData());
        assertEquals((Integer) 185, nodeEight.getData());
        assertEquals((Integer) 80, nodeNine.getData());

        assertEquals(tree.inorder(), tree.kLargest(9));

        List<Integer> expected2 = new ArrayList<>();
        expected2.add(185);
        assertEquals(expected2, tree.kLargest(1));

        expected2.remove(0);
        expected2.add(87);
        expected2.add(178);
        expected2.add(185);
        assertEquals(expected2, tree.kLargest(3));

        assertSame(78, tree.remove(78));
        assertEquals(8, tree.size());
        
        /* 
			     80
			   /    \	
			 72     178
			/  \    /  \
		      67  75  87  185
		     /             
		   32            
	
	   */

        root = tree.getRoot();
        nodeTwo = root.getLeft();
        nodeThree = nodeTwo.getLeft();
        nodeFour = nodeTwo.getRight();
        nodeFive = nodeThree.getLeft();
        nodeSix = root.getRight();
        nodeSeven = nodeSix.getLeft();
        nodeEight = nodeSix.getRight();

        assertEquals((Integer) 80, root.getData());
        assertEquals((Integer) 72, nodeTwo.getData());
        assertEquals((Integer) 67, nodeThree.getData());
        assertEquals((Integer) 75, nodeFour.getData());
        assertEquals((Integer) 32, nodeFive.getData());
        assertEquals((Integer) 178, nodeSix.getData());
        assertEquals((Integer) 87, nodeSeven.getData());
        assertEquals((Integer) 185, nodeEight.getData());

        assertEquals(tree.inorder(), tree.kLargest(8));

        List<Integer> expected3 = new ArrayList<>();
        expected3.add(185);
        assertEquals(expected3, tree.kLargest(1));

        expected3.remove(0);
        expected3.add(75);
        expected3.add(80);
        expected3.add(87);
        expected3.add(178);
        expected3.add(185);
        assertEquals(expected3, tree.kLargest(5));
    }

    @Test(timeout = TIMEOUT)
    public void testKLargestNoElementsEmptyTree() {
        assertEquals(0, tree.size());
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, tree.kLargest(0));
    }

    @Test(timeout = TIMEOUT)
    public void testKLargestOneElementsNoRetrievalTree() {
        tree.add(0);
        assertEquals(1, tree.size());
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, tree.kLargest(0));
    }

    @Test(timeout = TIMEOUT)
    public void testKLargestOneElementsOneRetrievalTree() {
        tree.add(0);
        assertEquals(1, tree.size());
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        assertEquals(expected, tree.kLargest(1));
    }

    @Test(timeout = TIMEOUT)
    public void testKLargestTwoElementsOneRetrievalTree() {
        tree.add(0);
        tree.add(-1);
        assertEquals(2, tree.size());
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        assertEquals(expected, tree.kLargest(1));
    }

    @Test(timeout = TIMEOUT)
    public void testKLargestTwoElementsTwoRetrievalTree() {
        tree.add(0);
        tree.add(-1);
        assertEquals(2, tree.size());
        List<Integer> expected = new ArrayList<>();
        expected.add(-1);
        expected.add(0);
        assertEquals(expected, tree.kLargest(2));
    }

    @Test(timeout = TIMEOUT)
    public void testKLargestAll() {
        tree.add(50);
        tree.add(25);
        tree.add(75);
        tree.add(12);
        tree.add(37);
        tree.add(10);
        tree.add(15);
        tree.add(40);
        tree.add(13);
        assertEquals(9, tree.size());
        assertEquals(tree.inorder(), tree.kLargest(9));
    }

    @Test(timeout = TIMEOUT)
    public void testKLargestAddRemove() {
        tree.add(50);
        tree.add(25);
        tree.add(75);
        tree.add(12);
        tree.add(37);
        tree.add(10);
        tree.add(15);
        tree.add(40);
        tree.add(13);

        tree.remove(37);
        tree.remove(50);
        tree.add(22);
        
		/*
		        75
		      /    
		    25      
		   /  \
		  12   40
		 /  \    
		10  15    
		   /  \
		  13  22
		*/

        assertEquals(8, tree.size());

        List<Integer> expected = new ArrayList<>();
        expected.add(15);
        expected.add(22);
        expected.add(25);
        expected.add(40);
        expected.add(75);

        assertEquals(expected, tree.kLargest(5));
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testConstructorNullList() {
        List<Integer> data = null;
        tree = new BST<>(data);

    }
    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testConsutructorNullData() {
        List<Integer> data = new ArrayList<>();
        data.add(2);
        data.add(null);
        data.add(1);
        tree = new BST<>(data);
    }
    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testRemoveNullData() {
        tree.add(5);
        tree.remove(null);
    }
    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveElementNotFound() {
        tree.add(5);
        tree.add(7);
        tree.add(-1);
        tree.remove(-2);
    }
    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testKLargestInvalidSize() {
        tree.add(12);
        tree.add(45);
        tree.add(0);
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, tree.kLargest(4));
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testKLargestInvalidSizeNegative() {
        tree.add(12);
        tree.add(45);
        tree.add(0);
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, tree.kLargest(-90));
    }
}