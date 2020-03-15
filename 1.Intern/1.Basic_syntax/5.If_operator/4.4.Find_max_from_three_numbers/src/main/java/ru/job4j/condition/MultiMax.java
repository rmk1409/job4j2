package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int result = first;
        if (second > third && second > first) {
            result = second;
        } else if (third > second && third > first) {
            result = third;
        }
        return result;
    }
}
