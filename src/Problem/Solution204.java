package Problem;

public class Solution204 {
    boolean[] num = new boolean[5000001];
    public void prime(){
        for(int i=0;i<5000001;i++) {
            num[i]=true;
        }
        num[0]=false;
        num[1]=false;
        for(int i=2;i*i<5000001;i++){
            if(num[i]==true){
                for(int j=i*i;j<5000001;j+=i) {
                    num[j]=false;
                }
            }
        }
    }
    public int countPrimes(int n) {
        int res = 0;
        prime();
        for(int i=0;i<n;i++)
        {
            if (num[i]==true) {
                System.out.println(i);
                res+=1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution204 t = new Solution204();
        t.countPrimes(10);
    }
}
