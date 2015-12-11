/*
 * Copyright (C) 2015 nuno
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package model;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author nuno
 */
public class Game {

    private ArrayList<Stack<Disc>> matrix;
    public static int NUMBERRODS = 3;
    public static int NUMBERDISCS = 3;
    public int playsNumber = 1;

    /**
     * void constructor. 
     * Initialize the rods and discs. 
     * Initialize the matrix of array.
     */
    public Game() {
        matrix = new ArrayList<>();
        this.newGame();
    }

    /**
     * Gives it back matrix.
     *
     * @return matrix game
     */
    public ArrayList<Stack<Disc>> getMatriz() {
        return matrix;
    }

    /**
     * Set matrix game.
     *
     * @param matriz
     */
    public void setMatriz(ArrayList<Stack<Disc>> matrix) {
        this.matrix = matrix;
    }

    /**
     * Gives number of plays made by player.
     *
     * @return plays played int
     */
    public int getPlaysNumber() {
        return playsNumber;
    }

    /**
     * Set number of plays.
     *
     * @param playsNumber
     */
    public void setPlaysNumber(int playsNumber) {
        this.playsNumber = playsNumber;
    }

    /**
     * Initialize the rods, and add to rods the disc.
     */
    public void newGame() {
        this.initializeRods();
        this.initializeDiscsGame();

    }

    /**
     * Initialize rods.
     */
    private void initializeRods() {
        for (int i = 0; i < Game.NUMBERRODS; i++) {
            this.matrix.add(new Stack<>());
        }
    }

    /**
     * Adds dics to rods.
     */
    private void initializeDiscsGame() {
        for (int i = Game.NUMBERDISCS; i > 0; i--) {
            this.matrix.get(0).push(new Disc(i));
        }
    }

    /**
     * Move disc, from source rod to destiny rod.
     *
     * @param indexRodSource
     * @param indexRodDestination
     * @throws Error if the movement is illegal.
     */
    public void moveDisk(int indexRodSource, int indexRodDestination) {
        indexRodDestination--;
        indexRodSource--;
        if (this.matrix.get(indexRodDestination).size() == 0) {
            this.matrix.get(indexRodDestination).push(this.matrix.get(indexRodSource).pop());
        } else {
            if (this.matrix.get(indexRodSource).peek().getDiameter() < this.matrix.get(indexRodDestination).peek().getDiameter()) {
                this.matrix.get(indexRodDestination).push(this.matrix.get(indexRodSource).pop());

            } else {
                throw new Error("Illegal movement!");
            }
        }

    }

    /**
     * State of object.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Matriz" + "matriz=" + matrix + '}';
    }

    /**
     * A better suit game string to user comprehension. Console game.
     *
     * @return String
     */
    public String gameToString() {
        String m = "State of discs:";
        m += "\nPlay number:" + this.getPlaysNumber();
        for (int i = 0; i < Game.getRodsNumber(); i++) {
            m += "\n Rod " + (i + 1) + matrix.get(i);
        }
        return m;
    }

    /**
     * Class method, to get number of rods.
     *
     * @return int
     */
    public static int getRodsNumber() {
        return NUMBERRODS;
    }

    /**
     * Class method, to set a different number of rods.
     *
     * @param rodsNumber
     */
    public static void setRodsNumber(int rodsNumber) {
        Game.NUMBERRODS = rodsNumber;
    }

    /**
     * Class method, to get number of discs.
     *
     * @return int
     */
    public static int getDiscsNumber() {
        return NUMBERDISCS;
    }

    /**
     * Class method, to set a different number of discs.
     *
     * @param discsNumber
     */
    public static void setDiscsNumber(int discsNumber) {
        Game.NUMBERDISCS = discsNumber;
    }

    /**
     * Add plays played by user.
     */
    public void incrementPlaysNumber() {
        this.playsNumber++;
    }

    /**
     * Verify if user have won.
     *
     * @return boolean
     */
    public boolean wonVerify() {
        if (this.matrix.get(Game.getRodsNumber() - 1).size() > 0) {
            if (this.matrix.get(Game.getRodsNumber() - 1).peek() != null) {
                return this.matrix.get(Game.getRodsNumber() - 1).size() > Game.getDiscsNumber() - 1;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }
}
