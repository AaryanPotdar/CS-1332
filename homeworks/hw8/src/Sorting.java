import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Your implementation of various sorting algorithms.
 *
 * @author YOUR NAME HERE
 * @version 1.0
 * @userid YOUR USER ID HERE (i.e. gburdell3)
 * @GTID YOUR GT ID HERE (i.e. 900000000)
 *
 * Collaborators: LIST ALL COLLABORATORS YOU WORKED WITH HERE
 *
 * Resources: LIST ALL NON-COURSE RESOURCES YOU CONSULTED HERE
 */
public class Sorting {

    /**
     * Implement selection sort.
     *
     * It should be:
     * in-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n^2)
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("the input array or comparator is null");
        }
        for  (int i = arr.length - 1; i > 0; i--) {
            int maxIdx = i;
            for (int j = 0; j < i; j++) {
                if (comparator.compare(arr[j], arr[maxIdx]) > 0) {
                    maxIdx = j;
                }
            }
            swap(arr, maxIdx, i);
        }
    }

    /**
     * Private swap helper method.
     * @param arr input array
     * @param idx1 index 1
     * @param idx2 index 2
     * @param <T> data type
     */
    private static <T> void swap(T[] arr, int idx1, int idx2) {
        T data = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = data;
    }
    /**
     * Implement cocktail sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n)
     *
     * NOTE: See pdf for last swapped optimization for cocktail sort. You
     * MUST implement cocktail sort with this optimization
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void cocktailSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("the input array or comparator is null");
        }
        boolean swapMade = true;
        int startIdx = 0;
        int endIdx = arr.length - 1;
        int lastSwapped = 0;
        while (swapMade) {
            swapMade = false;
            for (int i = lastSwapped; i < endIdx; i++) {
                if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                    swapMade = true;
                    swap(arr, i, i + 1);
                    lastSwapped = i;
                }
            }
            endIdx = lastSwapped;
            if (swapMade) {
                swapMade = false;
                for (int i = lastSwapped; i > startIdx; i--) {
                    if (comparator.compare(arr[i - 1], arr[i]) > 0) {
                        swapMade = true;
                        swap(arr, i - 1, i);
                        lastSwapped = i;
                    }
                }
            }
            startIdx = lastSwapped;
        }
    }

    /**
     * Implement merge sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of:
     * O(n log n)
     *
     * And a best case running time of:
     * O(n log n)
     *
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     *
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     *
     * Hint: If two data are equal when merging, think about which subarray
     * you should pull from first
     *
     * @param <T>        data type to sort
     * @param arr        the array to be sorted
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("the input array or comparator is null");
        }
        merge(arr, comparator);
    }

    /**
     * Private helper method for merge function.
     * @param arr input array
     * @param comparator Comparator object
     * @param <T> data type
     */
    private static <T> void merge(T[] arr, Comparator<T> comparator) {
        if (arr.length == 1) {
            return;
        }
        int length = arr.length;
        int midIndex = length / 2;
        T[] left = (T[]) new Object[midIndex];
        for (int i = 0; i < midIndex; i++) {
            left[i] = arr[i];
        }
        T[] right = (T[]) new Object[length - midIndex];
        for (int i = 0; i < (length - midIndex); i++) {
            right[i] = arr[i + midIndex];
        }
        merge(left, comparator);
        merge(right, comparator);
        int i = 0;
        int j = 0;
        while (i < left.length && j < right.length) {
            if (comparator.compare(left[i], right[j]) <= 0) {
                arr[i + j] = left[i];
                i++;
            } else {
                arr[i + j] = right[j];
                j++;
            }
        }
        while (i < left.length) {
            arr[i + j] = left[i];
            i++;
        }
        while (j < right.length) {
            arr[i + j] = right[j];
            j++;
        }
    }

    /**
     * Implement kth select.
     *
     * Use the provided random object to select your pivots. For example if you
     * need a pivot between a (inclusive) and b (exclusive) where b > a, use
     * the following code:
     *
     * int pivotIndex = rand.nextInt(b - a) + a;
     *
     * If your recursion uses an inclusive b instead of an exclusive one,
     * the formula changes by adding 1 to the nextInt() call:
     *
     * int pivotIndex = rand.nextInt(b - a + 1) + a;
     *
     * It should be:
     * in-place
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n)
     *
     * You may assume that the array doesn't contain any null elements.
     *
     * Make sure you code the algorithm as you have been taught it in class.
     * There are several versions of this algorithm and you may not get full
     * credit if you do not implement the one we have taught you!
     *
     * @param <T>        data type to sort
     * @param k          the index to retrieve data from + 1 (due to
     *                   0-indexing) if the array was sorted; the 'k' in "kth
     *                   select"; e.g. if k == 1, return the smallest element
     *                   in the array
     * @param arr        the array that should be modified after the method
     *                   is finished executing as needed
     * @param comparator the Comparator used to compare the data in arr
     * @param rand       the Random object used to select pivots
     * @return the kth smallest element
     * @throws java.lang.IllegalArgumentException if the array or comparator
     *                                            or rand is null or k is not
     *                                            in the range of 1 to arr
     *                                            .length
     */
    public static <T> T kthSelect(int k, T[] arr, Comparator<T> comparator,
                                  Random rand) {
        if (arr == null || comparator == null || rand == null || k < 1 || k > arr.length) {
            throw new IllegalArgumentException("invalid input parameters");
        }
        return kthSelectHelp(arr, 0, arr.length - 1, k, rand, comparator);
    }

    /**
     * Recursive helper method for kthSelect method.
     * @param arr original array to be sorted
     * @param left start index
     * @param right end index
     * @param k pivot index
     * @param rand Random class object
     * @param comparator Comparator object
     * @return return array element
     * @param <T> data type
     */
    private static <T> T kthSelectHelp(T[] arr, int left, int right, int k, Random rand, Comparator<T> comparator) {
        int pivot = left + rand.nextInt(right - left + 1);
        T pivotVal = arr[pivot];
        arr[pivot] = arr[left];
        arr[left] = pivotVal;

        int i = left + 1;
        int j = right;

        while (i <= j) { // i and j not crossed
            while (i <= j && comparator.compare(arr[i], pivotVal) <= 0) {
                i++;
            }
            while (i <= j && comparator.compare(arr[j], pivotVal) >= 0) {
                j--;
            }
            if (j > i) { // strict
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        swap(arr, left, j); //pivot swap
        if (j == k - 1) {
            return arr[j];
        }
        if (j > k - 1) {
            return kthSelectHelp(arr, left, j - 1, k, rand, comparator);
        } else {
            return kthSelectHelp(arr, j + 1, right, k, rand, comparator);
        }
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * Make sure you code the algorithm as you have been taught it in class.
     * There are several versions of this algorithm and you may not get full
     * credit if you do not implement the one we have taught you!
     *
     * Remember you CANNOT convert the ints to strings at any point in your
     * code! Doing so may result in a 0 for the implementation.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of:
     * O(kn)
     *
     * And a best case running time of:
     * O(kn)
     *
     * You are allowed to make an initial O(n) passthrough of the array to
     * determine the number of iterations you need. The number of iterations
     * can be determined using the number with the largest magnitude.
     *
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     *
     * Refer to the PDF for more information on LSD Radix Sort.
     *
     * You may use ArrayList or LinkedList if you wish, but it may only be
     * used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with other sorts. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     *
     * Do NOT use anything from the Math class except Math.abs().
     *
     * @param arr the array to be sorted
     * @throws java.lang.IllegalArgumentException if the array is null
     */
    public static void lsdRadixSort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("input array is null");
        }

        ArrayList<Integer>[] buckets =  new ArrayList[19];
        for (int i = 0; i < 19; i++) {
            buckets[i] = new ArrayList<>();
        }

        int base = 10;
        int pos = 1;
        boolean maxDigitNotReached = true;

        while (maxDigitNotReached) {
            maxDigitNotReached = false;
            for (int n : arr) {
                int bucketPos = n / pos;
                if (bucketPos / 10 != 0) {
                    maxDigitNotReached = true;
                }
                if (buckets[bucketPos % base + 9] == null) {
                    buckets[bucketPos % base + 9] = new ArrayList<Integer>();
                }
                buckets[bucketPos % base + 9].add(n);
            }
            int idx = 0;
            for (ArrayList<Integer> bucket : buckets) {
                if (bucket != null) {
                    for (int num : bucket) {
                        arr[idx++] = num;
                    }
                    bucket.clear();
                }
            }
            pos *= 10;
        }
    }

    /**
     * Implement heap sort.
     *
     * It should be:
     * out-of-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of:
     * O(n log n)
     *
     * And a best case running time of:
     * O(n log n)
     *
     * Use java.util.PriorityQueue as the heap. Note that in this
     * PriorityQueue implementation, elements are removed from smallest
     * element to largest element.
     *
     * Initialize the PriorityQueue using its build heap constructor (look at
     * the different constructors of java.util.PriorityQueue).
     *
     * Return an int array with a capacity equal to the size of the list. The
     * returned array should have the elements in the list in sorted order.
     *
     * @param data the data to sort
     * @return the array with length equal to the size of the input list that
     * holds the elements from the list is sorted order
     * @throws java.lang.IllegalArgumentException if the data is null
     */
    public static int[] heapSort(List<Integer> data) {
        if (data == null) {
            throw new IllegalArgumentException("data is null");
        }
        int[] list = new int[data.size()];
        PriorityQueue<Integer> val = new PriorityQueue<>(data);
        for (int i = 0; i < data.size(); i++) {
            list[i] = val.poll();
        }
        return list;
    }
}