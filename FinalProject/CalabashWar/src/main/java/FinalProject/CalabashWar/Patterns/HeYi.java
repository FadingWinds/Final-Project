package FinalProject.CalabashWar.Patterns;

public final class HeYi extends Pattern {
    public HeYi() {
        this.pt = PatternType.HEYI;
        this.row = 9;
        this.column = 5;
        this.isavl = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if ((i == j || i + j == 8) && j != 5) { //Assure the avlnum of every pattern is 8.
                    this.isavl[i][j] = true;
                }
            }
        }
    }
}
