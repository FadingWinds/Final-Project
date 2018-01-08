package FinalProject.CalabashWar.Creatures;

//3rd Calabash Brother
public final class CB3 extends CalabashBrother {
    public CB3() {
        this.rank = Rank.values()[2];
        this.color = Color.values()[2];
        this.ult = ULTs.values()[2];
        //ULT buff
        this.HP += 300;
    }

}
