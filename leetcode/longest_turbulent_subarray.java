class Solution {
    public static int maxTurbulenceSize(int[] arr) {
     
        int res=1,count=1;
        int[] diff= new int[arr.length];
        diff[0]=0;
        for(int i=1;i<arr.length;i++)
        {
            diff[i]=arr[i]-arr[i-1];
            if(diff[i]==0)
            {
                res=Math.max(res,count);
                count=1;
            }
            else if(diff[i]*diff[i-1]>0)
            {
                res=Math.max(res,count);
                count=2;
            }
            else 
            {
                count++;
                res=Math.max(res,count);
            }
            System.out.print(count+" ");
        }
        System.out.println();
        return res;
    }
    public static void main(String[] args) {
        int[] a={2,4,9,10,7,8,8,1,9};
        System.out.println(maxTurbulenceSize(a));
    }
}