package HomeTasks;


public class NOP {
    

// Найти НОП

    public static void main(String[] args) 
    {
      int[] x = { 1, 2, 3, 0, 6, 1, 54, 12};
      int[] y = { 1, 2, 3, 5, 4, 3, 6, 1, 54, 12};
      int nop = Length(x, y);
      System.out.println(nop);
    }
  
    public static int Length(int[] a, int[] b) 
    {
      int len =0;
      int [][] f = new int[a.length+1][b.length+1];
      for (int i = 1; i < a.length+1; i++)
      {
        for(int j = 1; j< b.length+1; j++)
        {
          if(a[i-1] == b[j-1])
          {
            f[i][j] = f[i-1][j-1] +1;
          }
          else
          {
            f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
          }  
        }
      }
      for(int i = 0; i<f.length; i++)
      {
        for(int j=0; j<f.length; j++)
        {
            System.out.print(f[i][j]);
        }
        System.out.println();
      }
      len =f[a.length][b.length];
      return len;
    }
}
  