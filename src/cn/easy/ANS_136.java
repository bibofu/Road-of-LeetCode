package cn.easy;



public class ANS_136 {
    public static void main(String[] args) {
        int[] a={1,2,3,4,3,2,1,5,4};
        System.out.println(getSingle(a));

    }
    public static int getSingle(int[] nums){
        int res=0;
        for (int i:nums){
            res=res^i;//异或操作
        }
        return res;

    }
}
