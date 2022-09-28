import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Task {

    //1. Напишите программу на Java, чтобы найти наименьшее окно в строке, содержащей все символы другой строки.
    // через регулярные выражения находим совпадения второй строки в первой строке.
    
    public static void smallWindow (String firstText, String secondText) {
        Pattern pattern = Pattern.compile (secondText);
        Matcher matcher = pattern.matcher (firstText);

        while (matcher.find()) {
            System.out.println(firstText.substring(matcher.start(), matcher.end()));
        }
    }

    // 2. Напишите программу на Java, чтобы проверить, являются ли две данные строки вращением друг друга.
     public static boolean rotation(String firstStr, String secondStr) {
        return (firstStr.length() == secondStr.length()) &&
               ((firstStr + firstStr).indexOf(secondStr) != -1);

     }
     // 3. Напишите программу на Java, чтобы перевернуть строку с помощью рекурсии.
     public static String recursion(String str) {
        if(str.length() == 0)
        return " ";
        return str.charAt(str.length()-1) + recursion(str.substring(0,str.length()-1)); }
    
    //4. Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 
    //3 – 56 = -53 
    //3 * 56 = 168 Используем метод StringBuilder.append().
   
    public static String compilerMathToStr(int number1, int number2, char sign) {
        StringBuilder mathTask = new StringBuilder();
        mathTask.append(number1).append(" ").append(sign).append(" ").append(number2).append(" = ");
        switch (sign) {
            case '+':
                mathTask.append(number1 + number2);
                break;
            case '-':
                mathTask.append(number1 - number2);
                break;
            case '*':
                mathTask.append(number1 * number2);
                break;
        }
        return mathTask.toString();
    }

    //5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
  
    public static String replaceSymbol(String mathTask) {
        StringBuilder task = new StringBuilder(mathTask);
        int index = task.indexOf("=");
        return task.deleteCharAt(index).insert(index, "равно").toString();
    }
    //6. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
    public static String metodReplace(String mathTask) {
        StringBuilder task = new StringBuilder(mathTask); 
        int index = task.indexOf("=");
        return task.replace(index, index + 1, "равно").toString();
    }
    //7. Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.
    

    public static void main(String[] args) {
    /*Scanner iScanner = new Scanner(System.in);
    System.out.printf("Введите первую строку: ");
    String str1 = iScanner.nextLine();
    System.out.printf("Введите вторую строку: ");
    String str2 = iScanner.nextLine();
    iScanner.close();*/
    String str1 = "the best day came yesterday";
    String str2 = "day";
    System.out.println("Наименьшее окно первой строки, содержащей все символы второй строки (при наличии):"); smallWindow(str1, str2);  
    
    if (rotation(str1, str2))
    System.out.println("Строки являются вращением друг друга");
    else
    System.out.println("Строки не являются вращением друг друга");
    
    System.out.printf("Переворачиваем первую строку:%s\n", recursion(str1));
    System.out.printf("Переворачиваем вторую строку: %s\n", recursion(str2));
    int a = 3;
    int b = 56;
    System.out.println("Примеры:");
    System.out.println(compilerMathToStr(a, b, '+'));
    System.out.println(compilerMathToStr(a, b, '-'));
    System.out.println(compilerMathToStr(a, b, '*'));

    System.out.println("Замена знака '=' на слово");
    System.out.println(replaceSymbol(compilerMathToStr(a, b, '+')));

    System.out.println(metodReplace(compilerMathToStr(a, b, '*')));

    }
}