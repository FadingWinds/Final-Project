package FinalProject.CalabashWar.Patterns;

public final class YanXing extends Pattern{
    public YanXing(){
        this.pt = PatternType.YANXING;
        this.row = 8;
        this.column = 8;
        this.isavl = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i + j == 7) {
                    this.isavl[i][j] = true;
                }
            }
        }
    }
}
