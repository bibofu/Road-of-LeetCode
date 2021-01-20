package cn.easy;

/**
 * @author fubibo
 * @create 2020-11-04 10:45
 */
public class ANS_58 {
    public static void main(String[] args) {
        String s1="fu bi bo and jiangkeyu ";
        System.out.println(LengthOfLastWord(s1));

    }
    public static int LengthOfLastWord(String s){
        int len=0;
        for (int i=s.length()-1;i>0;i--){
            if (s.charAt(i)!=' '){
                len++;
            }else if (len!=0){
                return len;
            }
        }
        return len;
    }
}
