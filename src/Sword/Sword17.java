package Sword;

public class Sword17 {
    public int[] printNumbers(int n) {
        if(n==0)
            return new int[0];
        int res[]=new int[(int) Math.pow(10,n)];
        for(int i=0;i<res.length-1;i++)
            res[i]=i+1;
        return res;
    }
}
