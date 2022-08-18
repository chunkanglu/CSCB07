public class MergeSortingAdapter implements SortingService {
    public List<Double> sort(List<Double> L) {
        int size = L.size();
        double[] arr = L.toArray(new double[size]);
        MergeSort.sort(arr, 0, size-1);
        List<Double> ms = Arrays.asList(arr);
        return ms;

    }
}