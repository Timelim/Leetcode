package Question;

public class StrAndChar {
    public String testStr="123qwe";
    public char[] testCh=new char[]{'1','2','v'};
    public void test(String str,char []ch){
        str="abcwe";
        ch[0]='a';
        ch[1]='b';
    }
    public static void main(String[] args) {
        StrAndChar s=new StrAndChar();
        System.out.println(s.testStr);;
        System.out.println(s.testCh);
        s.test(s.testStr,s.testCh);
        System.out.println(s.testStr);;
        System.out.println(s.testCh);
    }
    //testCh  yin yong chuan di
    /*
    123qwe
    12v
    123qwe
    abv
     */
}
