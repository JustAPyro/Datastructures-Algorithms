package main.algorithms;

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

}
