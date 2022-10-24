package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LabyrinthTest {

    @Test
    void findIndexOfElement_ShouldReturn_IndicesListOfGivenElement(){
        // GIVEN
        String[][][] grid = new String[1][4][5];
        grid[0][0][0] = "S";
        grid[0][0][1] = ".";
        grid[0][0][2] = ".";
        grid[0][0][3] = ".";
        grid[0][0][4] = ".";

        grid[0][1][0] = ".";
        grid[0][1][1] = "#";
        grid[0][1][2] = "#";
        grid[0][1][3] = "#";
        grid[0][1][4] = ".";

        grid[0][2][0] = ".";
        grid[0][2][1] = "#";
        grid[0][2][2] = "#";
        grid[0][2][3] = ".";
        grid[0][2][4] = ".";

        grid[0][3][0] = "#";
        grid[0][3][1] = "#";
        grid[0][3][2] = "#";
        grid[0][3][3] = ".";
        grid[0][3][4] = "#";
        Labyrinth labyrinth = new Labyrinth(grid);


        // THEN
        List<Integer> actual = labyrinth.findIndexOfElementInGrid("S");


        // WHEN
        List<Integer> expected = List.of(0,0,0);
        assertEquals(expected, actual);

    }

    @Test
    void isWalkable_ShouldReturn_FalseAtHash(){
        // GIVEN
        String[][][] grid = new String[1][4][5];
        grid[0][0][0] = "S";
        grid[0][0][1] = ".";
        grid[0][0][2] = ".";
        grid[0][0][3] = ".";
        grid[0][0][4] = ".";

        grid[0][1][0] = ".";
        grid[0][1][1] = "#";
        grid[0][1][2] = "#";
        grid[0][1][3] = "#";
        grid[0][1][4] = ".";

        grid[0][2][0] = ".";
        grid[0][2][1] = "#";
        grid[0][2][2] = "#";
        grid[0][2][3] = ".";
        grid[0][2][4] = ".";

        grid[0][3][0] = "#";
        grid[0][3][1] = "#";
        grid[0][3][2] = "#";
        grid[0][3][3] = ".";
        grid[0][3][4] = "#";
        Labyrinth labyrinth = new Labyrinth(grid);

        // WHEN
        boolean actual = labyrinth.isWalkable(0,1,1);

        // THEN
        assertFalse(actual);
    }
    @Test
    void isWalkable_ShouldReturn_TrueAtPointsThatAreNotHash(){
        // GIVEN
        String[][][] grid = new String[1][4][5];
        grid[0][0][0] = "S";
        grid[0][0][1] = ".";
        grid[0][0][2] = ".";
        grid[0][0][3] = ".";
        grid[0][0][4] = ".";

        grid[0][1][0] = ".";
        grid[0][1][1] = "#";
        grid[0][1][2] = "#";
        grid[0][1][3] = "#";
        grid[0][1][4] = ".";

        grid[0][2][0] = ".";
        grid[0][2][1] = "#";
        grid[0][2][2] = "#";
        grid[0][2][3] = ".";
        grid[0][2][4] = ".";

        grid[0][3][0] = "#";
        grid[0][3][1] = "#";
        grid[0][3][2] = "#";
        grid[0][3][3] = ".";
        grid[0][3][4] = "#";
        Labyrinth labyrinth = new Labyrinth(grid);

        // WHEN
        boolean actual = labyrinth.isWalkable(0,1,0);

        // THEN
        assertTrue(actual);
    }

    @Test
    void isSolved_ShouldReturn_TrueAtThePointE(){
        // GIVEN
        String[][][] grid = new String[1][4][5];
        grid[0][0][0] = "S";
        grid[0][0][1] = ".";
        grid[0][0][2] = ".";
        grid[0][0][3] = ".";
        grid[0][0][4] = ".";

        grid[0][1][0] = ".";
        grid[0][1][1] = "#";
        grid[0][1][2] = "#";
        grid[0][1][3] = "#";
        grid[0][1][4] = ".";

        grid[0][2][0] = ".";
        grid[0][2][1] = "#";
        grid[0][2][2] = "#";
        grid[0][2][3] = "E";
        grid[0][2][4] = ".";

        grid[0][3][0] = "#";
        grid[0][3][1] = "#";
        grid[0][3][2] = "#";
        grid[0][3][3] = ".";
        grid[0][3][4] = "#";
        Labyrinth labyrinth = new Labyrinth(grid);

        // WHEN
        List<Integer> indicesOfEnd = labyrinth.findIndexOfElementInGrid("E");
        boolean actual = labyrinth.isWalkable(indicesOfEnd.get(0),indicesOfEnd.get(1),indicesOfEnd.get(2));

        // THEN
        assertTrue(actual);
    }

}