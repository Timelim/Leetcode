package Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jc
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        int len =strs.length;
        if(len==0)
            return res;
        if(len>0){
            boolean[] visit =new boolean[len];
            for(int i=0;i<len;i++) {
                visit[i]=false;
            }
            while(true){
                int index;
                for(index=0;index<len&&visit[index]==true;index++) ;
                if(index==len) break;
                List<String> item = new ArrayList<>();
                item.add(strs[index]);
                visit[index]=true;
                int cur[]=getCharArray(strs[index]);
                for(int i=index+1;i<len;i++){
                    if(visit[i]==false){
                        if(strs[index].length()!=strs[i].length())
                            continue;
                        int tmp[]=getCharArray(strs[i]);
                        if(Arrays.equals(cur, tmp)){
                            item.add(strs[i]);
                            visit[i]=true;
                        }
                    }
                }
                res.add(item);
            }
        }
        return res;
    }
    public int[] getCharArray(String s){
        int []res=new int[26];
        for(int i=0;i<26;i++) {
            res[i]=0;
        }
        int l=s.length();
        for(int i=0;i<l;i++){
            res[s.charAt(i)-'a']+=1;
        }
        return res;
    }

    public static void main(String[] args) {
        int a[]={1,2,3};
        int b[]={1,2,3};
        System.out.println(Arrays.equals(a, b));
    }
}
/*
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/group-anagrams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */