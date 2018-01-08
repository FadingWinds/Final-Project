package FinalProject.CalabashWar.Patterns;

public final class HengE extends Pattern {
    public HengE(){
        this.pt = PatternType.HENGE;
        this.row = 2;
        this.column = 8;
        this.isavl = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if ((i + j) % 2 == 0) {
                    this.isavl[i][j] = true;
                }
            }
        }
    }

}
