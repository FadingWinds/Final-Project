package FinalProject.CalabashWar.Patterns;

public final class YanYue extends Pattern {
    public YanYue() {
        this.pt = PatternType.YANYUE;
        this.row = 6;
        this.column = 3;
        this.isavl = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (j == 0 && (i == 2 || i == 3)) {
                    this.isavl[i][j] = true;
                }
                if (j == 1 && i != 0 && i != 5){
                    this.isavl[i][j] = true;
                }
                if (j == 2 && (i == 0 || i == 5)){
                    this.isavl[i][j] = true;
                }
            }
        }
    }
}
