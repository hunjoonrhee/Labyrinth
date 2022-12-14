package org.example;

import java.util.ArrayList;
import java.util.List;

public class Labyrinth {

    private final String OPEN = ".";
    private final String START = "S";
    private final String END = "E";
    private final String PATH = "o";
    private final String TRIED = "-";
    private String[][][] grid;
    private int endLayer, endRow, endColumn;

    public Labyrinth(String[][][] grid) {
        this.grid = grid;
        endLayer = grid.length;
        endRow = grid[endLayer-1].length;
        endColumn = grid[endLayer-1][endRow-1].length;
    }

    public boolean isSolved(int layer, int row, int col){
        return (layer == endLayer-1 && row == endRow-1 && col == endColumn-1);
    }

    public boolean isWalkable(int layer, int row, int col){
        boolean result = false;
        if(layer >=0 && layer < grid.length &&
        row >=0 && row<grid[layer].length &&
        col >=0 && col<grid[layer][row].length)
        {
            if(grid[layer][row][col].equals(OPEN)||
                    grid[layer][row][col].equals(START)||
                    grid[layer][row][col].equals(END))
            {
                result = true;
            }
        }
        return result;
    }

    public List<Integer> findIndexOfElementInGrid(String element){
        List<Integer> indices = new ArrayList<>();
        for(int l=0;l<endLayer;l++){
            for(int r=0;r<endRow;r++){
                for(int c=0;c<endColumn;c++){
                    if(grid[l][r][c].equals(element)){
                        indices.add(l);
                        indices.add(r);
                        indices.add(c);
                        break;
                    }
                }
            }
        }
        return indices;
    }

    public void markPath(int layer, int row, int col){
        grid[layer][row][col] = PATH;
    }

    public void markTried(int layer, int row, int col){
        grid[layer][row][col] = TRIED;
    }
}
