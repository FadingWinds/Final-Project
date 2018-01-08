package FinalProject.CalabashWar.Patterns;

public final class FengShi extends Pattern {
    public FengShi() {
        this.pt = PatternType.FENGSHI;
        this.row = 5;
        this.column = 4;
        this.isavl = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 2) {
                    this.isavl[i][j] = true;
                }
                if ((i == 0 || i == 4) && j == 1 ) {
                    this.isavl[i][j] = true;
                }
                if (j == 2 && i != 0 && i != 4) {
                    this.isavl[i][j] = true;
                }
            }
        }

    }
}
