import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
    public static List<Integer> selectionSort(List<Integer> array) {
        var sortedArray = new ArrayList<>(List.copyOf(array));
        var lastSortedIndex = -1;
        for (int j = 0; j < sortedArray.size() - 1; j++) {
            var minValue = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = lastSortedIndex + 1; i < sortedArray.size(); i++) {
                if (sortedArray.get(i) < minValue) {
                    minValue = sortedArray.get(i);
                    minIndex = i;
                }
            }
            sortedArray.set(minIndex, sortedArray.get(lastSortedIndex + 1));
            sortedArray.set(lastSortedIndex + 1, minValue);
            lastSortedIndex++;
        }

        return sortedArray;
    }
}
