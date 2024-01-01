import java.io.*;
import java.util.Arrays;
public class childcontent {
 public int findContentChildren(int[] g, int[] s) {
     Arrays.sort(g);
     Arrays.sort(s);
     int contentChildren = 0;
     int cookieIndex = 0;
     while (cookieIndex < s.length && contentChildren < g.length) {
         if (s[cookieIndex] >= g[contentChildren])
         {
             contentChildren++;
         }
         cookieIndex++;
     }
     return contentChildren;
 }

    public static void main(String[] args) {
        childcontent ob=new  childcontent();
       int m[]={1,1};
       int n[]={1};
        int a=ob.findContentChildren(m,n);
        System.out.print(a);

    }

}

