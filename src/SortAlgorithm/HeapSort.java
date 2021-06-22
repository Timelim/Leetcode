package SortAlgorithm;

public class HeapSort {
    public void adjustHeap(int data[], int parent, int size) {
        int tmp = data[parent];
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && data[child + 1] > data[child])
                child += 1;
            if (data[parent] >= data[child])
                break;
            data[parent] = data[child];
            parent = child;
            data[child]=tmp;
            child = 2 * child + 1;
        }
        //data[parent] = tmp;
    }

    public void heapSort(int data[]) {
        for (int i = data.length / 2; i >= 0; i--)
            adjustHeap(data, i, data.length);
        for (int i = data.length - 1; i > 0; i--) {
            int tmp = data[0];
            data[0] = data[i];
            data[i] = tmp;
            adjustHeap(data, 0, i);
            System.out.println(data.length-i);
            for (int k : data) {
                System.out.printf("%d ", k);
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        int[] array = {
                1, 3, 4, 5, 2, 6, 9, 7, 8, 0
        };
        HeapSort heap = new HeapSort();
        heap.heapSort(array);
        for (int i : array) {
            System.out.printf("%d ", i);
        }
        System.out.println();

    }
}
