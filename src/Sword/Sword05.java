package Sword;

public class Sword05 {
    public String replaceSpace(String s) {
        StringBuilder stringBuilder=new StringBuilder();
        for(char i:s.toCharArray()){
            if(i==' '){
                stringBuilder.append("%20");
            }
            else stringBuilder.append(i);
        }
        return String.valueOf(stringBuilder);
    }
}
