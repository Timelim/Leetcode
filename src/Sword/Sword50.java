package Sword;

import java.util.Arrays;

public class Sword50 {
    public char firstUniqChar(String s) {
        int num[]=new int[26];
        Arrays.fill(num,0);
        for(char ch : s.toCharArray()){
            num[ch-'a']+=1;
        }
        for(char ch : s.toCharArray()){
            if(num[ch-'a']==1)
                return ch;
        }
        return ' ';
    }
    public static void main(String[] args) {
        Sword50 s= new Sword50();
        System.out.println(s.firstUniqChar("leetcode"));
    }
}
