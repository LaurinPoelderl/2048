package com.example.game2048.gameengine;

import androidx.collection.MutableIntList;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Game2048Engine {
    private List<List<Integer>> board = null;

    public Game2048Engine() {
        init();
    }

    public void init() {
        board = new LinkedList<>(Collections.nCopies(4,new LinkedList<>(Collections.nCopies(4,0))));
        //TODO: getRandomStartValues
    }

    public List<List<Integer>> getBoard() {
        return board;
    }

    private void rotate90 ()
    {
        transpose ();
        reverseRows ();
    }

    private void reverseRows() {
        //TODO: CheckWidthAndHeightEqual
        int n = board.size();
        for (int i = 0; i < board.size(); i++){
            for (int j = 0; j < board.size() / 2; j++){
                int temp = board.get(i).get(j);
                board.get(i).set(j, board.get(i).get(n - j - 1));
                board.get(i).set(n - j - 1, temp);
            }
        }
    }

    private void transpose() {
        //TODO: CheckWidthAndHeightEqual
        for (int i = 0; i < board.size(); i++) {
            for (int j = i; j < board.get(0).size(); j++) {
                int temp = board.get(j).get(i);
                board.get(j).set(i, board.get(i).get(j));
                board.get(i).set(j, temp);
            }
        }
    }

    public void moveTop() {
        board.get(0).set(0,1);
        rotate90();
        this.moveLeft();
        rotate90();
        rotate90();
        rotate90();
    }

    public void moveDown() {
        rotate90();
        rotate90();
        rotate90();
        this.moveLeft();
        rotate90();
    }

    public void moveLeft() {

    }

    public void moveRight() {
        rotate90();
        rotate90();
        this.moveLeft();
        rotate90();
        rotate90();
    }
}
