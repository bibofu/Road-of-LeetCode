package cn.easy;

/**
 * @author fubibo
 * @create 2020-11-09 17:06
 */

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class ANS_35 {
    public static void main(String[] args) {

        int[] num={1,2,3,5,7,9};
        System.out.println(FindIndex(num,9));

    }
    public static int FindIndex(int[] nums,int target){
        if (target>nums[nums.length-1]){
            return nums.length;
        }
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=(left+right)/2;
            if (nums[mid]<target){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return left;
    }
}
