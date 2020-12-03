package Problem;

public class Solution5 {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }
        char[] tmp = s.toCharArray();
        int[] len = new int[tmp.length];
        for(int i=0;i<tmp.length;i++) {
            int low = i-1;
            int high =i+1;
            int l=1;
            while(low>=0&&high<tmp.length)
            {
                if(tmp[low]==tmp[high]) {
                    l+=2;
                }
                else{
                    break;
                }
                low-=1;
                high+=1;
            }
            len[i]=l;
        }

        int[] len2 = new int[tmp.length];
        for(int i=0;i<tmp.length;i++) {
            int low = i;
            int high =i+1;
            int l=0;
            while(low>=0&&high<tmp.length)
            {
                if(tmp[low]==tmp[high]) {
                    l+=2;
                }
                else{
                    break;
                }
                low-=1;
                high+=1;
            }
            len2[i]=l;
        }
        int max2=0;
        int maxi2=0;
        for(int i=0;i<tmp.length;i++){
            if(len2[i]>max2){
                max2=len2[i];
                maxi2=i;
            }
        }
        int max=1;
        int maxi=0;
        for(int i=0;i<tmp.length;i++){
            if(len[i]>max){
                max=len[i];
                maxi=i;
            }
        }
        System.out.println(max);
        System.out.println(max2);
        String res="";
        if(max>max2){
            for(int i=maxi-(max-1)/2;i<=maxi+(max-1)/2;i++){
                res+=tmp[i];
            }
        }
        else{
            for(int i=maxi2-max2/2+1;i<=maxi2+max2/2;i++) {
                res+=tmp[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution5 t =new Solution5();
        System.out.println(t.longestPalindrome("aacabdkacaa"));
    }
}
//5. 最长回文子串
//        给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
//        示例 1：
//
//        输入: "babad"
//        输出: "bab"
//        注意: "aba" 也是一个有效答案。
//        示例 2：
//
//        输入: "cbbd"
//        输出: "bb"