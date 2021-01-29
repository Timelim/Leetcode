package dp;

//01背包
public class Knapsack01 {
    /**
     *
     * @param capacity
     * @param weight
     * @param value
     * @return
     */
    //测试数据测试数据：
    //5 10
    //2 6
    //2 3
    //6 5
    //5 4
    //4 6
    //answer 15
    public int getMaxValue1(int capacity,int []weight,int []value){
        int N=weight.length;
        if(N==0)
            return 0;
        //i 表示前i件物品，j表示体积
        int dp[][]=new int[N][capacity+1];
        for(int i=0;i<=capacity;i++)
            dp[0][i]=0;
        for(int i=1;i<N;i++){
//            for(int j=capacity;j>0;j--){
            for(int j=0;j<=capacity;j++){
            if(j>=weight[i])
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
                else dp[i][j]=dp[i-1][j];
            }
        }
        int res=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<=capacity;j++)
            {
                if(dp[i][j]>res)
                    res=dp[i][j];
            }
        }
        return dp[N-1][capacity];
    }
    public int getMaxValue2(int capacity,int []weight,int []value){
        int N=weight.length;
        if(N==0)
            return 0;
        //i 表示前i件物品，j表示体积
        int dp[]=new int[capacity+1];
        dp[0]=0;
        for(int i=1;i<N;i++){
            for(int j=capacity;j>=0;j--){
                if(j>=weight[i])
                    dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        return dp[capacity];
    }
    public static void main(String[] args) {
        Knapsack01 k = new Knapsack01();
        System.out.println(k.getMaxValue2(10,new int[]{0,2,2,6,5,4},new int[]{0,6,3,5,4,6}));
    }
}
