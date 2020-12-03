package Problem;

public class Solution767 {
    public String reorganizeString(String S) {
        char tmp[] = S.toCharArray();
        int count[] = new int[26];
        for (int i = 0; i < 26; i++) {
            count[i] = 0;
        }
        for (char i : tmp) {
            count[i - 'a'] += 1;
        }
        int max1, max2, maxi1, maxi2;
        String res = "";
        for (int i = 0; i < 26; i++) {
            max1 = count[0];
            maxi1 = 0;
            for (int j = 0; j < 26; j++) {
                if (count[j] >= max1) {
                    max1 = count[j];
                    maxi1 = j;
                }
            }
            max2=0;
            maxi2=0;
            for (int j = 0; j < 26; j++) {
                if (count[j] >= max2 && j!=maxi1) {
                    max2 = count[j];
                    maxi2 = j;
                }
            }
//            System.out.println("maxi1:"+maxi1);
//            System.out.println("maxi2:"+max2);
            int zero_flag=0;
            for(int k=0;k<26;k++) {
                if(count[k]==0) {
                    zero_flag+=1;
                }
            }
//            System.out.println("zero:"+zero_flag);
            count[maxi1]=max1-max2;
            count[maxi2]=0;
            if(zero_flag==25){
                if(max1>1) {
                    return "";
                }
                for(int t=0;t<max1;t++) {
                    res+=((char)(maxi1+'a'));
                }
                count[maxi1]=0;
            }
            for(int k=0;k<max2;k++){
                res+=((char)(maxi1+'a'));
                res+=((char)(maxi2+'a'));
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        Solution767 t= new Solution767();
        t.reorganizeString("abaaa");
    }
}

/*
给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。

若可行，输出任意可行的结果。若不可行，返回空字符串。

示例 1:

输入: S = "aab"
输出: "aba"
示例 2:

输入: S = "aaab"
输出: ""
注意:

S 只包含小写字母并且长度在[1, 500]区间内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reorganize-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */