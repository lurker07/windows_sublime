class Solution{
    static int trailingZeroes(int N){
        int count=0;
        long fact=1l;
        for(int i=1;i<=N;i++)
        System.out.print(fact*=i);
        System.out.println(fact);
        while(true)
        {
            long r=fact%10;
            if(r==0&&fact!=0)
            {count++;
            fact=fact/10;}
            else
            break;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(trailingZeroes(384));
    }
}