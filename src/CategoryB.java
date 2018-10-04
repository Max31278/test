import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

import static java.lang.StrictMath.min;

public class CategoryB {
    public void task1(String str){
        Stack stack = new Stack<>(); // переменная для хранения стека
        boolean bool = true;            // переменная для хранения текущего состояния выражения
        char[] strChar = str.toCharArray(); // разбиваем строку на символы
        for(int i = 0; i < strChar.length; i++){
            if((strChar[i] == '(') || (strChar[i] == '[') || (strChar[i] == '{'))   // если встречаем открывающуюся скобку
                stack.push(strChar[i]);                                             // отправляем ее в стек
            else if ((strChar[i] == ')') || (strChar[i] == ']') || (strChar[i] == '}')){    // если встречаем закрывающуюся скобку
                if(!stack.empty()){                                                     // проверяем, чтобы стек не был пустым
                    switch (strChar[i]){                // на каждую закрывающуся скобку проверяем,
                        case ')' :{                     // чтобы наверху стека лежала, идентичная ей открывающаяся
                            if(!cheak(stack, '(')) bool = false;    // если получаем false, то выражение неверное
                            break;
                        }
                        case ']':{
                            if (!cheak(stack, '[')) bool = false;
                            break;
                        }
                        case  '}':{
                            if(!cheak(stack, '{')) bool = false;
                            break;
                        }
                    }
                    if(!bool) break;
                }
                else {
                    bool = false;
                    break;
                }
            }
        }
        if(stack.empty() && bool) System.out.println("SUCCESS"); // делаем проверку, чтобы стек был пустым и состояние было верным
        else System.out.println("FAIL");    // в противном случае выводим FAIL
    }

    public void task2(int N){
        Random random = new Random();
        int[] array = new int[N*N];                 //создаем массив размерностью N*N
        for(int i = 0; i < array.length; i++){      // Заполняем массив рандомными числами
            array[i] = random.nextInt(100);  // от 0 до 100
        }
        Arrays.sort(array);     // сортируем массив по возрастанию
        int count = 0;
        int[][] matrix = new int[N][N];
        int level =(int) N/2;       //уровень витка
        int L;                      //коэффициенты перехода
        int P;                      //индексов
        int K;                      //массива
        for(int i = 0; i < level; i++){
            L = (N - (2 * i + 1)) * 2;
            P = N - (2 * i);
            K = (N - (2 * i + 1)) * 3;
            for(int j = i; j < (N-i); j++){
                matrix[i][j] = array[count];        //Заполняем матрицу, по направлению слева направо
                if((j+1 < N-i)) count += P;         //изменяем индекс массива, на коэффициент P
                else count += K;                    //после
                if((j+1) < (N-i)) {         //Заполняем матрицу, по направлению сверху вниз
                    matrix[j+1][N - (i + 1)] = array[count];
                    count += P - 1;
                    matrix[N - (i+1)][N - (j + 2)] = array[count];// по направлению слева направо
                    if((j+2) < N-i) count += P - 1;
                    else count -= L;
                }
                if((j+2) < (N-i)) {                     //Заполняем матрицу снизу вверх
                    matrix[N - (j+2)][i] = array[count];
                    count -= K;
                }
            }
        }
        matrix[level][level] = array[count];        //Заполняем центральный элемент матрицы

        for(int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void task3(int N){

    }

    private boolean cheak(Stack stack, char ch){
        if ((char) stack.pop() == ch){
            return true;
        }
        else return false;
    }
}

