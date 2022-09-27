package main.algorithms;

import java.util.Arrays;

public class Sort
{

    public static void insertion(int[] input)
    {
        // Iterate through the list starting with the second element
        for (int i = 1; i < input.length; i++)
        {
            // Key is the number we want to find a location for
            int key = input[i];

            // This is the location we are moving the key to
            int j = i - 1;

            // Move backwards through the list as long as the key is still smaller
            // This is the sorting part, we are looking for the correct place to insert key
            while (j >= 0 && input[j] > key)
            {
                // Shift elements forward in the list to make space, and decrement J to move backwards
                input[j + 1] = input[j];
                j = j - 1;
            }

            // After the loop we should know where the key should be inserted, so do the actual insertion
            input[j + 1] = key;
        }
    }

    public static void insertion(double[] input)
    {
        // Iterate through the list starting with the second element
        for (int i = 1; i < input.length; i++)
        {
            // Key is the number we want to find a location for
            double key = input[i];

            // This is the location we are moving the key to
            int j = i - 1;

            // Move backwards through the list as long as the key is still smaller
            // This is the sorting part, we are looking for the correct place to insert key
            while (j >= 0 && input[j] > key)
            {
                // Shift elements forward in the list to make space, and decrement J to move backwards
                input[j + 1] = input[j];
                j = j - 1;
            }

            // After the loop we should know where the key should be inserted, so do the actual insertion
            input[j + 1] = key;
        }
    }

    public static <T> void insertion(Comparable<T>[] input)
    {
        for (int i = 1; i < input.length; i++)
        {
            Comparable<T> key = input[i];
            int j = i - 1;

            while ((j >= 0) && (input[j].compareTo((T) key) > 0))
            {
                input[j + 1] = input[j];
                j = j - 1;
            }

            input[j + 1] = key;
        }
    }

    public static <T> void bubble(Comparable<T>[] input)
    {
        for (int i = 0; i < input.length; i++)
        {
            for (int j = input.length-1; j > i; j--)
            {
                if (input[j].compareTo((T) input[j-1]) < 0)
                {
                    Comparable<T> temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
    }

    // TODO: Implement merge sort with comparable interface
    public static void merge(Integer[] input)
    {
        mergeSort(input, 0, input.length-1);
    }

    private static void mergeSort(Integer[] input, int start, int end)
    {
        if (start >= end)
            return;

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid+1, end);

        mergeSeg(input, start, mid, end);
    }
    private static void mergeSeg(Integer[] input, int left, int mid, int right)
    {
        // Create two new arrays that are each about half the input array
        Integer[] leftArr = new Integer[mid - left + 1];
        Integer[] rightArr = new Integer[right - mid];

        // Copy the left and right of the input array into the newly created leftArr and rightArr
        System.arraycopy(input, left, leftArr, 0, leftArr.length);
        System.arraycopy(input, mid+1, rightArr, 0, rightArr.length);

        // Create some counters to track as we re-merge into original array
        int smallestLeft = 0;
        int smallestRight = 0;
        int fillLocation = left;

        while (smallestLeft < leftArr.length && smallestRight < rightArr.length)
        {
            // If the smallest element in the left array is less or equal to smallest from right array
            if (leftArr[smallestLeft] <= rightArr[smallestRight])
            {
                    input[fillLocation] = leftArr[smallestLeft];
                    smallestLeft++;
            }
            else
            {
                input[fillLocation] = rightArr[smallestRight];
                smallestRight++;
            }
            fillLocation++;
        }

        // Now that we've emptied one list, copy whatever list is remaining (Since that should all be sorted)
        while (smallestLeft < leftArr.length) { input[fillLocation] = leftArr[smallestLeft]; smallestLeft++; fillLocation++; }
        while (smallestRight < rightArr.length) { input[fillLocation] = rightArr[smallestRight]; smallestRight++; fillLocation++; }
    }

    //////////////////// HEAP-SORT

    public static void heap(Integer[] input)
    {
        buildMaxHeap(input);
        for (int i = input.length-1; i >= 2; i--)
        {
            int temp = input[1];
            input[1] = input[i];
            input[i] = temp;



        }
    }

    private static int parent(int i)
    {
        return i/2;
    }

    private static int left(int i)
    {
        return i*2;
    }

    private static int right(int i)
    {
        return i*2 + 1;
    }

    private static void maxHeapify(Integer[] arr, int i)
    {
        int l = left(i);
        int r = right(i);
        int largest = 0;
        if (l < arr.length && arr[l] > arr[i])
        {
            largest = l;
        }
        else
        {
            largest = i;
        }

        if (r < arr.length && arr[r] > arr[largest])
        {
            largest = r;
        }
        if (largest != i)
        {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, largest);
        }
    }

    private static void buildMaxHeap(Integer[] arr)
    {
        for (int i = arr.length/2; i >= 0; i--)
        {
            maxHeapify(arr, i);
        }
    }
}
