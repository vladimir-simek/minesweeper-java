package cz.educanet.minesweeper.logic;

public class Minesweeper {

    private final int rowsCount;
    private final int columnsCount;
    private Cells cells;
    private final int bombCount;
    private boolean loser = false;

    private int x;
    private int y;

    public Minesweeper(int rows, int columns, int bombCount) {
        this.rowsCount = rows;
        this.columnsCount = columns;
        this.bombCount = bombCount;
        this.cells = new Cells(this.bombCount,this.columnsCount, this.rowsCount);
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
    public int getField(int x, int y) {
        return this.cells.getCellState(x,y);
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
    public void toggleFieldState(int x, int y) {
        int cellState = cells.getCellState(x,y);

        if (cellState == 0) {
            cells.setCellState(x,y,2);
        } else if (cellState == 2) {
            cells.setCellState(x,y,3);
        } else if (cellState == 3) {
            cells.setCellState(x,y,0);
        }
    }

    /**
     * Reveals the field and all fields adjacent (with 0 adjacent bombs) and all fields adjacent to the adjacent fields... ect.
     *
     * @param x X
     * @param y Y
     */
    public void reveal(int x, int y) {
        this.x = x;
        this.y = y;
        if (isBombOnPosition(x,y)) loser = true;
        int cellState = cells.getCellState(x,y);
        if (cellState == 0) {
            cells.setCellState(x,y,1);
        }
    }

    /**
     * Returns the amount of adjacent bombs
     *
     * @param x X
     * @param y Y
     * @return number of adjacent bombs
     */
    public int getAdjacentBombCount(int x, int y) {
        return 0;
    }

    /**
     * Checks if there is a bomb on the current position
     *
     * @param x X
     * @param y Y
     * @return true if bomb on position
     */
    public boolean isBombOnPosition(int x, int y) {
        return cells.getIsMine(x, y);
    }

    /**
     * Returns the amount of bombs on the field
     *
     * @return bomb count
     */
    public int getBombCount() {
        return this.bombCount;
    }

    /**
     * total bombs - number of flags
     *
     * @return remaining bomb count
     */
    public int getRemainingBombCount() {
        return 0;
    }

    /**
     * returns true if every flag is on a bomb, else false
     *
     * @return if player won
     */
    public boolean didWin() {
        return false;
    }

    /**
     * returns true if player revealed a bomb, else false
     *
     * @return if player lost
     */
    public boolean didLoose() {
        return this.loser;
    }

    public int getRows() {
        return rowsCount;
    }

    public int getColumns() {
        return columnsCount;
    }

}
