package HomeTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HomeTask4_Chernovick {
    public static void main(String[] args) 
    {
       /*Методы:
       1. Вносим исходные данные о массиве
        * 1.1 Создаем массив и задаем границы и препятствия
        2. распространяем волну
        3. Ищем маршрут
        4. создаем двумерный массив строк
        5. Заполняем массив строк данными из изначального массива и отмечаем на нем маршрут
        5. Выводим в терминал массив с нарисованным маршрутом
        */
  //       Scanner isScanner = new Scanner(System.in);
  //       System.out.println();
  //       System.out.printf("Введите количество столбцов: ");
  //       int rows = isScanner.nextInt();
  //       System.out.printf("Введите количество строк: ");
  //       int columns = isScanner.nextInt();
  //       int rows2 = rows+2;
  //       int columns2 = columns+2;
  //       int [][] startArray = new int[rows2][columns2];
        
    
        
     
      
  //   } 
  // }    
     int a = 10;
      int b = 9;
      int ax2 = a+2;
      int bx2 = b+2;
      int startTag = 1;
      int finishTag = -2;
       int [][] f = new int[ax2][bx2];
      String [][] finishArray = new String[ax2][bx2];
      
     //заполняем случайно
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
      for(int i = 0; i<ax2; i++)
      {
        for(int j=0; j<bx2; j++)
        {
          System.out.printf("%d  \t",f[i][j]);  
        }
        System.out.println();
      }
      System.out.println();

 


   //Распространение волны
      int startRow = 5;
      int startColumn = 3;
      int exit = finishTag;
      int exit2 = finishTag;

      ArrayList <Integer> waypoints = new ArrayList <Integer>();

      Queue<Integer> queueRow = new LinkedList<Integer>();
      Queue<Integer> queueColumn = new LinkedList<Integer>();
      Queue<Integer> queueRowFinish = new LinkedList<Integer>();
      Queue<Integer> queueColumnFinish = new LinkedList<Integer>();
      int itemRow = startRow;
      queueRow.add(itemRow);
      int itemColumn = startColumn;
      queueColumn.add(itemColumn);
      ;
      int row = 0;
      int col = 0;
      int rowFinish = 0;
      int colFinish = 0;

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

      
       

    
for(int i = 1; i<ax2-1; i++)
       {
         for(int j=1; j<bx2-1; j++)
         {
             System.out.printf("%d  \t",f[i][j]) ;
            
         }
         System.out.println();
       }
    System.out.println();

//System.out.println("Программа завершена");
//System.out.println("rowFinish is: " + rowFinish+ " colFinish is: " + colFinish);
// for(int i = 0; i<waypoints.size(); i++)
// {
//   System.out.println(waypoints.get(i));
// }
// System.out.println(queueRowFinish.element());
// System.out.println(queueColumnFinish.element());
// System.out.println(f[queueRowFinish.element()][queueColumnFinish.element()]);

System.out.println("реализуем поиск маршрута");
 //реализуем поиск маршрута

 
//  int rowFinish = 0;
//  int colFinish = 0;
Queue<Integer> queueRowWaypoint = new LinkedList<Integer>();
Queue<Integer> queueColumnWaypoint = new LinkedList<Integer>();
Queue<Integer> finalRowWaypoint = new LinkedList<Integer>();
Queue<Integer> finalColumnWaypoint = new LinkedList<Integer>();
ArrayList <Integer> route = new ArrayList <Integer>();
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
   //f[rowFinishToStart-1][colFinishToStart]=0;
   continue;
  }
  if(f[rowFinishToStart][colFinishToStart+1]==f[rowFinishToStart][colFinishToStart] - 1 )
  {
    route.add(f[rowFinishToStart][colFinishToStart+1]);
    queueRowWaypoint.add(rowFinishToStart);
    queueColumnWaypoint.add(colFinishToStart+1);
    finalRowWaypoint.add(rowFinishToStart);
    finalColumnWaypoint.add(colFinishToStart+1);
   // f[rowFinishToStart][colFinishToStart+1] = 0;
    continue;
  }
  if( f[rowFinishToStart+1][colFinishToStart]==f[rowFinishToStart][colFinishToStart] - 1  )
  {
    route.add(f[rowFinishToStart+1][colFinishToStart]);
   queueRowWaypoint.add(rowFinishToStart+1);
   queueColumnWaypoint.add(colFinishToStart);
   finalRowWaypoint.add(rowFinishToStart+1);
   finalColumnWaypoint.add(colFinishToStart);
  // f[rowFinishToStart+1][colFinishToStart] = 0;
   continue;
  }
  if(f[rowFinishToStart][colFinishToStart-1]==f[rowFinishToStart][colFinishToStart] - 1 )
  {
    route.add(f[rowFinishToStart][colFinishToStart-1]);
   queueRowWaypoint.add(rowFinishToStart);
   queueColumnWaypoint.add(colFinishToStart-1);
   finalRowWaypoint.add(rowFinishToStart);
   finalColumnWaypoint.add(colFinishToStart-1);
   //f[rowFinishToStart][colFinishToStart-1] = 0;
   continue;
  }

  
  

      
 
  }
 
    System.out.println();
  System.out.println("Кратчайший маршрут построен: ");
  
  for(int i = 0; i<route.size(); i++)
{
  System.out.printf("%d  ",route.get(i));
}
System.out.println();
//  System.out.println("координаты ячеек, через который пролегает кратчайший маршрут(номер строки): ");

 
//  int z = finalRowWaypoint.size();
// for(int i = 0; i<z; i++)
// {
//   int x = finalRowWaypoint.remove();
//   int y = finalColumnWaypoint.remove();
//   System.out.print(x + " - "+ y + "; ");
// }

System.out.println();
System.out.println();

//Заполняем массив строками

for(int i =0; i<ax2; i++)
       {
         for(int j=0; j<bx2; j++)
         {
             finishArray[i][j] = f[i][j] +"";
             System.out.printf("%s  \t",finishArray[i][j]) ;
            
         }
         System.out.println();
       }
    System.out.println();
 
    
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



/*чтобы построить обратный маршрут,, мы берем точку, которую мы приняли за финиш и тем же аглоритмом проходимся порядом стоящим клеткам в определенном порядке. И первая клетка, которая будет меньше исходной за единицу, записывается в очередь и процесс провторяется, 
пока не найдется ячейка со значением 1. На этом алгоритм завершается */


 

/*__________________________________________________________________ */    

// int a = 10;
//       int b = 9;
//       int ax2 = a+2;
//       int bx2 = b+2;
//       int startTag = 1;
//       int finishTag = -2;
//       int [][] f = new int[ax2][bx2];
//       String [][] finishArray = new String[ax2][bx2];
      
//      //заполняем случайно
//       f[2][2] = -1;
//       f[2][3] = -1;
//       f[2][4] = -1;
//       f[3][5] = -1;
//       f[4][4] = -1;
//       f[4][5] = -1;
//       f[4][6] = -1;
//       f[5][4] = -1;
//       f[6][4] = -1;
//       f[7][4] = -1;
//       f[8][4] = -1;
//       f[8][3] = -1;
//       f[8][2] = -1;
//       f[8][8] = -1;
//       f[8][7] = -1;
//       f[7][7] = -1;
//       f[6][7] = -1;
//       f[5][7] = -1;
        
        
//       f[10][9]= finishTag;
//       f[2][8]= finishTag;
//       f[5][3] = startTag;
//       for(int i = 0; i<ax2;i++)
//       {
//         f[i][0] =-1;
//         f[i][a] = -1;
//       }
//       for(int i = 0; i<bx2; i++)
//       {
//         f[0][i] = -1;
//         f[bx2][i] = -1;
//       }
//       for(int i = 0; i<ax2; i++)
//       {
//         for(int j=0; j<bx2; j++)
//         {
//           System.out.printf("%d  \t",f[i][j]);  
//         }
//         System.out.println();
//       }
//       System.out.println();

 


//    //Распространение волны
//       int startRow = 5;
//       int startColumn = 3;
//       int exit = finishTag;
//       int exit2 = finishTag;

//       ArrayList <Integer> waypoints = new ArrayList <Integer>();

//       Queue<Integer> queueRow = new LinkedList<Integer>();
//       Queue<Integer> queueColumn = new LinkedList<Integer>();
//       Queue<Integer> queueRowFinish = new LinkedList<Integer>();
//       Queue<Integer> queueColumnFinish = new LinkedList<Integer>();
//       int itemRow = startRow;
//       queueRow.add(itemRow);
//       int itemColumn = startColumn;
//       queueColumn.add(itemColumn);
//       ;
//       int row = 0;
//       int col = 0;
//       int rowFinish = 0;
//       int colFinish = 0;

//       boolean isExit = false;
 
//       while(!isExit)
//       {
//         row = queueRow.remove();
//         col = queueColumn.remove();
        
   
//        if(f[row-1][col]==0 )
//        {
//         f[row-1][col]=f[row][col]+1;
//         queueRow.add(row-1);
//         queueColumn.add(col);
//        }
//        if(f[row][col+1]==0 )
//        {
//          f[row][col+1]=f[row][col]+1;
//          queueRow.add(row);
//          queueColumn.add(col+1);
//        }
//        if( f[row+1][col]==0 )
//        {
//         f[row+1][col]=f[row][col]+1;
//         queueRow.add(row+1);
//         queueColumn.add(col);
//        }
//        if(f[row][col-1]==0)
//        {
//         f[row][col-1]=f[row][col]+1;
//         queueRow.add(row);
//         queueColumn.add(col-1);
//        }

//        if (queueRow.isEmpty())
//        {
        
//          isExit = true;
//        }
    
    
   
//          if(f[row][col+1]==-2)
//        {
//         System.out.println("Выход найден. Он в точке " + row + " - "+ (col+1));
//         f[row][col+1]=f[row][col]+1;
//         queueRowFinish.add(row);
        
//         queueColumnFinish.add(col+1);
//         waypoints.add(f[row][col+1]);
    
//        }
//        if(f[row][col-1]==-2)
//        { 
//         System.out.println("Выход найден. Он в точке " + row + " "+ (col-1));
//         f[row][col-1]=f[row][col]+1;
//         queueRowFinish.add(row);
//         queueColumnFinish.add(col-1);
//         waypoints.add(f[row][col-1]);
      
//        } 
//        if(f[row+1][col]==-2)
//        {
//         System.out.println("Выход найден. Он в точке " + (row+1) + " "+ col);
//         f[row+1][col]=f[row][col]+1;
//         queueRowFinish.add(row+1);
//         queueColumnFinish.add(col);
//         waypoints.add(f[row+1][col]);
        
//        }
//        if(f[row-1][col]==-2)
//        {
//         System.out.println("Выход найден. Он в точке " + (row-1) + " "+ col);
//         f[row-1][col]=f[row][col]+1;
//         queueRowFinish.add(row-1);
//         queueColumnFinish.add(col);
//         waypoints.add(f[row-1][col]);
      
//        }
    
   

    
//        }

      
       

    
// for(int i = 1; i<ax2-1; i++)
//        {
//          for(int j=1; j<bx2-1; j++)
//          {
//              System.out.printf("%d  \t",f[i][j]) ;
            
//          }
//          System.out.println();
//        }
//     System.out.println();

// //System.out.println("Программа завершена");
// //System.out.println("rowFinish is: " + rowFinish+ " colFinish is: " + colFinish);
// // for(int i = 0; i<waypoints.size(); i++)
// // {
// //   System.out.println(waypoints.get(i));
// // }
// // System.out.println(queueRowFinish.element());
// // System.out.println(queueColumnFinish.element());
// // System.out.println(f[queueRowFinish.element()][queueColumnFinish.element()]);

// System.out.println("реализуем поиск маршрута");
//  //реализуем поиск маршрута

 
// //  int rowFinish = 0;
// //  int colFinish = 0;
// Queue<Integer> queueRowWaypoint = new LinkedList<Integer>();
// Queue<Integer> queueColumnWaypoint = new LinkedList<Integer>();
// Queue<Integer> finalRowWaypoint = new LinkedList<Integer>();
// Queue<Integer> finalColumnWaypoint = new LinkedList<Integer>();

// ArrayList <Integer> route = new ArrayList <Integer>();
// queueRowWaypoint.add(queueRowFinish.element());
// queueColumnWaypoint.add(queueColumnFinish.element());
// int rowFinishToStart = 0;
//  int colFinishToStart = 0;
//  finalRowWaypoint.add(queueRowWaypoint.element());
//    finalColumnWaypoint.add(queueColumnWaypoint.element());
//  boolean isExit2 = false;

//  while(!isExit2)
//  {

//    rowFinishToStart= queueRowWaypoint.remove();
//    colFinishToStart= queueColumnWaypoint.remove();
  
//    if (f[rowFinishToStart][colFinishToStart]==1 )
//    {
 
//      isExit2 = true;
//    }
//   if(f[rowFinishToStart-1][colFinishToStart]==f[rowFinishToStart][colFinishToStart] - 1 )
//   {
//    route.add(f[rowFinishToStart-1][colFinishToStart]);
//    queueRowWaypoint.add(rowFinishToStart-1);
//    queueColumnWaypoint.add(colFinishToStart);
//    finalRowWaypoint.add(rowFinishToStart-1);
//    finalColumnWaypoint.add(colFinishToStart);
//    //f[rowFinishToStart-1][colFinishToStart]=0;
//    continue;
//   }
//   if(f[rowFinishToStart][colFinishToStart+1]==f[rowFinishToStart][colFinishToStart] - 1 )
//   {
//     route.add(f[rowFinishToStart][colFinishToStart+1]);
//     queueRowWaypoint.add(rowFinishToStart);
//     queueColumnWaypoint.add(colFinishToStart+1);
//     finalRowWaypoint.add(rowFinishToStart);
//     finalColumnWaypoint.add(colFinishToStart+1);
//    // f[rowFinishToStart][colFinishToStart+1] = 0;
//     continue;
//   }
//   if( f[rowFinishToStart+1][colFinishToStart]==f[rowFinishToStart][colFinishToStart] - 1  )
//   {
//     route.add(f[rowFinishToStart+1][colFinishToStart]);
//    queueRowWaypoint.add(rowFinishToStart+1);
//    queueColumnWaypoint.add(colFinishToStart);
//    finalRowWaypoint.add(rowFinishToStart+1);
//    finalColumnWaypoint.add(colFinishToStart);
//   // f[rowFinishToStart+1][colFinishToStart] = 0;
//    continue;
//   }
//   if(f[rowFinishToStart][colFinishToStart-1]==f[rowFinishToStart][colFinishToStart] - 1 )
//   {
//     route.add(f[rowFinishToStart][colFinishToStart-1]);
//    queueRowWaypoint.add(rowFinishToStart);
//    queueColumnWaypoint.add(colFinishToStart-1);
//    finalRowWaypoint.add(rowFinishToStart);
//    finalColumnWaypoint.add(colFinishToStart-1);
//    //f[rowFinishToStart][colFinishToStart-1] = 0;
//    continue;
//   }

  
  

      
 
//   }
 
//     System.out.println();
//   System.out.println("Кратчайший маршрут построен: ");
  
//   for(int i = 0; i<route.size(); i++)
// {
//   System.out.printf("%d  ",route.get(i));
// }
// System.out.println();
// //  System.out.println("координаты ячеек, через который пролегает кратчайший маршрут(номер строки): ");

 
// //  int z = finalRowWaypoint.size();
// // for(int i = 0; i<z; i++)
// // {
// //   int x = finalRowWaypoint.remove();
// //   int y = finalColumnWaypoint.remove();
// //   System.out.print(x + " - "+ y + "; ");
// // }

// System.out.println();
// System.out.println();

// //Заполняем массив строками

// for(int i =0; i<ax2; i++)
//        {
//          for(int j=0; j<bx2; j++)
//          {
//              finishArray[i][j] = f[i][j] +"";
//              System.out.printf("%s  \t",finishArray[i][j]) ;
            
//          }
//          System.out.println();
//        }
//     System.out.println();
 
    
//     int z = finalRowWaypoint.size();
//   for (int i = 0; i<z; i++)
//   {
//     row = finalRowWaypoint.remove();
//     col = finalColumnWaypoint.remove();
//     finishArray[row][col] = "#";
//   }  
//   for(int i =1; i<ax2-1; i++)
//        {
//          for(int j=1; j<bx2-1; j++)
//          {
             
//              System.out.printf("%s  \t",finishArray[i][j]) ;
            
//          }
//          System.out.println();
//        }
//     System.out.println();
// }
// }