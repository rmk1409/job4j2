package ru.job4j.condition;

/**
 * Доработайте метод possibleDiv так, чтобы на консоль выводило строчку "This is negative numbers", если число number меньше чем 0.
 */
public class AlertDivByZero {
    public static void main(String[] args) {
        possibleDiv(4);
        possibleDiv(0);
        possibleDiv(-1);
    }

    public static void possibleDiv(int number) {
        if (number == 0) {
            System.out.println("Could not div by 0.");
        } else if (number < 0) {
            System.out.println("This is negative numbers");
        }
    }
}
