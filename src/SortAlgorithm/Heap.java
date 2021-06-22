package SortAlgorithm;

public class Heap {
    //大顶堆
    public void adjustHeap(int data[], int parent, int size) {
        int tmp = data[parent];
        int child = parent * 2 + 1;
        while (child < size) {
            if (child + 1 < size && data[child + 1] > data[child])
                child += 1;
            if (data[parent] >= data[child])
                break;

            data[parent] = data[child];
            data[child] = tmp;
            parent = child;
            child = parent * 2 + 1;

        }
    }

    public void createHeap(int data[]) {
        for (int i = data.length / 2 - 1; i >= 0; i--)
            adjustHeap(data, i, data.length);
    }

    public void HeapSort(int data[]) {
        createHeap(data);
        for (int i = data.length - 1; i >= 0; i--) {
            int tmp = data[i];
            data[i] = data[0];
            data[0] = tmp;
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
        Heap heap = new Heap();
        heap.HeapSort(array);
        for (int i : array) {
            System.out.printf("%d ", i);
        }
        System.out.println();

    }
}
