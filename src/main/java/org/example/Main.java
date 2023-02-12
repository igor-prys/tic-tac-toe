package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe game=new TicTacToe();
        Scanner scan=new Scanner(System.in);
        while (!game.hasWinner()){
            System.out.println(game);
            System.out.println("Введите координаты");
            int x=scan.nextInt();
            int y=scan.nextInt();
            game.addMove(x,y);
        }
        System.out.println(game.getWinner().get());



    }
}