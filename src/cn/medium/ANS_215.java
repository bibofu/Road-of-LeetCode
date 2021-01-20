package cn.medium;

/**
 * @author fubibo
 * @create 2021-01-04 23:02
 */

import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 * 示例1：
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例2：
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class ANS_215 {
    public static void main(String[] args) {
        int[] test={3,2,1,5,6,4};
        System.out.println(findKthLargest(test,2));

    }

    public static int findKthLargest(int[] nums,int k){
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (int i=0;i<nums.length;i++){
            if (heap.size()<k) {
                heap.add(nums[i]);
            }else if (heap.element()<nums[i]){
                heap.poll();
                heap.add(nums[i]);
            }

        }

        return heap.poll();


    }
}
