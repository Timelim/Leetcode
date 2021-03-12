package SortAlgorithm;

public class MergeSort {
    public void merge(int arr[], int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int tmp[] = new int[arr.length];
        int index = 0;
        while (i <= mid && j <= high) {
            if (arr[i] > arr[j]) {
                tmp[index++] = arr[j++];

            } else {
                tmp[index++] = arr[i++];
            }
        }
        while (i <= mid) {
            tmp[index++] = arr[i++];
        }
        while (j <= high) {
            tmp[index++] = arr[j++];
        }
        index = 0;
        while (low <= high) {
            arr[low++] = tmp[index++];
        }
    }

    public void mergeSort(int arr[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 234, 56, 86, 34, 54, 867, 34, 34, 75, 93, 7867, 9, 9};
        MergeSort m = new MergeSort();
        m.mergeSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);

    }
}
