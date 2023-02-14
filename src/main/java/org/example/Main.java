package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scan = new Scanner(System.in);
        while (!game.draw()&&!game.hasWinner()) {
            System.out.println(game);
            System.out.println("Введите координаты");
            int x = scan.nextInt();
            int y = scan.nextInt();
            game.addMove(x, y);
        }
        if (game.getWinner().isPresent()) {
            System.out.println(game.getWinner().get());
        }
        else{
            System.out.println("It is draw");
        }
    }
}