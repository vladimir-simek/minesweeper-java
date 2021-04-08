package cz.educanet.minesweeper.logic;

public class Cells {

    private Cell[][] cells;
    private int amountOfMines;

    public int getAmountOfMines() {
        return amountOfMines;
    }

    public void setAmountOfMines(int amountOfMines) {
        this.amountOfMines = amountOfMines;
    }

    public Cells(int amountOfMines, int amountOfColumns, int amountOfRows) {
        this.cells = new Cell[amountOfColumns][amountOfRows];
        this.amountOfMines = amountOfMines;
        for (int i = 0; i < amountOfColumns; i++) {
            for (int j = 0; j < amountOfRows; j++) {
                this.cells[i][j] = new Cell();
            }
        }
    }

    public int getCellState(int i, int j) {
        return cells[i][j].getCellState();
    }

    public void setCellState(int i, int j, int stateID) {
        this.cells[i][j].setCellState(stateID);
    }

    public boolean getIsMine(int i, int j) {
        return cells[i][j].getIsMine();
    }

    public void setIsMine(int i, int j) {
        this.cells[i][j].setIsMine(true);
    }
}
