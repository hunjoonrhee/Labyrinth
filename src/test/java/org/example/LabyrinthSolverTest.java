package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LabyrinthSolverTest {

    @Test
    void move_ShouldReturn_NumberOfSteps_ToTheEnd_WhenAPathFound(){
        // GIVEN
        String[][][] grid = new String[1][2][5];
        grid[0][0][0] = "S";
        grid[0][0][1] = ".";
        grid[0][0][2] = ".";
        grid[0][0][3] = ".";
        grid[0][0][4] = ".";

        grid[0][1][0] = ".";
        grid[0][1][1] = "#";
        grid[0][1][2] = "#";
        grid[0][1][3] = "#";
        grid[0][1][4] = "E";

        // WHEN
        Labyrinth labyrinth = new Labyrinth(grid);
        LabyrinthSolver solver = new LabyrinthSolver(labyrinth);
        int actual = 0;
        if(solver.move(0,0,0)){
           actual = solver.getTime();
        }else{
            System.out.println("gefangen :-(");
        }

        //THEN
        assertEquals(5,actual);
    }

    @Test
    void move_ShouldReturn_GefangenText_WhenNoPathFound(){
        // GIVEN
        String[][][] grid = new String[1][3][3];
        grid[0][0][0] = "S";
        grid[0][0][1] = "#";
        grid[0][0][2] = "#";

        grid[0][1][0] = "#";
        grid[0][1][1] = "E";
        grid[0][1][2] = "#";

        grid[0][2][0] = "#";
        grid[0][2][1] = "#";
        grid[0][2][2] = "#";


        // WHEN
        Labyrinth labyrinth = new Labyrinth(grid);
        LabyrinthSolver solver = new LabyrinthSolver(labyrinth);
        String actual = null;
        if(!solver.move(0,0,0)){
            actual = "gefangen :-(";
        }

        //THEN
        assertEquals("gefangen :-(",actual);
    }

}