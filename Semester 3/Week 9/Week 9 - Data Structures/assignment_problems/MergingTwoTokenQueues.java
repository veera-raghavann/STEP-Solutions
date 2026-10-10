import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergingTwoTokenQueues {

    public static List<Integer> mergeTokens(List<Integer> counterA,
                                            List<Integer> counterB) {
        List<Integer> merged = new ArrayList<>(
            counterA.size() + counterB.size()
        );

        int first = 0;
        int second = 0;

        while (first < counterA.size() && second < counterB.size()) {
            if (counterA.get(first) <= counterB.get(second)) {
                merged.add(counterA.get(first));
                first++;
            } else {
                merged.add(counterB.get(second));
                second++;
            }
        }

        while (first < counterA.size()) {
            merged.add(counterA.get(first));
            first++;
        }

        while (second < counterB.size()) {
            merged.add(counterB.get(second));
            second++;
        }

        return merged;
    }

    public static void main(String[] args) {
        List<Integer> counterA = Arrays.asList(3, 8, 15, 20);
        List<Integer> counterB = Arrays.asList(5, 8, 12);

        System.out.println(mergeTokens(counterA, counterB));
        System.out.println(mergeTokens(
            new ArrayList<>(), Arrays.asList(4, 9)
        ));
    }
}

// Time: O(m + n); additional space: O(m + n) for the merged result.
// Joining and sorting would take O((m + n) log(m + n)) time.
