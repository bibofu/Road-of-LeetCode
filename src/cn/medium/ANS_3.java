package cn.medium;

/**
 * @author fubibo
 * @create 2020-11-18 19:09
 */

import java.util.Arrays;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 **最长子串** 的长度。
 */
public class ANS_3 {
    public static void main(String[] args) {
        String test="abcabcbb";
        System.out.println(lengthOfLongestSubstring(test));

    }

    public static int lengthOfLongestSubstring(String s){
        int[] freq=new int[256];
        Arrays.fill(freq,0);
        int l=0,r=-1;
        int res=0;
        while(l<s.length()){
            if((r+1)<s.length()&&freq[s.charAt(r+1)]==0){
                r++;
                freq[s.charAt(r)]++;

            }else{
                freq[s.charAt(l)]--;
                l++;
            }
//            res=max(res,r-l+1);
            res= Math.max(res, r - l + 1);
        }
        return res;
    }
}
