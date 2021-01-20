package cn.hard;

/**
 * @author fubibo
 * @create 2020-11-10 10:30
 */

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class ANS_42 {
    public static void main(String[] args) {

        int[] test={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(getWater(test));
        System.out.println(getWater2(test));

    }
    public static int getWater(int[] num){
        int sum=0;
        for (int i = 1; i <num.length; i++) {

            //找出左边最高
            int max_left=0;
            for(int j=i-1;j>0;j--){
                if (num[j]>max_left){
                    max_left=num[j];
                }
            }

            //找出右边最高
            int max_right=0;
            for (int j=i+1;j<num.length;j++){
                if (num[j]>max_right){
                    max_right=num[j];
                }
            }

            int min=Math.min(max_left,max_right);
            if (min>num[i]){
                sum=sum+(min-num[i]);
            }




        }
        return sum;
    }

    public static int getWater2(int[] height){
        if (height.length == 0) return 0;
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                result+=leftMax - height[left] > 0 ?
                        leftMax - height[left] : 0;
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                result +=rightMax - height[right] > 0 ?
                        rightMax - height[right] : 0;
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return result;
    }
}
