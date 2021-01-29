package UnionSet;

public class QuickUnionUF {
    public int []id;
    public QuickUnionUF(int N){
        id= new int[N];
        for(int i=0;i<N;i++)
            id[i]=i;
    }

    /**
     *  找到i的根节点
     * @param i
     * @return
     */
    public int root(int i){
        while(i!=id[i]){
            i=id[i];
        }
        return i;
    }

    /**
     * 判断p和q是否是连接的
     * @param p
     * @param q
     * @return
     */
    public boolean connerted(int p,int q){
        return root(p)==root(q);
    }

    /**
     *  合并p和q
     *  将p的根节点设为q的根节点(p=>q p的根节点指向q)。
     * @param p
     * @param q
     */
    public void union(int p,int q){
        int qroot=root(q);
        int proot=root(p);
        id[proot]=qroot;
    }
}
