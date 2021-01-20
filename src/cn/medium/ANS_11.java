package cn.medium;

/**
 * @author fubibo
 * @create 2020-11-09 17:19
 */

/**
 * 给你n个非负整数a1，a2，...，an，每个数代表坐标中的一个点(i,ai)。在坐标内画n条垂直线，
 * 垂直线i的两个端点分别为(i,ai)和(i,0)。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且n的值至少为2。
 * 示例：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class ANS_11 {
    public static void main(String[] args) {

        int[] test={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(test));

    }
    public static int maxArea(int[] height){
        int left=0;
        int right=height.length-1;
        int res=0;
        while (left<right){
            if (height[left]>=height[right]){
                res=Math.max(res,(right-left)*height[right]);
                right--;
            }else {
                res=Math.max(res,(left-right)*height[left]);
                left++;
            }

        }
        return res;
    }
}
