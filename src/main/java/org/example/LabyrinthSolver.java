package org.example;

import java.util.ArrayList;
import java.util.List;

public class LabyrinthSolver {
    private Labyrinth labyrinth;
    private int steps;
    private String result;

    public LabyrinthSolver(Labyrinth labyrinth) {
        this.labyrinth = labyrinth;
        steps = 0;
        result = null;

    }

    public boolean move(int layer, int row, int col){
        boolean done = false;

        if(labyrinth.isWalkable(layer, row, col)){

            labyrinth.markTried(layer, row, col);
            if(labyrinth.isSolved(layer, row, col)){
                done = true;
            }
            else{
                    done= move(layer - 1, row, col);// down
                if(!done)
                    done= move(layer, row-1, col); // south
                if(!done)
                    done= move(layer, row, col - 1);// west
                if(!done)
                    done= move(layer + 1, row, col); // up
                if(!done)
                    done= move(layer, row+1, col); // north
                if(!done)
                    done= move(layer, row, col + 1);// east
            }
            if(done){
                labyrinth.markPath(layer, row, col);
                steps++;
            }
        }
        return done;
    }
    public int getNumberOfSteps(){
        return steps -1;
    }



    public String solve() {
        int lStart = labyrinth.findIndexOfElementInGrid("S").get(0);
        int rStart = labyrinth.findIndexOfElementInGrid("S").get(1);
        int cStart = labyrinth.findIndexOfElementInGrid("S").get(2);

        if(move(lStart,rStart,cStart)){
            result = "Entkommen in " + getNumberOfSteps() + " Minute(n)!";
        }else{
            result = "gefangen :-(";
        }
        return result;
    }
}
