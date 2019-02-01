import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortingClass {

    /**
     * in the worse case, the swap times will be super big
     * <p>
     * Complexity:
     * The complexity of bubble sort is  in both worst and average cases,
     * because the entire array needs to be iterated for every element.
     */
    public void bubbleSort(int[] nums) {
        Util util = Util.getInstance();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] >= nums[j + 1]) {
                    util.swap(nums, j, j + 1);
                }
            }
        }
    }

    /**
     * this algorithm means to find the min value in range 0 ~ n - 1
     * 1 ~ n - 1
     * 2 ~ n - 1
     * ...
     * <p>
     * Time Complexity:
     * <p>
     * To find the minimum element from the array of  elements,  comparisons are required.
     * After putting the minimum element in its proper position,
     * the size of an unsorted array reduces to  and then  comparisons are required to find the minimum in the unsorted array.
     * <p>
     * Therefore  +  +  +  =  comparisons and  swaps result in the overall complexity of .
     */
    public void selectSort(int[] nums) {
        Util util = Util.getInstance();
        int min;
        for (int i = 0; i < nums.length; i++) {
            min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    min = j;
                }
            }
            if (min != i)
                util.swap(nums, min, i);
        }
    }


    /**
     * check whether the adjacent element in left side is greater or less than the current element
     * <p>
     * Time Complexity:
     * <p>
     * In worst case,each element is compared with all the other elements in the sorted array.
     * For  elements, there will be  comparisons. Therefore, the time complexity is
     */

    public void insertSort(int[] nums) {
        Util util = Util.getInstance();

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && temp < nums[j - 1]) {
                //nums[j] = nums[j - 1];
                util.swap(nums, j, j - 1);
                j = j - 1;
            }
            nums[j] = temp;
        }

    }


    /**
     * we need a function to get the pivit
     * <p>
     * <p>
     * Complexity The worst case time complexity of this algorithm is  , but as this is randomized algorithm,
     * its time complexity fluctuates between  and  and mostly it comes out to be
     */
    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int piv = quickSortPartition(nums, start, end);
            quickSort(nums, start, piv - 1);
            quickSort(nums, piv + 1, end);
        }
    }

    private int quickSortPartition(int[] nums, int start, int end) {
        Util util = Util.getInstance();
        int res = start + 1;
        int piv = nums[start];

        for (int j = start + 1; j <= end; j++) {
            if (nums[j] < piv) {
                util.swap(nums, j, res);
                res++;
            }
        }

        if (start != res - 1) util.swap(nums, start, res - 1);//!!
        return res - 1;
    }

//    public void quickSort2(int[] nums) {
//        quickSort2(nums, 0, nums.length - 1);
//    }
//    public void quickSort2(int[] nums, int start, int end) {
//        if (start < end) {
//            int piv = quickSortRandPartition(nums, start, end);
//            quickSort2(nums, start, piv - 1);
//            quickSort2(nums, piv + 1, end);
//        }
//    }
//
//    private int quickSortRandPartition(int A[], int start, int end) {
//        //chooses position of pivot randomly by using rand() function .
//        Random r = new Random();
//        Util util = Util.getInstance();
//        int random = start + r.nextInt(end - start);
//        util.swap(A, A[random], A[start]);        //swap pivot with 1st element.
//        return quickSortRandPartition(A, start, end);       //call the above partition function
//    }


    /**
     * merge sort
     * we need a merge function
     * <p>
     * <p>
     * Time Complexity:
     * The list of size  is divided into a max of  parts,
     * and the merging of all sublists into a single list takes  time, the worst case run time of this algorithm is
     */

    public void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);

    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }

    }

    private void merge(int[] A, int start, int mid, int end) {
        int p = start, q = mid + 1;

        int[] Arr = new int[end - start + 1];
        int k = 0;

        for (int i = start; i <= end; i++) {
            if (p > mid)      //checks if first part comes to an end or not .
                Arr[k++] = A[q++];

            else if (q > end)   //checks if second part comes to an end or not
                Arr[k++] = A[p++];

            else if (A[p] < A[q])     //checks which part has smaller element.
                Arr[k++] = A[p++];

            else
                Arr[k++] = A[q++];
        }
        for (int p1 = 0; p1 < k; p1++) {

            /*
             *Now the real array has elements in sorted manner including both
             * parts.
             * */
            A[start++] = Arr[p1];
        }
    }

    /**
     * this sorting has some special limitation :
     * <p>
     * the item shound be in the range 0 ~ n
     * <p>
     * <p>
     * Time Complexity:
     * <p>
     * If one assumes that insertion in a bucket takes  time,
     * then steps 1 and 2 of the above algorithm clearly take  time.
     */
    public void bucket(int[] nums) {
        Util util = Util.getInstance();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] <= nums.length && nums[i] - 1 != i) {
                util.swap(nums, i, nums[i] - 1);
            }
        }
    }


    /**
     * counting sort
     * <p>
     * put every element in the a extra array, at the index it should be if the size of extra array equals to the range of the element
     * <p>
     * Time Complexity:
     * The array  is traversed in  time and the resulting sorted array is also computed in  time.
     * is traversed in  time. Therefore, the overall time complexity of counting sort algorithm is .
     */

    public void countinnSort(int nums[]) {
        int max = Integer.MIN_VALUE;
        //int[] backup = nums;
        //for(int i : backup ) System.out.println(i);

        //O(n)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        // System.out.println("max = " + max);
        int[] extra = new int[max];

        for (int i = 0; i < nums.length; i++) {
            extra[nums[i] - 1]++;
        }

        //for (int i  : extra) System.out.println(i);
        int start = 0;
        for (int i = 0; i < extra.length; i++) {
            if (extra[i] != 0) {
                for (int j = 0; j < extra[i]; j++) {
                    nums[start] = i + 1;
                    //System.out.println(nums[start]);
                    start++;
                }

            }
        }
        //for (int i : backup) System.out.println(i);
    }


    /**
     * QuickSort, MergeSort, HeapSort are comparison based sorting algorithms.
     * <p>
     * CountSort is not comparison based algorithm. It has the complexity of ,
     * where  is the maximum element of the input array.
     * So, if  is  ,CountSort becomes linear sorting, which is better than comparison based
     * sorting algorithms that have  time complexity. The idea is to extend the CountSort algorithm
     * to get a better time complexity when k goes . Here comes the idea of Radix Sort.
     */

    public void radixSort(int nums[]) {

        final int RADIX = 10; //0 ~ 9
        //declare and initialize bucket[]
        List<Integer>[] bucket = new ArrayList[RADIX];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        //step 1 : put all the item into list
        int digits = 1;
        int tep = -1;
        boolean getMaxDigit = false;

        /**
         *
         *  0
         *  1
         *  2
         *  3
         *  4
         *  5
         *  6
         *  7
         *  8
         *  9
         *
         * */

        while (!getMaxDigit) {
            //System.out.println("while lop");
            //for (int i : nums) System.out.println(i);
            getMaxDigit = true;
            for (int i : nums) {
                tep = i / digits;//when we meet any item has more digits, we have to keep sorting
                int index = tep % RADIX;
                //System.out.println(index);
                bucket[index].add(i);
                //System.out.println(digits);
                //System.out.println(tep);
                if (tep > 0 && getMaxDigit) {
                    getMaxDigit = false;
                }
            }
            //for(List i : bucket) System.out.println(i);
            //step 2 : put list into array

            int start = 0;
            for (int i = 0; i < RADIX; i++) {
                for (Integer i1 : bucket[i]) {
                    nums[start] = i1;
                    start++;
                }
            }

            //for (int i : nums) System.out.println(i);
            for (int i = 0; i < RADIX; i++) bucket[i].clear();

            digits *= RADIX;
        }
    }


    /**
     * heap sort, put all the elements into tree(array)
     * the root is the biggest element (a[0])
     * <p>
     * Complexity:
     * max_heapify has complexity , build_maxheap has complexity  and we run max_heapify
     * times in heap_sort function, therefore complexity of heap_sort function is .
     */
    public void heapSort(int arr[]) {
        int n = arr.length;

        // Build heap (rearrange array)
        /**
         *
         *  for creating the heap, we start to build thet tree from the middle of the array
         *  no matter the length of this array is even or odd, we will consider the left and right child both,
         *  therefore, it doesn't matter
         *
         * */
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);


        /**
         * we just create a heap, but, we haven't sorted them well
         * */

        //for (int i : arr) System.out.println(i);

        /**
         *
         * keep doing, on every node
         *
         * */
        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i) {
        int largest = i;  // Initialize largest as root
        int l = 2 * i + 1;  // left = 2*i + 1
        int r = 2 * i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        SortingClass s = new SortingClass();
        int[] input_worst = new int[]{34, 1, 7, 6, 8, 4, 2, 1};
        int[] input_best = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        /**
         * bubble sort
         * */
        Util.resetCount();
        int[] input_test = input_worst;
        s.bubbleSort(input_test);
        for (int i : input_test) System.out.print(i + " ");
        System.out.println("");

        /**
         * select sort
         * */
        input_worst = new int[]{34, 1, 7, 6, 8, 4, 2, 1};
        Util.resetCount();
        input_test = input_worst;
        s.selectSort(input_test);
        for (int i : input_test) System.out.print(i + " ");
        System.out.println("");

        /**
         * insert sort
         * */
        input_worst = new int[]{34, 1, 7, 6, 8, 4, 2, 1};
        Util.resetCount();
        input_test = input_worst;
        s.insertSort(input_test);
        for (int i : input_test) System.out.print(i + " ");
        System.out.println("");

        /**
         * quick sort
         * */
        input_worst = new int[]{34, 1, 7, 6, 8, 4, 2, 1};
        Util.resetCount();
        input_test = input_worst;
        s.quickSort(input_test);
        for (int i : input_test) System.out.print(i + " ");
        System.out.println("");

        /**
         * merget sort
         * */
        input_worst = new int[]{34, 1, 7, 6, 8, 4, 2, 1};
        Util.resetCount();
        input_test = input_worst;
        s.mergeSort(input_test);
        for (int i : input_test) System.out.print(i + " ");
        System.out.println("");


        /**
         * bucket sort
         *
         *
         * */
        input_worst = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        Util.resetCount();
        input_test = input_worst;
        s.bucket(input_test);
        for (int i : input_test) System.out.print(i + " ");
        System.out.println("");


        /**
         * count sort
         * */
        input_worst = new int[]{34, 1, 7, 6, 8, 4, 2, 1};
        Util.resetCount();
        input_test = input_worst;
        s.countinnSort(input_test);
        for (int i : input_test) System.out.print(i + " ");
        System.out.println("");
        //System.out.println(Util.getCount());

        /**
         * radix sort
         * */
        input_worst = new int[]{34, 1, 7, 6, 8, 4, 2, 1};
        Util.resetCount();
        input_test = input_worst;
        s.radixSort(input_test);
        for (int i : input_test) System.out.print(i + " ");
        System.out.println("");


        /**
         * heap sort
         * */
        input_worst = new int[]{34, 1, 7, 6, 8, 4, 2, 1};
        Util.resetCount();
        input_test = input_worst;
        s.heapSort(input_test);
        for (int i : input_test) System.out.print(i + " ");
        System.out.println("");

    }

}

