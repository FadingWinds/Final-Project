package FinalProject.CalabashWar.Patterns;

public final class YuLin extends Pattern {
    public YuLin() {
        this.pt = PatternType.YULIN;
        this.row = 5;
        this.column = 4;
        this.isavl = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 2 && j != 2) {
                    this.isavl[i][j] = true;
                }
                if (j == 1) {
                    this.isavl[i][j] = true;
                }
                if (i == 3 && j == 2) {
                    this.isavl[i][j] = true;
                }
            }
        }
    }
}
