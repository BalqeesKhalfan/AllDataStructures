import java.util.*;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of arrays (k): ");
        Integer k = scanner.nextInt();

        // Initialize a 2D array to store the input arrays
        Integer[][] arrays = new Integer[k][];
        // Loop to take input for each array
        for (Integer i = 0; i < k; i++) {
            System.out.print("Enter the size of array " + (i + 1) + ": ");
            Integer size = scanner.nextInt();
            // Initialize the current array with the specified size
            arrays[i] = new Integer[size];
            // Ask the user to enter elements of the current array in sorted order
            System.out.print("Enter elements of array " + (i + 1) + " in sorted order: ");
            // Loop to read elements of the current array from the user
            for (Integer j = 0; j < size; j++) {
                arrays[i][j] = scanner.nextInt();
            }
        }

        // Call the mergeKArrays method
        Integer[] mergedArray = mergeKArrays(arrays);
        // Print the merged array
        System.out.println("Merged Array: " + Arrays.toString(mergedArray));

        scanner.close();
    }


    // Method to merge k sorted arrays
    public static Integer[] mergeKArrays(Integer[][] arrays) {
        // Calculate the total number of elements across all arrays
        Integer totalLength = 0;
        for (Integer[] array : arrays) {
            totalLength += array.length;
        }

        // Initialize the merged array to store the merged result
        Integer [] mergedArray = new Integer[totalLength];

        // Initialize pointers to keep track of the current position in each array
        Integer[] pointers = new Integer[arrays.length];
        // Initialize each pointer to start at the beginning of its respective array
        Arrays.fill(pointers, 0);

        // Merge the arrays
        Integer index = 0; // Index to keep track of the current position in the merged array
        while (index < totalLength) {

            Integer min = Integer.MAX_VALUE; // Initialize the minimum value to the maximum possible integer value
            Integer minIndex = -1; // Initialize the index of the array containing the minimum element
            // Iterate through each array to find the minimum element
            for (Integer i = 0; i < arrays.length; i++) {
                // Check if the current pointer is within the bounds of the array
                if (pointers[i] < arrays[i].length && arrays[i][pointers[i]] < min) {
                    // If the current element is smaller than the current minimum, update the minimum value and index
                    min = arrays[i][pointers[i]];
                    minIndex = i;
                }
            }

            // Add the minimum element to the merged array
            mergedArray[index++] = min;

            // Move the pointer of the array from which the minimum element was picked to the next element
            pointers[minIndex]++;
        }

        // Return the merged array
        return mergedArray;
    }
}
