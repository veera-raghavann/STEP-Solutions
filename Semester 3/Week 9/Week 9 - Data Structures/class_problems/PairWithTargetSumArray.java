import java.util.HashSet;
import java.util.Set;

public class PairWithTargetSumArray {

    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> complements = new HashSet<>();

        for (int value : nums) {
            if (complements.contains(value)) {
                return true;
            }

            complements.add(target - value);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] first = {2, 7, 11, 15};
        int[] second = {3, 4, 6};

        System.out.println(hasPairWithSum(first, 9));
        System.out.println(hasPairWithSum(second, 20));
    }
}

// Time: average O(n); additional space: O(n).
