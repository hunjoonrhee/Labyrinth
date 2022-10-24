package org.example;

import org.example.model.GridLabyrinth;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("L:");
        int L = scanner.nextInt();
        System.out.println("R:");
        int R = scanner.nextInt();
        System.out.println("C:");
        int C = scanner.nextInt();

        String[][][] grid = new String[L][R][C];

        for(int layer=0;layer<L;layer++){
            for(int row=0;row<R;row++){
                grid = ScanRow(scanner,grid,layer,row,C);

            }
        }

        Labyrinth labyrinth = new Labyrinth(grid);

        List<Integer> indicesOfStart = labyrinth.findIndexOfElementInGrid("S");
        int lStart =indicesOfStart.get(0);
        int rStart =indicesOfStart.get(1);
        int cStart =indicesOfStart.get(2);
        LabyrinthSolver solver = new LabyrinthSolver(labyrinth);


        if(solver.move(lStart,rStart,cStart)){
            System.out.println(solver.getTime());
        }else{
            System.out.println("gefangen :-(");
        }

        System.out.println(labyrinth);



    }

    public static String[][][] ScanRow(Scanner scanner,String[][][] grid,
                          int currentLayer,int currentRow,
                          int numberOfColumns){
        String gridRow = scanner.next();// S....
        if(gridRow.length()!=numberOfColumns){
            throw new RuntimeException("Ungültige Spaltenzahl: Eine Zeile muss genau " + numberOfColumns + " Spalten haben!");
        }else{
            char[] charArray = gridRow.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                grid[currentLayer][currentRow][i] = String.valueOf(c);
            }
        }
        return grid;
    }

}