package HomeTasks;

public class HomeTask3 {
    public static void main(String[] args) 
    {
      int startValue = 1; // Начальное значение диапазона - "от"
      int endValue = 20; // Конечное значение диапазона - "до"
      int x = randomNumbers(startValue, endValue);
      int y = randomNumbers(startValue, endValue);
      int countOfPath = getCount(x, y);
      System.out.println(countOfPath);
      
    }
    public static int randomNumbers(int start, int end)
    {
      int randomNumber = start+(int) (Math.random() * end);
      return randomNumber;
    }
  
    public static int getCount(int a, int b) 
    {
      int hor = 1+(int) (Math.random() * a);
      int vert =1+ (int) (Math.random() * b);
      int [][] f = new int[a+1][b+1];
      for (int i = hor; i < a+1; i++)
      {
        for(int j = vert; j< b+1; j++)
        {
          if(i==hor || j==vert)
          {
            f[i][j] = f[i-1][j-1] +1;
          }
          else
          {
            f[i][j] = f[i-1][j] +f[i][j-1];
          }  
        }
      }
      int count =f[a][b];
      return count;
    }
}
  

