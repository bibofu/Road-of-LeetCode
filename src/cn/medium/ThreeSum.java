package cn.medium;



public class ThreeSum {
    public static void main(String[] args) {
        int[] a={-4,-3,-2,-1,0,1,2,3,6,7};
        getThreeSum(a);

    }
    public static void getThreeSum(int[] arr){
        for (int index=0;index<arr.length;index++){
            int start=index+1;
            int end=arr.length-1;
            while (start<end){
                if(arr[index]+arr[start]+arr[end]<0){
                    start++;
                }else if(arr[index]+arr[start]+arr[end]>0){
                    end--;
                }else if(arr[index]+arr[start]+arr[end]==0){
                    System.out.println(arr[index]+" "+arr[start]+" "+arr[end]);
                    start++;
                }
            }
        }
    }
    
}
