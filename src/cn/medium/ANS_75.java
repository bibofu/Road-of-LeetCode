package cn.medium;

/**
 * @author fubibo
 * @create 2020-11-10 16:30
 */

/**
 * 给定一个包含红色、白色和蓝色，一共 *n* 个元素的数组，**原地**对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 示例：
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
public class ANS_75 {
    public static void main(String[] args) {

        int[] test={2,0,2,1,1,0,1,2,1,0};
        sortColor(test);



    }
    public static void sortColor(int[] nums){
       int low=0;
       int mid=0;
       int high=nums.length-1;
       while (mid<=high){
           if (nums[mid]==0){
               int temp1=nums[low];
               nums[low]=nums[mid];
               nums[mid]=temp1;
               low++;
               mid++;
           }else if (nums[mid]==1){
               mid++;
           }else if (nums[mid]==2){
               int temp2=nums[mid];
               nums[mid]=nums[high];
               nums[high]=temp2;
               high--;
           }
       }

       for (int i:nums){
           System.out.print(i+" ");
       }
    }

}
