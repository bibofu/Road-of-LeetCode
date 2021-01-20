package cn.easy;

/**
 * @author fubibo
 * @create 2020-11-11 19:11
 */

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 */
public class ANS_242 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {
        if ((s == null) || (t == null) || (t.length() != s.length())) {
            return false;
        }
        char[] sArr1 = s.toCharArray();
        char[] sArr2 = t.toCharArray();
        Arrays.sort(sArr1);
        Arrays.sort(sArr2);
        return Arrays.equals(sArr1, sArr2);
    }
}
