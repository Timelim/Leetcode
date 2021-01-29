package UnionSet;

public class RankUnionSet {
    public int[] id;
    public int[] rank;
    public RankUnionSet(int N) {
        id=new int[N];
        rank=new int[N];
        for(int i=0;i<N;i++){
            id[i]=i;
            rank[i]=0;
        }
    }
    public int root(int i){
        while(i!=id[i]){
            i=id[i];
        }
        return id[i];
    }

    /**
     * 合并两棵树的时候，为了保证树的深度差较小，设立rank表示树的深度。
     * @param p
     * @param q
     */
    public void union(int p,int q){
        int proot=root(p);
        int qroot=root(q);
        if(rank[proot]>rank[qroot]){
            id[qroot]=proot;
            rank[q]+=1;
        }
        else{
            id[proot]=qroot;
            if(rank[proot]==rank[qroot])
                rank[qroot]+=1;
        }
    }
}
