package SortAlgorithm;

import java.util.Scanner;

public class P1177 {
    public static void quickSort(int[] arr, int low, int high) {
        if(low>=high)
            return;
        int l = low, r = high;
        int num = arr[low];
        while (l < r) {
            while (r > l && arr[r] >= num) r--;
            while (l < r && arr[l] <= num) l++;
            int tmp = arr[r];
            arr[r] = arr[l];
            arr[l] = tmp;
        }
        arr[low]=arr[l];
        arr[l]=num;
        quickSort(arr, low, l - 1);
        quickSort(arr, l + 1, high);
    }


    public static void main(String[] args) {
        int N;
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            N = cin.nextInt();
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = cin.nextInt();
            }
            quickSort(arr, 0, N - 1);
            for (int i = 0; i < N; i++)
                System.out.printf("%d ", arr[i]);
        }
    }
}
