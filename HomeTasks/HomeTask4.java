


    package HomeTasks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class HomeTask4 {
    public static void main(String[] args) 
    {

       
        int rows = 10;
        int columns = 9;
        int startingPointRow = 5; 
        int startingPointColumns = 3;
     
        ArrayList <Integer> waypoints = new ArrayList <Integer>();
        Queue<Integer> queueRow = new LinkedList<Integer>();
        Queue<Integer> queueColumn = new LinkedList<Integer>();
        Queue<Integer> queueRowFinish = new LinkedList<Integer>();
        Queue<Integer> queueColumnFinish = new LinkedList<Integer>();

        Queue<Integer> queueRowWaypoint = new LinkedList<Integer>();
        Queue<Integer> queueColumnWaypoint = new LinkedList<Integer>();
        Queue<Integer> finalRowWaypoint = new LinkedList<Integer>();
        Queue<Integer> finalColumnWaypoint = new LinkedList<Integer>();
        ArrayList <Integer> route = new ArrayList <Integer>();

        
        
        int[][] startArray = createStartArray(rows, columns);
        int[][] arr2 = createStartArray(rows, columns);

        addBlockAndBorders(rows, columns, startArray);
        addBlockAndBorders(rows, columns, arr2);
        waveMotion(startingPointRow, startingPointColumns, startArray, queueRow, queueColumn, queueRowFinish, queueColumnFinish, waypoints );
        routeSearch(queueRowWaypoint, queueColumnWaypoint, finalRowWaypoint, finalColumnWaypoint, route, queueRowFinish, queueColumnFinish, startArray);
        
        printArray(rows, columns, arr2);
       
        routeOutput(startArray, rows, columns, finalRowWaypoint, finalColumnWaypoint);


       

        
    }
   public static int[][] createStartArray(int a,int b)
   {
    int rows2 = a+2;
    int columns2 = b+2;
    int [][] array = new int[rows2][columns2];
    return array;
   }
   public static void printArray(int rows, int columns, int[][] array)
   {
    for(int i = 1; i<rows+1; i++)
    {
      for(int j=1; j<columns+1; j++)
      {
        System.out.printf("%d  \t",array[i][j]);  
      }
      System.out.println();
    }
    System.out.println();
   }

   public static void addBlockAndBorders(int a, int b, int [][]f)
   {
    int ax2 = a+2;
    int bx2 = b+2;

    int startTag = 1;
    int finishTag = -2;
      f[2][2] = -1;
      f[2][3] = -1;
      f[2][4] = -1;
      f[3][5] = -1;
      f[4][4] = -1;
      f[4][5] = -1;
      f[4][6] = -1;
      f[5][4] = -1;
      f[6][4] = -1;
      f[7][4] = -1;
      f[8][4] = -1;
      f[8][3] = -1;
      f[8][2] = -1;
      f[8][8] = -1;
      f[8][7] = -1;
      f[7][7] = -1;
      f[6][7] = -1;
      f[5][7] = -1;

      f[10][9]= finishTag;
       f[2][8]= finishTag;
       f[5][3] = startTag;

      for(int i = 0; i<ax2;i++)
      {
        f[i][0] =-1;
        f[i][a] = -1;
      }
      for(int i = 0; i<bx2; i++)
      {
        f[0][i] = -1;
        f[bx2][i] = -1;
      }
   }
  
   public static void waveMotion(int startRow, int startColumn, int[][]f, Queue<Integer> queueRow, Queue<Integer> queueColumn, Queue<Integer> queueRowFinish, Queue<Integer> queueColumnFinish, ArrayList <Integer> waypoints)
   {
      int itemRow = startRow;
      queueRow.add(itemRow);
      int itemColumn = startColumn;
      queueColumn.add(itemColumn);
      
      int row = 0;
      int col = 0;
      
      boolean isExit = false;
 
      while(!isExit)
      {
        row = queueRow.remove();
        col = queueColumn.remove();
        
       if(f[row-1][col]==0 )
       {
        f[row-1][col]=f[row][col]+1;
        queueRow.add(row-1);
        queueColumn.add(col);
       }
       if(f[row][col+1]==0 )
       {
         f[row][col+1]=f[row][col]+1;
         queueRow.add(row);
         queueColumn.add(col+1);
       }
       if( f[row+1][col]==0 )
       {
        f[row+1][col]=f[row][col]+1;
        queueRow.add(row+1);
        queueColumn.add(col);
       }
       if(f[row][col-1]==0)
       {
        f[row][col-1]=f[row][col]+1;
        queueRow.add(row);
        queueColumn.add(col-1);
       }
       if (queueRow.isEmpty())
       {
        
         isExit = true;
       }
         if(f[row][col+1]==-2)
       {
        System.out.println("Выход найден. Он в точке " + row + " - "+ (col+1));
        f[row][col+1]=f[row][col]+1;
        queueRowFinish.add(row);
        queueColumnFinish.add(col+1);
        waypoints.add(f[row][col+1]);
       }
       if(f[row][col-1]==-2)
       { 
        System.out.println("Выход найден. Он в точке " + row + " "+ (col-1));
        f[row][col-1]=f[row][col]+1;
        queueRowFinish.add(row);
        queueColumnFinish.add(col-1);
        waypoints.add(f[row][col-1]);
       } 
       if(f[row+1][col]==-2)
       {
        System.out.println("Выход найден. Он в точке " + (row+1) + " "+ col);
        f[row+1][col]=f[row][col]+1;
        queueRowFinish.add(row+1);
        queueColumnFinish.add(col);
        waypoints.add(f[row+1][col]); 
       }
       if(f[row-1][col]==-2)
       {
        System.out.println("Выход найден. Он в точке " + (row-1) + " "+ col);
        f[row-1][col]=f[row][col]+1;
        queueRowFinish.add(row-1);
        queueColumnFinish.add(col);
        waypoints.add(f[row-1][col]);
       }
    }
   }

   public static void routeSearch(Queue<Integer> queueRowWaypoint, Queue<Integer> queueColumnWaypoint, Queue<Integer> finalRowWaypoint, Queue<Integer> finalColumnWaypoint, ArrayList <Integer> route, Queue<Integer> queueRowFinish, Queue<Integer> queueColumnFinish, int[][] f )
   {
    queueRowWaypoint.add(queueRowFinish.element());
    queueColumnWaypoint.add(queueColumnFinish.element());
    int rowFinishToStart = 0;
    int colFinishToStart = 0;
    finalRowWaypoint.add(queueRowWaypoint.element());
    finalColumnWaypoint.add(queueColumnWaypoint.element());

    boolean isExit2 = false;

 while(!isExit2)
 {

   rowFinishToStart= queueRowWaypoint.remove();
   colFinishToStart= queueColumnWaypoint.remove();
  
   if (f[rowFinishToStart][colFinishToStart]==1 )
   {
 
     isExit2 = true;
   }
  if(f[rowFinishToStart-1][colFinishToStart]==f[rowFinishToStart][colFinishToStart] - 1 )
  {
   route.add(f[rowFinishToStart-1][colFinishToStart]);
   queueRowWaypoint.add(rowFinishToStart-1);
   queueColumnWaypoint.add(colFinishToStart);
   finalRowWaypoint.add(rowFinishToStart-1);
   finalColumnWaypoint.add(colFinishToStart);
   
   continue;
  }
  if(f[rowFinishToStart][colFinishToStart+1]==f[rowFinishToStart][colFinishToStart] - 1 )
  {
    route.add(f[rowFinishToStart][colFinishToStart+1]);
    queueRowWaypoint.add(rowFinishToStart);
    queueColumnWaypoint.add(colFinishToStart+1);
    finalRowWaypoint.add(rowFinishToStart);
    finalColumnWaypoint.add(colFinishToStart+1);
   
    continue;
  }
  if( f[rowFinishToStart+1][colFinishToStart]==f[rowFinishToStart][colFinishToStart] - 1  )
  {
    route.add(f[rowFinishToStart+1][colFinishToStart]);
   queueRowWaypoint.add(rowFinishToStart+1);
   queueColumnWaypoint.add(colFinishToStart);
   finalRowWaypoint.add(rowFinishToStart+1);
   finalColumnWaypoint.add(colFinishToStart);
  
   continue;
  }
  if(f[rowFinishToStart][colFinishToStart-1]==f[rowFinishToStart][colFinishToStart] - 1 )
  {
    route.add(f[rowFinishToStart][colFinishToStart-1]);
   queueRowWaypoint.add(rowFinishToStart);
   queueColumnWaypoint.add(colFinishToStart-1);
   finalRowWaypoint.add(rowFinishToStart);
   finalColumnWaypoint.add(colFinishToStart-1);
  
   continue;
  }
   }

}

    public static void routeOutput(int[][] f, int a, int b, Queue<Integer> finalRowWaypoint, Queue<Integer> finalColumnWaypoint)
    {
        int ax2 = a+2;
        int bx2 = b+2;
        int row = 0;
        int col = 0;
        String [][] finishArray = new String[ax2][bx2];
        for(int i =0; i<ax2; i++)
       {
         for(int j=0; j<bx2; j++)
         {
             finishArray[i][j] = f[i][j] +"";            
         }
       
       }

 
    
    int z = finalRowWaypoint.size();
  for (int i = 0; i<z; i++)
  {
    row = finalRowWaypoint.remove();
    col = finalColumnWaypoint.remove();
    finishArray[row][col] = "#";
  }  
  for(int i =1; i<ax2-1; i++)
       {
         for(int j=1; j<bx2-1; j++)
         {
             
             System.out.printf("%s  \t",finishArray[i][j]) ;
            
         }
         System.out.println();
       }
    System.out.println();
    }
}


