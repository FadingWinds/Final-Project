package FinalProject.CalabashWar.Patterns;

public abstract class Pattern {
    protected PatternType pt;
    protected int row;
    protected int column;
    //avlnum represents the number of the available positions for creatures.
    protected boolean[][] isavl;

    public Pattern(){

    }

    public boolean getIsavl(int x, int y) {
        return isavl[x][y];
    }

    /*
    public void setRow(int row) {
        this.row = row;
    }
    public void setColumn(int column) {
        this.column = column;
    }
    */
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }


}
