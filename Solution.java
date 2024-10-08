// Ensure this is saved in a file named Solution.java
public class Solution {
    // Method to calculate minimum swaps required
    public int minSwaps(String s) {
        int imbalance = 0;  // Tracks the current imbalance (negative means more closing brackets)
        int maxImbalance = 0;  // Tracks the maximum imbalance encountered
        
        // Traverse the string
        for (char c : s.toCharArray()) {
            if (c == '[') {
                imbalance++;  // Opening bracket increases balance
            } else {
                imbalance--;  // Closing bracket decreases balance
            }
            // We track the maximum negative imbalance encountered
            maxImbalance = Math.min(maxImbalance, imbalance);
        }
        
        // The number of swaps needed is the ceiling of the maximum imbalance divided by 2
        // Since each swap can fix two unbalanced pairs (one open and one close).
        return (-maxImbalance + 1) / 2;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        String s1 = "][][";
        System.out.println(solution.minSwaps(s1));  // Output: 1
        
        String s2 = "]]][[[";
        System.out.println(solution.minSwaps(s2));  // Output: 2
        
        String s3 = "[]";
        System.out.println(solution.minSwaps(s3));  // Output: 0
    }
}
