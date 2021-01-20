package cn.medium;

/**
 * @author fubibo
 * @create 2020-12-01 10:46
 */

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 输入: [2,2,3,2]
 * 输出: 3
 */
public class ANS_137 {
    public static void main(String[] args) {

        int[] nums={1,2,3,3,2,1,4,1,2,3};
        System.out.println(findOneAppear(nums));

    }


    public static int findOneAppear(int[] n){
        int one=0;
        int two=0;
        for (int i:n){
            one=(one^i)&(~two);
            two=(two^i)&(~one);

        }
        return one;

    }
}
