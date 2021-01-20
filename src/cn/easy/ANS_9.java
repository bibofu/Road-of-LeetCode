package cn.easy;

/**
 * @author fubibo
 * @create 2020-11-09 23:53
 */

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class ANS_9 {
    public static void main(String[] args) {
        int test=1234321;
        System.out.println(isPalindrome(test));

    }
    public static boolean isPalindrome(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }
}
