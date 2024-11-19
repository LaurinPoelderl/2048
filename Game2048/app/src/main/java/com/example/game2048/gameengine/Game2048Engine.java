package com.example.game2048.gameengine;

import androidx.collection.MutableIntList;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Game2048Engine {

    private List<List<Integer>> board;
    private Random random = new Random();

    public void init() {
        board = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            board.add(new LinkedList<>(Collections.nCopies(4, 0)));
        }

        spawnRandomTile();
        spawnRandomTile();
    }

    public void moveTop() {
        transposeBoard();
        boolean moved = false;
        for (List<Integer> row : board) {
            if (shiftAndMergeRow(row)) {
                moved = true;
            }
        }
        transposeBoard();
        if (moved) {
            spawnRandomTile();
        }
    }

    public void moveBottom() {
        transposeBoard();
        boolean moved = false;
        for (List<Integer> row : board) {
            Collections.reverse(row);
            if (shiftAndMergeRow(row)) {
                moved = true;
            }
            Collections.reverse(row);
        }
        transposeBoard();
        if (moved) {
            spawnRandomTile();
        }
    }

    public void moveLeft() {
        boolean moved = false;
        List<List<Integer>> newBoard = new LinkedList<>();
        for (List<Integer> row : board) {
            List<Integer> newRow = new LinkedList<>(row);
            if (shiftAndMergeRow(newRow)) {
                moved = true;
            }
            newBoard.add(newRow);
        }
        if (moved) {
            board = newBoard;
            spawnRandomTile();
        }
    }

    public void moveRight() {
        boolean moved = false;
        List<List<Integer>> newBoard = new LinkedList<>();
        for (List<Integer> row : board) {
            List<Integer> reversedRow = new LinkedList<>(row);
            Collections.reverse(reversedRow);
            if (shiftAndMergeRow(reversedRow)) {
                moved = true;
            }
            Collections.reverse(reversedRow);
            newBoard.add(reversedRow);
        }
        if (moved) {
            board = newBoard;
            spawnRandomTile();
        }
    }


    public List<List<Integer>> getBoard() {
        return board;
    }

    // Helper Methods
    private boolean shiftAndMergeRow(List<Integer> row) {
        boolean moved = false;
        // Remove zeros
        List<Integer> newRow = new LinkedList<>();
        for (int num : row) {
            if (num != 0) {
                newRow.add(num);
            }
        }

        // Merge adjacent equal elements
        for (int i = 0; i < newRow.size() - 1; i++) {
            if (newRow.get(i).equals(newRow.get(i + 1))) {
                newRow.set(i, newRow.get(i) * 2);
                newRow.set(i + 1, 0);
                i++; // Skip next element
                moved = true;
            }
        }

        // Remove zeros again
        List<Integer> finalRow = new LinkedList<>();
        for (int num : newRow) {
            if (num != 0) {
                finalRow.add(num);
            }
        }

        // Pad with zeros to maintain row size
        while (finalRow.size() < 4) {
            finalRow.add(0);
        }

        // Check if the row has changed
        if (!row.equals(finalRow)) {
            moved = true;
            // Update the original row
            for (int i = 0; i < 4; i++) {
                row.set(i, finalRow.get(i));
            }
        }

        return moved;
    }

    private void transposeBoard() {
        List<List<Integer>> transposed = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            List<Integer> newRow = new LinkedList<>();
            for (int j = 0; j < 4; j++) {
                newRow.add(board.get(j).get(i));
            }
            transposed.add(newRow);
        }
        board = transposed;
    }

    private void spawnRandomTile() {
        // Find empty positions
        List<int[]> emptyPositions = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board.get(i).get(j) == 0) {
                    emptyPositions.add(new int[]{i, j});
                }
            }
        }
        if (!emptyPositions.isEmpty()) {
            // Randomly select an empty position
            int[] pos = emptyPositions.get(random.nextInt(emptyPositions.size()));
            // Decide whether to place 2 or 4
            int value = random.nextDouble() < 0.9 ? 2 : 4;
            board.get(pos[0]).set(pos[1], value);
        }
    }
}
