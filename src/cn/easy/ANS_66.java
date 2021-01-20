package cn.easy;

/**
 * @author fubibo
 * @create 2020-11-10 17:26
 */

/**
 * 给定一个由**整数**组成的**非空**数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 */
public class ANS_66 {
    public static void main(String[] args) {
        int[] test={9,2,9,4};
        int[] res=plusOne(test);
        for (int i:res){
            System.out.print(i+" ");
        }

    }
    public static int[] plusOne(int[] num){

        int[] res=new int[num.length+1];
        res[0]=0;
        for (int i=0;i<num.length;i++){
            res[i+1]=num[i];
        }

        for (int i = res.length - 1; i >0; i--) {
            if (res[i] < 9) {
                res[i]++;

            } else if (res[i] == 9) {
                res[i] = 0;
                if (i==1) {
                    res[i - 1]++;
                }

            }
        }
        return res;


    }
}
