/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import java.util.*;
import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author dunsom1
 */
public class GOLTest {

    public GOLTest() {
    }

    /**
     * Test of boardToString method, of class GOL.
     */
    @Test
    public void testBoardToString() {
        boolean[][] board = {
            {false, false, false, false, false, false, true, false},
            {true, true, true, false, false, false, true, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, true, true, false, false, false},
            {false, false, false, true, true, false, false, false}
        };
        int xsize = 8;
        int ysize = 6;
        assertEquals(GOL.boardToString(board, xsize, ysize), "      * \n***   * \n        \n        \n   **   \n   **   \n");
    }

    /**
     * Test of strToBoolMatrix method, of class GOL.
     */
    @Test
    public void testStrToBoolMatrix() {
        String input = "000000101110001000000010000000000001100000011000";
        boolean[][] board = {
            {false, false, false, false, false, false, true, false},
            {true, true, true, false, false, false, true, false},
            {false, false, false, false, false, false, true, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, true, true, false, false, false},
            {false, false, false, true, true, false, false, false}
        };
        int xsize = 8;
        int ysize = 6;
        for (int i = 0; i < ysize; i++) {
            assertTrue(Arrays.equals(GOL.strToBoolMatrix(input, xsize, ysize)[i], board[i]));
        }
    }

    /**
     * Test of getNeighborCount method, of class GOL.
     */
    @Test
    public void testGetNeighborCount() {
        boolean[][] board = {
            {false, false, false, false, false, false, true, false},
            {true, true, true, false, false, false, true, false},
            {false, false, false, false, false, false, true, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, true, true, false, false, false},
            {false, false, false, true, true, false, false, false}
        };
        int xsize = 8;
        int ysize = 6;
        int x = 0;
        int y = 0;
        assertEquals(GOL.getNeighborCount(board, x, y, xsize, ysize), 2);
    }

    /**
     * Test of getDot method, of class GOL.
     */
    @Test
    public void testGetDot() {
        boolean[][] board = {
            {false, false, false, false, false, false, true, false},
            {true, true, true, false, false, false, true, false},
            {false, false, false, false, false, false, true, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, true, true, false, false, false},
            {false, false, false, true, true, false, false, false}
        };
        int xsize = 8;
        int ysize = 6;
        int x = 0;
        int y = 0;
        assertEquals(GOL.getDot(board, x, y, xsize, ysize), false);
        x = 1;
        assertEquals(GOL.getDot(board, x, y, xsize, ysize), true);
    }

}
