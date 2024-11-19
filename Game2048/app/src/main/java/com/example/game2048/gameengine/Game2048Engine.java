package com.example.game2048.gameengine;

import androidx.collection.MutableIntList;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Game2048Engine {
    private List<List<Integer>> board = null;

    public void init() {
        board = new LinkedList<>(Collections.nCopies(4,new LinkedList<>(Collections.nCopies(4,0))));
        //TODO: getRandomStartValues
    }

    public List<List<Integer>> getBoard() {
        return board;
    }

    private void rotate90 (int arr[][])
    {
        transpose (arr);
        reverseRows (arr);
    }

    public void moveTop() {
        board.get(0).set(0,1);
        //TODO: shift90Degrees
        this.moveLeft();
        //TODO: shift-90Degrees
    }

    public void moveDown() {
        //TODO: shift-90Degrees
        this.moveLeft();
        //TODO: shift90Degrees
    }

    public void moveLeft() {

    }

    public void moveRight() {
        //TODO: shift180Degrees
        this.moveLeft();
        //TODO: shift180Degrees
    }
}
