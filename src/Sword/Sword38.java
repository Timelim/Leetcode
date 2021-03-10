package Sword;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Sword38 {
    List<String> res=new ArrayList<>();
    char tmp[];
    public String[] permutation(String s) {
        tmp=s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    public void dfs(int index){
       if(index==tmp.length-1) {
           res.add(String.valueOf(tmp));
           return;
       }
       HashSet<Character> hashset=new HashSet<>();
       for(int i=index;i<tmp.length;i++){
           if(hashset.contains(tmp[i])) continue;
           hashset.add(tmp[i]);
           char swap=tmp[i];
           tmp[i]=tmp[index];
           tmp[index]=swap;
           dfs(index+1);
           swap=tmp[i];
           tmp[i]=tmp[index];
           tmp[index]=swap;
       }
    }
}
/*
输入一个字符串，打印出该字符串中字符的所有排列。
你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
示例:
输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */