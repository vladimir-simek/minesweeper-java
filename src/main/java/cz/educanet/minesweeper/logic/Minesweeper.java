package cz.educanet.minesweeper.logic;

public class Minesweeper {

    private final int rowsCount;
    private final int columnsCount;
    private Cells cells;
    private final int bombCount;
    private boolean loser = false;
    private boolean winner = false;

    private int x;
    private int y;
    //done
    public Minesweeper(int rows, int columns, int bombCount) {
        this.rowsCount = rows;
        this.columnsCount = columns;
        this.bombCount = bombCount;
        this.cells = new Cells(this.bombCount, this.columnsCount, this.rowsCount);
    }

    /**
     * 0 - Hidden
     * 1 - Visible
     * 2 - Flag
     * 3 - Question mark
     *
     * @param x X
     * @param y Y
     * @return field type
     */
    //done
    public int getField(int x, int y) {
        return this.cells.getCellState(x, y);
    }

    /**
     * Toggles the field state, ie.
     * 0 -> 1,
     * 1 -> 2,
     * 2 -> 3 and
     * 3 -> 0
     *
     * @param x X
     * @param y Y
     */
    //done
    public void toggleFieldState(int x, int y) {
        int cellState = cells.getCellState(x, y);

        if (cellState == 0) {
            cells.setCellState(x, y, 2);
        } else if (cellState == 2) {
            cells.setCellState(x, y, 3);
        } else if (cellState == 3) {
            cells.setCellState(x, y, 0);
        }
    }

    /**
     * Reveals the field and all fields adjacent (with 0 adjacent bombs) and all fields adjacent to the adjacent fields... ect.
     *
     * @param x X
     * @param y Y
     */
    //done
    public void reveal(int x, int y) {
        if (cells.getCellState(x,y) == 2) return;
        if (isBombOnPosition(x, y)) loser = true;
        else {
            cells.setCellState(x, y, 1);
            if (getAdjacentBombCount(x, y) == 0) {
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        int xb = x + i;
                        int yb = y + j;
                        if (!(xb <= -1 || yb <= -1 || xb > getColumns() - 1 || yb > getRows()-1)) {
                            if (cells.getCellState(xb,yb) != 1 && !cells.getIsMine(xb,yb)) {
                                reveal(xb,yb);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Returns the amount of adjacent bombs
     *
     * @param x X
     * @param y Y
     * @return number of adjacent bombs
     */
    //done
    public int getAdjacentBombCount(int x, int y) {
        int adjacentBombCount = 0;

        try {
            if (cells.getIsMine(x - 1, y)) {
                adjacentBombCount++;
                //left
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bound pico!!!!!!!!");
        }

        try {
            if (cells.getIsMine(x + 1, y)) {
                adjacentBombCount++;
                //right
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bound pico!!!!!!!!");;
        }
        try {
            if (cells.getIsMine(x, y + 1)) {
                adjacentBombCount++;
                //top
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bound pico!!!!!!!!");;
        }
        try {
            if (cells.getIsMine(x, y - 1)) {
                adjacentBombCount++;
                //down
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bound pico!!!!!!!!");;
        }
        try {
            if (cells.getIsMine(x - 1, y - 1)) {
                adjacentBombCount++;
                //left down
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bound pico!!!!!!!!");;
        }
        try {
            if (cells.getIsMine(x - 1, y + 1)) {
                adjacentBombCount++;
                //left top
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bound pico!!!!!!!!");;
        }
        try {
            if (cells.getIsMine(x + 1, y - 1)) {
                adjacentBombCount++;
                //right bottom
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bound pico!!!!!!!!");;
        }
        try {
            if (cells.getIsMine(x + 1, y + 1)) {
                adjacentBombCount++;
                //right top
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bound pico!!!!!!!!");;
        }

        return adjacentBombCount;
    }

    /**
     * Checks if there is a bomb on the current position
     *
     * @param x X
     * @param y Y
     * @return true if bomb on position
     */
    //done
    public boolean isBombOnPosition(int x, int y) {
        return cells.getIsMine(x, y);
    }

    /**
     * Returns the amount of bombs on the field
     *
     * @return bomb count
     */
    //done
    public int getBombCount() {
        return this.bombCount;
    }

    /**
     * total bombs - number of flags
     *
     * @return remaining bomb count
     */
    //done
    public int getRemainingBombCount() {
        return cells.getAmountOfMines() - cells.getAmountOfFlags();
    }

    /**
     * returns true if every flag is on a bomb, else false
     *
     * @return if player won
     */
    //done
    public boolean didWin() {
        return winner;
    }

    /**
     * returns true if player revealed a bomb, else false
     *
     * @return if player lost
     */
    //done
    public boolean didLoose() {
        return this.loser;
    }

    //done
    public int getRows() {
        return rowsCount;
    }

    //done
    public int getColumns() {
        return columnsCount;
    }

}
