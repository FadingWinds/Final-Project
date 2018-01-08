package FinalProject.CalabashWar.Patterns;

public final class FangYuan extends Pattern{
    public FangYuan(){
        this.pt = PatternType.FANGYUAN;
        this.row = 5;
        this.column = 5;
        this.isavl = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i <= 2 && (i + j == 2 || j - i == 2)) {
                    this.isavl[i][j] = true;
                }
                else if(i > 2 && (i - j == 2 || i + j == 6)){
                    this.isavl[i][j] = true;
                }
            }
        }
    }
}
