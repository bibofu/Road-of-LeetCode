package cn.medium;

/**
 * @author fubibo
 * @create 2020-12-20 21:53
 */

/**
 * 整数拆分，比如
 * 4=1+1+1+1
 * 4=1+1+2;
 * 4=1+3;
 * 4=2+2；
 * 4=4；
 */
public class Test1 {
     static int res_num;
    // 拆分元素暂存在res数组中
     static int[] res=new int[20];
     static int p = 0;

    public static void main(String[] args) {

        resolve(4,1);



    }
    public static void resolve(int n,int min_factor){
        if (n<=0){
            for (int i=0;i<p;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
            res_num++;
        }

       for (int i=min_factor;i<=n;i++){
           res[p]=i;
           p++;
           resolve(n-i,i);
           p--;
       }


    }

}
