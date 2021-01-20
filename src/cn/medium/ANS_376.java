package cn.medium;

/**
 * @author fubibo
 * @create 2021-01-05 21:44
 */


/**
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，
 * 第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 *
 * 输入: [1,7,4,9,2,5]
 * 输出: 6
 * 解释: 整个序列均为摆动序列。
 *
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 */
public class ANS_376 {
    public static void main(String[] args) {

        int[] test={1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength(test));

    }

    public static int wiggleMaxLength(int[] nums){
        if (nums.length<=2){
            return nums.length;
        }


        final int BEGIN=0;
        final int UP=1;
        final int DOWN=2;
        int STATE=BEGIN;

        int maxsize=1;

        for (int i = 1; i <nums.length ; i++) {
            switch (STATE){
                case BEGIN:
                    if (nums[i-1]<nums[i]){
                        STATE=UP;
                        maxsize++;

                    }else if (nums[i-1]>nums[i]){
                        STATE=DOWN;
                        maxsize++;

                    }
                    break;

                case UP:
                    if (nums[i-1]>nums[i]){
                        STATE=DOWN;
                        maxsize++;
                    }
                    break;


                case DOWN:
                    if (nums[i-1]<nums[i]){
                        STATE=UP;
                        maxsize++;
                    }
                    break;

            }


        }



        return maxsize;
    }

}
