import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InputExeptions {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите математическое выражение");
        String str = sc.nextLine();
        System.out.println(calc(str));
    }

    public static String calc(String input) throws InputExeptions {
        checkOut(input);
        String[] arr = input.split(" ");
        boolean is_roman = false;
        int numb_1 = 0;
        int numb_2 = 0;
        int answer;
        String romanNumbs = "IIIVIIIX";
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        int isRoman1 = romanNumbs.indexOf(arr[0]);// проверяем является ли цифра 1 римским числом
        int isRoman2 = romanNumbs.indexOf(arr[2]);// проверяем является ли цифра 2 римским числом
        //if (isRoman == -1) { System.out.print("не число");
        if (isRoman1 != -1 && isRoman2 != -1) {
            is_roman = true;
            for (int i = 1; i < 11; i++) {
                if (roman[i].equals(arr[0])) {
                    numb_1 = i;
                }
                if (roman[i].equals(arr[2])) {
                    numb_2 = i;
                }
            }
        } else {
            try {
                numb_1 = Integer.parseInt(arr[0]);
                if (isRoman2 != -1) throw new InputExeptions("используются одновременно разные системы счисления");
                if (numb_1 < 1 || numb_1 > 10)
                    throw new InputExeptions("Калькулятор может принимать на вход числа от 1 до 10");

            } catch (NumberFormatException e) {
                if (isRoman1 != -1)
                    throw new InputExeptions("используются одновременно разные системы счисления");
                else
                    throw new InputExeptions("Первый опреранд не является необходимым числом");
            }
            try {
                numb_2 = Integer.parseInt(arr[2]);
                if (isRoman1 != -1) throw new InputExeptions("используются одновременно разные системы счисления");
                if (numb_2 < 1 || numb_2 > 10)
                    throw new InputExeptions("Калькулятор может принимать на вход числа от 1 до 10");
            } catch (NumberFormatException e) {
                throw new InputExeptions("Второй опреранд не является необходимым числом");
            }
        }

        switch (arr[1]) {
            case ("+") -> answer = numb_1 + numb_2;
            case ("-") -> {
                answer = numb_1 - numb_2;
                if (numb_2 >= numb_1 && is_roman) {
                    throw new InputExeptions("Результатом работы калькулятора с римскими числами могут быть только положительные числа");
                }
            }
            case ("*") -> answer = numb_1 * numb_2;
            case ("/") -> answer = numb_1 / numb_2;
            default -> throw new InputExeptions("неверный оператор, калькулятор допускает использование +, -, *, /");
        }
        return is_roman ? roman[answer] : Integer.toString(answer);

    }

    public static void checkOut(String string) throws InputExeptions {
        String numbs = string.replace(" ", "");
        String[] arrStr = numbs.split("[+-/*]");
        String romanNumbs = "IIIVIIIX";
        if (arrStr.length > 2)
            throw new InputExeptions("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)"); // исключение
        if (arrStr.length == 1) throw new InputExeptions(" не является математической операцией");

    }

}






