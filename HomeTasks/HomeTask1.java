package HomeTasks;
/*
1.получаем число n
2.считаем по формуле
3.выводим на экран
*/
import java.util.Scanner;


public class HomeTask1 {
    public static int getNumber(){
    Scanner isScanner = new Scanner(System.in);
    String nNumber = isScanner.nextLine();
    int n = Integer.parseInt(nNumber);
    return n;
    }

public static double getTriangularNumber(int num){
        double answer = 0.5*num*(num+1);
        return answer;
    }
public static void outputData(int num, double answer){
        System.out.printf("Треугольное число Т%d равно %.0f", num, answer);
    }
public static void main(String[] args) {
     System.out.printf("Введите n для n-го трегольного числа Tn: ");
     int number = getNumber();
     double TriangularNumber = getTriangularNumber(number);
     outputData(number, TriangularNumber);
}
}
