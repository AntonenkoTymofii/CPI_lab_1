package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void testNextGenerationBlockPattern() {
        char[][] initialGrid = {
                {'.', '.', '.', '.', '.'},
                {'.', 'x', 'x', '.', '.'},
                {'.', 'x', 'x', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'}
        };

        char[][] expectedGrid = {
                {'.', '.', '.', '.', '.'},
                {'.', 'x', 'x', '.', '.'},
                {'.', 'x', 'x', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'}
        };

        char[][] nextGrid = Main.nextGeneration(initialGrid, 5, 5);
        assertArrayEquals(expectedGrid, nextGrid);
    }

    @Test
    public void testNextGenerationBlinkerPattern() {
        char[][] initialGrid = {
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', 'x', 'x', 'x', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'}
        };

        char[][] expectedGrid = {
                {'.', '.', '.', '.', '.'},
                {'.', '.', 'x', '.', '.'},
                {'.', '.', 'x', '.', '.'},
                {'.', '.', 'x', '.', '.'},
                {'.', '.', '.', '.', '.'}
        };

        char[][] nextGrid = Main.nextGeneration(initialGrid, 5, 5);
        assertArrayEquals(expectedGrid, nextGrid);
    }

    @Test
    public void testNextGenerationEmptyGrid() {
        char[][] initialGrid = {
                {'.', '.', '.', '.'},
                {'.', '.', '.', '.'},
                {'.', '.', '.', '.'},
                {'.', '.', '.', '.'}
        };

        char[][] expectedGrid = {
                {'.', '.', '.', '.'},
                {'.', '.', '.', '.'},
                {'.', '.', '.', '.'},
                {'.', '.', '.', '.'}
        };

        char[][] nextGrid = Main.nextGeneration(initialGrid, 4, 4);
        assertArrayEquals(expectedGrid, nextGrid);
    }

    @Test
    public void testCountLiveNeighbors() {
        char[][] grid = {
                {'.', '.', '.', '.'},
                {'.', 'x', 'x', '.'},
                {'.', 'x', '.', '.'},
                {'.', '.', '.', '.'}
        };

        int liveNeighbors = Main.countLiveNeighbors(grid, 1, 1, 4, 4);
        assertEquals(2, liveNeighbors);

        liveNeighbors = Main.countLiveNeighbors(grid, 1, 2, 4, 4);
        assertEquals(2, liveNeighbors);

        liveNeighbors = Main.countLiveNeighbors(grid, 2, 1, 4, 4);
        assertEquals(2, liveNeighbors);

        liveNeighbors = Main.countLiveNeighbors(grid, 0, 0, 4, 4);
        assertEquals(1, liveNeighbors);
    }

    @Test
    public void testToroidalWrapping() {
        char[][] initialGrid = {
                {'x', '.', '.'},
                {'.', '.', '.'},
                {'.', '.', 'x'}
        };

        // Враховуючи замкненість поля, ці "x" повинні взаємодіяти
        char[][] expectedGrid = {
                {'.', '.', '.'},
                {'.', '.', '.'},
                {'.', '.', '.'}
        };

        char[][] nextGrid = Main.nextGeneration(initialGrid, 3, 3);
        assertArrayEquals(expectedGrid, nextGrid);
    }

    @Test
    public void testOverpopulationDeath() {
        char[][] initialGrid = {
                {'x', 'x', 'x'},
                {'x', 'x', 'x'},
                {'x', 'x', 'x'}
        };

        char[][] expectedGrid = {
                {'.', '.', '.'},
                {'.', '.', '.'},
                {'.', '.', '.'}
        };

        char[][] nextGrid = Main.nextGeneration(initialGrid, 3, 3);
        assertArrayEquals(expectedGrid, nextGrid);
    }
}