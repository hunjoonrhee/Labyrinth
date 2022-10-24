package org.example;

public class LabyrinthSolver {
    private Labyrinth labyrinth;
    private int time;

    public LabyrinthSolver(Labyrinth labyrinth) {
        this.labyrinth = labyrinth;
        time = 0;
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
                time++;
            }
        }
        return done;
    }
    public int getTime(){
        return time-1;
    }
}
