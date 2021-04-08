package cz.educanet.minesweeper.logic;

public class Cell {

    private int cellState = 0;
    private boolean isMine = false;

    /*
     * 0 - Hidden
     * 1 - Visible
     * 2 - Flag
     * 3 - Question mark
     */

    public int getCellState() {
        return cellState;
    }

    public void setCellState(int cellState) {
        this.cellState = cellState;
    }

    public boolean getIsMine() {
        return isMine;
    }

    public void setIsMine(boolean isMine) {
        this.isMine = isMine;
    }
}
