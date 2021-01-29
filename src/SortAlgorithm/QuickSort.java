package SortAlgorithm;

public class QuickSort {
    public int partition(int data[],int low,int high){
        int index=low;
        int key=data[index];
        while(low!=high){
            //先从high开始，避免出现最后所得的data[low]比data[index]大，导致排序出现问题
            while(data[high]>=key&&low<high)
                high--;
            while(data[low]<=key &&low<high)
                low++;
            if(low<high){
                int tmp=data[low];
                data[low]=data[high];
                data[high]=tmp;
            }
        }
        data[index]=data[low];
        data[low]=key;
        return low;
    }
    public void quickSort(int data[],int low,int high){
        if(low<high){
            int mid=partition(data,low,high);
            for(int i:data){
                System.out.printf("%d ",i);
            }
            System.out.println();
            quickSort(data,low,mid-1);
            quickSort(data,mid+1,high);
        }
    }
    public void printData(int data[]){
        for(int i:data){
            System.out.printf("%d ",i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a[]={113,5353,213,654,876,3,34,65,213,54,82,653,24};
        QuickSort t=new QuickSort();
        t.quickSort(a,0,a.length-1);
        t.printData(a);
    }
}
