package ks;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ks6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str=scanner.nextLine();
            str=str.substring(1, str.length()-1);
            str=str.replace('"', ' ');
            str=str.replace(',', ' ');
            str=str.replace("   ", " ");
            String []tmp=str.split(" ");

//            Arrays.sort(tmp,(e1,e2) -> e2.length() - e1.length());
            int res=0;
            for(int i=0;i<tmp.length;i++){
                for(int j=i+1;j<tmp.length;j++)
                {
                    char sum[]=(tmp[i]+tmp[j]).toCharArray();
                    Set tmp_set=new HashSet();
                    for(char ch :sum){
                        tmp_set.add(ch);
                    }
                    if (tmp_set.size()==sum.length){
                        res=Math.max(tmp[i].length()*tmp[j].length(),res);
                    }
                }

            }
            System.out.println(res);
        }
    }
}
/*
已知一个字符串数组words，要求寻找其中两个没有重复字符的字符串，使得这两个字符串的长度乘积最大，输出这个最大的乘积。如：
words=["abcd","wxyh","defgh"], 其中不包含重复字符的两个字符串是"abcd"和"wxyh"，则输出16
words=["a","aa","aaa","aaaa"], 找不到满足要求的两个字符串，则输出0
输入描述:
Input:

["a","ab","abc","cd","bcd","abcd"]
输出描述:
Output:
4
示例1
输入
["a","ab","abc","cd","bcd","abcd"]
输出
4
备注:
Input中，不包含相同字符的有三对：
"ab"和"cd"
"a"和"cd"
"a"和"bcd"
所以字符串长度乘积的最大值是4
 */