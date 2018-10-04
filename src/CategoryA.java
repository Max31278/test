public class CategoryA {
    public void task1(int[] osX, int[] osY){

    }

    public void task2(int[][] matrix){
        int sum = 0;            // итоговая сумма разности диагоналей матрицы
        int N = matrix.length;  // запоминаем размер матрицы
        for (int i=0; i < N; i++){
            sum+= matrix[i][i] - matrix[N-1-i][i];  //К результату прибавляем разность первых чисел в диагоналях, которые находятся в одном столбце
        }
        System.out.print("Итог = " + sum + "\n");
    }

    public void task3(int N){
        for (int i = 0; i < N; i++){
            int count = i +1;       // определяем количество необходимых символов в строке
            if (count < N) System.out.print(String.format("%"+(N - count) +"s",""));    // заполняем пробелами строку, чтобы получить лестницу с подъемом вверх
            System.out.println(String.format("%"+ count +"s", "").replace(' ', '#')); // выводим символы
        }
    }

    public void task4(int[] mass, int K){
        int count = 0;  // количество пар
        for(int i = 0; i < mass.length; i++){       //перебираем все пары чисел
            for (int j = i+1; j < mass.length; j++){
                if (((mass[i] + mass[j])% K) == 0) count++; // если остаток от деления равен 0, то увеличиваем счетчик на 1
            }
        }
        System.out.printf("Количество пар чисел = " + count + "\t");
    }

    public void task5(){

    }
}
