package Sword;

public class Sword11 {
    public int minArray1(int[] numbers) {
        return getMin(numbers, 0, numbers.length - 1);
    }

    public int getMin(int[] numbers, int l, int r) {
        //System.out.printf("%d,%d\n",l,r);
        if (l == r)
            return numbers[l];
        if (l + 1 == r) {
            return Math.min(numbers[l], numbers[r]);
        }
        int mid = (l + r) / 2;
        if (numbers[mid] > numbers[r])
            return getMin(numbers, mid, r);
        else if (numbers[l] > numbers[mid])
            return getMin(numbers, l, mid);
        else return Math.min(getMin(numbers, l, mid), getMin(numbers, mid, r));
    }

    public int minArray(int[] numbers) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int mid = ( high-low) / 2+low;
            if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            }
            else if (numbers[mid] < numbers[high]) {
                high = mid;
            } else {
                high = high - 1;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        Sword11 s = new Sword11();
        System.out.println(s.minArray(new int[]{3, 3,3,1}));
    }
}
