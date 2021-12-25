import java.util.*;
class Solution
{
    //Function to find the minimum indexed character.
    public static int minIndexChar(String str, String patt)
    {
        HashMap<Character,Integer> map= new HashMap<>();
        for(int i=0;i<str.length();i++)
        {
            if(!map.containsKey(str.charAt(i)))
            map.put(str.charAt(i),i);
        }
        HashMap<Character,Integer> map1= new HashMap<>();
        int min=Integer.MAX_VALUE; 
        for(int i=0;i<patt.length();i++)
        {
            if(!map1.containsKey(patt.charAt(i)))
            {
                map1.put(patt.charAt(i),i);
                if(map.containsKey(patt.charAt(i))&&(map.get(patt.charAt(i))<min))
                {
                    min=map.get(patt.charAt(i));
                }
            }
        }
        System.out.println(map);
        System.out.println(map1);
        if(min==Integer.MAX_VALUE)
        return -1;
        return min;
    }
    public static void main(String[] args) {
        System.out.println(minIndexChar("geeksforgeeks","set"));
    }
}