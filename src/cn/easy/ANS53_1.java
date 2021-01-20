package cn.easy;

/**
 * @author fubibo
 * @create 2020-11-04 11:00
 */
public class ANS53_1 {
    public static void main(String[] args) {

        int[] num={1,2,3,3,4,4,4,5};
        System.out.println(findTimes(num,4));

    }
    public static int findTimes(int[] nums,int target){
        int start=0;
        int end=nums.length-1;
        int mid=0;
        int left=0;
        int right=0;
        while (start<=end){
            mid=(int)Math.ceil((start+end)/2);
            if (nums[mid]<=target){
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        right=start-1;//右边界

        start=0;
        mid=0;
        end=nums.length-1;
        while (start<=end){
            mid=(int)Math.ceil((start+end)/2);
            if (nums[mid]<target){
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        left=end+1;

        return right-left+1;
    }
}
