import java.util.*;
public class SubSetsOfSet {
    public static void main(String[] args){


            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the number of elements in the set: ");
            Integer n = scanner.nextInt();
            // Create a HashSet to store the elements of the set to make sure they are uniqe
            Set<Integer> set = new HashSet<>();
            //  Ask user to enter the elements of the set
            System.out.println("Enter the elements of the set:");
            // Read the elements of the set from the user and add them to the HashSet
            for (int i = 0; i < n; i++) {
                set.add(scanner.nextInt());
            }

            // Generate the power set of the input set
            List<List<Integer>> subsets = generateSubSetsofSet(set);

            // Print the generated Sub Sets of  set
            System.out.println("SubSets of  set: " + subsets);

            scanner.close();

    }
    public static List<List<Integer>> generateSubSetsofSet(Set<Integer> set){
        // Initialize a list to store the subsets
        List<List<Integer>> result = new ArrayList<>();
        // Convert the set to a list to access elements by index
        List<Integer> nums = new ArrayList<>(set);
        // Calculate the size of the set
        Integer n = nums.size();
        // Calculate the total number of subsets using the formula 2^n
        Integer totalSubsets = (int) Math.pow(2, n); // 2^n

        // Iterate through all possible subsets
        for (int i = 0; i < totalSubsets; i++) {
            // Initialize a list to store the current subset
            List<Integer> subset = new ArrayList<>();
            // Iterate through each element of the set
            for (int j = 0; j < n; j++) {
                // Check if the j-th bit of the current subset number is set
                if ((i & (1 << j)) != 0) {
                    // If set, add the corresponding element to the subset
                    subset.add(nums.get(j));
                }
            }
            // Add the current subset to the result list
            result.add(subset);
        }
        System.out.println("Total Number of Subsets is "+totalSubsets);
        // Return the list of subsets
        return result;
    }
}
