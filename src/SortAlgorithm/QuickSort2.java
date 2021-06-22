package SortAlgorithm;

import java.util.Stack;

//非递归
public class QuickSort2 {
    public int quickSort(int array[], int low, int high) {
        int key = array[low];
        int l = low, r = high;
        while (l < r) {
            while (array[r] >= key && r > l) r--;
            while (array[l] <= key && l < r) l++;
            if (l < r) {
                int tmp = array[l];
                array[l] = array[r];
                array[r] = tmp;
            }
        }
        array[low] = array[l];
        array[l] = key;
        return l;
    }

    public void sort(int array[], int low, int high) {
        if (low < high) {
            int mid = quickSort(array, low, high);
            sort(array, low, mid - 1);
            sort(array, mid + 1, high);
        }
    }

    public void sortWithStack(int array[], int low, int high) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{low, high});
        while (!stack.empty()) {
            int tmp[] = stack.pop();
            if (tmp[0] < tmp[1]) {
                int mid = quickSort(array, tmp[0], tmp[1]);
                stack.push(new int[]{tmp[0], mid - 1});
                stack.push(new int[]{mid + 1, tmp[1]});
            }
        }
    }

    public void printData(int data[]) {
        for (int i : data) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = {113, 5353, 213, 654, 876, 3, 34, 65, 213, 54, 82, 653, 24};
        QuickSort2 t = new QuickSort2();
        t.sortWithStack(a, 0, a.length - 1);
        t.printData(a);
    }
}
