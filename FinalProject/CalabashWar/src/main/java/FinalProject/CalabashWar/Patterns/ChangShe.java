package FinalProject.CalabashWar.Patterns;

public final class ChangShe extends Pattern{
    public ChangShe() {
        this.pt = PatternType.CHANGSHE;
        this.row = 1;
        this.column = 8;
        this.isavl = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                this.isavl[i][j] = true;
            }
        }

    }
}
