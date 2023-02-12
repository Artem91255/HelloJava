package HomeTasks;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму. 
// Пример 1: а = 3, b = 2, ответ: 9 
// Пример 2: а = 2, b = -2, ответ: 0.25
// Пример 3: а = 3, b = 0, ответ: 1
// Пример 4: а = 0, b = 0, ответ: не определено
// Пример 5
// входные данные находятся в файле input.txt в виде
// b 3
// a 10
// Результат нужно сохранить в файле output.txt
// 1000

public class HomeTask2 {
    public static void main(String[] args) {
        int [] arr = GetFromTheFile();
        PutInTheFile(GetPow(arr));
    }
    public static String GetPow(int [] numbers)
    {
        String qwe = "";
        if(numbers[0] == 0 && numbers[1] ==0)
        {
            qwe+="Не определено";
        }
        else
        {  
            double z = Math.pow(numbers[1], numbers[0]);
            String result = "";
            if (z%1 ==0)
            {
                result = String.format("%.0f", z).replace(',', '.');
            }
            else
            {
                result = String.format("%.2f", z).replace(',', '.');
            }
        
            qwe += result;
        }
        return qwe;
    }
    public static void PutInTheFile(String x)
    {
        try (FileWriter fw = new FileWriter("output.txt", false))
        {
            String str = x;
            fw.write(str);   
            fw.flush();
        } 
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public static int[] GetFromTheFile()
    {
        String s ="";
        try
        {
            FileReader fr = new FileReader("input.txt");
            int c;
            while ((c = fr.read()) !=-1) 
            {
                char ch = (char) c;
                if (ch == '\n') 
                {
                    s+=" ";   
                } 
                else
                {
                    if(Character.isDigit(ch) || ch=='-')
                    {
                        s +=ch;
                    }
                }
            }
            fr.close();
        }  
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }    
       
        String[] numbers = s.split(" ");
        int[] twoNumbers = new int[numbers.length];
        for(int i = 0; i<numbers.length; i ++)
        {
            twoNumbers[i] = Integer.parseInt(numbers[i]);
        }
    return twoNumbers;
    }
}


