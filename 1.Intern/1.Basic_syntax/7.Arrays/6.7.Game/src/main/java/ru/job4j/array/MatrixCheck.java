package ru.job4j.array;

/**
 * Игровое поле представляет собой массив, заполненный символами '_' (подчеркивание) и 'X' - крестик.
 * Цель игры - расположить крестики в линию на 5 элементов. Элементы X должны располагаться либо вертикально, либо горизонтально.
 * Ваша задача - написать метод, который будет проверять, находится ли на поле выигрышная ситуаци
 * <p>
 * Created by Roman Pogorelov on 17.03.2020
 */
public class MatrixCheck {
    public static boolean isWin(char[][] board) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 'X' && (monoHorizontal(board, i) || monoVertical(board, i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean monoVertical(char[][] board, int i) {
        boolean result = true;
        for (int j = 0; j < board.length; j++) {
            if (board[i][j] != 'X') {
                result = false;
                break;
            }
        }
        return result;
    }

    private static boolean monoHorizontal(char[][] board, int i) {
        boolean result = true;
        for (int j = 0; j < board.length; j++) {
            if (board[j][i] != 'X') {
                result = false;
                break;
            }
        }
        return result;
    }
}
