package org.example;

import java.util.Optional;

public class TicTacToe {
    private int[][] array = new int[3][3];
    private boolean isPlayerOne = true;
    private final int CROSS = 1;
    private final int ZERO = 2;
    private final int EMPTY_VALUE = 0;

    public void addMove(int x, int y) {
//        if (hasWinner()) {
//            System.out.println("Game over");
//            return;
//        }
        if ((x < 0 || x > 2) || (y < 0 || y > 2) || (array[x][y] != EMPTY_VALUE)) {
            System.out.println("Enter other number");
            return;
        }
        array[x][y] = (isPlayerOne) ? CROSS : ZERO;
        isPlayerOne = !isPlayerOne;
        if (hasWinner()) {
            System.out.println("Game over");
            return;
        }
        if(draw()){
            return;
        }
//        if (hasWinner()) {
//            if (isPlayerOne) {
//                System.out.println("Player two winner");
//            } else {
//                System.out.println("Player one winner");
//            }
//        }
    }

    public Optional<String> getWinner() {
        if (hasWinner()) {
            return isPlayerOne?Optional.of("Player two winner"):Optional.of("Player one winner");
        }
        return Optional.empty();
    }

    public boolean checkHorizontal() {
        for (int i = 0; i < array.length; i++) {
            int helper = 0;
            for (int j = 0; j < array[i].length - 1; j++) {
                if (array[i][j] == EMPTY_VALUE) {
                    continue;
                }
                if (array[i][j] == array[i][j + 1]) {
                    helper++;
                }
            }
            if (helper == array.length - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean checkVertical() {
        for (int i = 0; i < array.length; i++) {
            int helper = 0;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j][i] == EMPTY_VALUE) {
                    continue;
                }
                if (array[j][i] == array[j + 1][i]) {
                    helper++;
                }
            }
            if (helper == array.length - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean checkLeftDiagonal() {
        int helper = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i][i] == EMPTY_VALUE) {
                continue;
            }
            if (array[i][i] == array[i + 1][i + 1]) {
                helper++;
            }
        }
        if (helper == array.length - 1) {
            return true;
        }
        return false;
    }

    public boolean checkRightDiagonal() {
        int helper = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i][array.length - 1 - i] == EMPTY_VALUE) {
                return false;
            }
            if (array[i][array.length - 1 - i] == array[i + 1][array.length - 2 - i]) {
                helper++;
            }
        }
        if (helper == array.length - 1) {
            return true;
        }
        return false;
    }
    public boolean draw(){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                if(array[i][j]==EMPTY_VALUE){
                    return false;
                }
            }
        }
        return true;
    }

    //    public boolean checkRightDiagonal() {
//        int helper = 0;
//        int x = array.length - 1;
//        int y = 0;
//        while (x > 0) {
//            if (array[x][y] == EMPTY_VALUE) {
//                break;
//            }
//            if (array[x][y] == array[x - 1][y + 1]) {
//                helper++;
//            }
//            x--;
//            y++;
//        }
//        if (helper == array.length - 1) {
//            return true;
//        }
//        return false;
//    }
    public boolean hasWinner() {
        return checkHorizontal() || checkVertical() || checkLeftDiagonal() || checkRightDiagonal();
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == EMPTY_VALUE) {
                    result += "_";
                } else if (array[i][j] == CROSS) {
                    result += "X";
                } else {
                    result += "0";
                }
            }
            result += "\n";
        }
        return result;
    }
}
