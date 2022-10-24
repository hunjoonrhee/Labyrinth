package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LabyrinthSolverIntegrationTest {

    @Test
    void solve_ShouldReturn_NumberOfSteps_ToTheEnd_WhenAPathFound(){
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
        String actual = solver.solve();

        //THEN
        assertEquals("Entkommen in " + 5 + " Minute(n)!",actual);
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
        String actual = solver.solve();

        //THEN
        assertEquals("gefangen :-(",actual);
    }

}