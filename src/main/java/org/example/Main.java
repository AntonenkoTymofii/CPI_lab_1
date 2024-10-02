package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int generations = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = scanner.next().toCharArray();
        }

        for (int gen = 0; gen < generations; gen++) {
            System.out.println("Generation " + (gen + 1) + ":");
            grid = nextGeneration(grid, n, m);
            printGrid(grid);
        }

        scanner.close();
    }

    public static char[][] nextGeneration(char[][] grid, int n, int m) {
        char[][] newGrid = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int liveNeighbors = countLiveNeighbors(grid, i, j, n, m);

                if (grid[i][j] == 'x') {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        newGrid[i][j] = '.';
                    } else {
                        newGrid[i][j] = 'x';
                    }
                } else {
                    if (liveNeighbors == 3) {
                        newGrid[i][j] = 'x';
                    } else {
                        newGrid[i][j] = '.';
                    }
                }
            }
        }
        return newGrid;
    }

    public static int countLiveNeighbors(char[][] grid, int row, int col, int n, int m) {
        int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1};
        int liveNeighbors = 0;

        for (int i = 0; i < 8; i++) {
            int newRow = (row + dRow[i] + n) % n;
            int newCol = (col + dCol[i] + m) % m;
            if (grid[newRow][newCol] == 'x') {
                liveNeighbors++;
            }
        }
        return liveNeighbors;
    }

    public static void printGrid(char[][] grid) {
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}