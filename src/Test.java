/*ребования:
        Метод умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b,
        a * b, a / b.Данные передаются в одну строку (смотрите пример)!
        Решения, в которых каждое число и арифмитеческая операция передаются с новой строки считаются неверными.
        Метод умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.
        Метод должен принимать на вход числа от 1 до 10 включительно, не более.
        На выходе числа не ограничиваются по величине и могут быть любыми.
        Метод умеет работать только с целыми числами.
        Метод умеет работать только с арабскими или римскими цифрами одновременно, при вводе пользователем строки
        вроде 3 + II метод должен выбросить исключение и прекратить свою работу.
        При вводе римских чисел, ответ должен быть выведен римскими цифрами, соответственно,
        при вводе арабских - ответ ожидается арабскими.
        При вводе пользователем неподходящих чисел метдод выбрасывает исключение и завершает свою работу.
        При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций,
        метод выбрасывает исключение и завершает свою работу
        Результатом операции деления является целое число, остаток отбрасывается.
        Результатом работы метода с арабскими числами могут быть отрицательные числа и ноль.
        Результатом работы метода с римскими числами могут быть только положительные числа,
        если результат работы меньше единицы, выбрасывается исключение*/


//Ты можешь добавлять свои импорты


//решение должно содержать данный класс
class Main {
    public static void main(String[] args) throws Exception {

        System.out.println( new  Main().calc("1 -10 "));
    }
    //Решение должно содержать данный метод
    public String calc(String prim) throws Exception {
        String[] s = prim.split("-|\\*|\\+|\\/");
        if (s.length != 2)
            throw new Exception("шото не так с количеством");
        String[] rim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII",
                "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI",
                "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII",
                "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII",
                "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII",
                "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        int ind = prim.lastIndexOf(s[1]);
        // какое действие
        char znak = prim.charAt(ind - 1);
        //удалили пробелы
        for (int i = 0; i < s.length; i++) {
            s[i] = s[i].trim();
        }
        int r=0;
        int g=0;
        int[] ints = new int[s.length];
        int a;
        for (int i = 0; i < s.length; i++) {
            a = revInt(s[i]);
            if (a > 0 && a <= 10){
                g++;
                ints[i] = a;}
            else {
                r++;
                a = revRim(s[i]);
                if (a > 0 && a <= 10)
                    ints[i] = a;
                else
                    throw new Exception("шот не так с цифрами");
            }
        }
        int rez =0;
        if(g>0 && r>0)
            throw new Exception("разный тип цифр");
        if (znak == '+') {
            rez = ints[0] + ints[1];
        } else if (znak == '-') {
            if (ints[0] <= ints[1] && r>0)
                throw new  Exception("отриц или ноль");
            rez = ints[0] - ints[1];
        } else if (znak == '*') {
            rez = ints[0] * ints[1];
        } else if (znak == '/') {
            rez = ints[0] / ints[1];
        }
        String otv  = null;
        if(r>0){
          otv= rim[rez-1];
        }
        else
         otv=Integer.toString(rez);

        return otv;
    }
    public static int revInt(String znach) {
        int a;
        try {
            a = Integer.parseInt(znach);
        } catch (Exception e) {
            a = -1;
        }
        return a;
    }
    public static int revRim(String znach) throws Exception {
        boolean b= true;
        String[] rim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" };
        int a = -1;
        for (int i = 0; i < rim.length; i++) {
            if (znach.equals(rim[i])) {
                a = i + 1;
                b=false;
                break;
            }
        }
        if(b){
            throw new Exception("большое число");}
        return a;
    }
}


