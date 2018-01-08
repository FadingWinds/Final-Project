package FinalProject.CalabashWar.Creatures;

//1st Calabash Brother
public final class CB1 extends CalabashBrother {

    public CB1() {
        this.rank = Rank.values()[0];
        this.color = Color.values()[0];
        this.ult = ULTs.values()[0];
        //ULT buff
        this.minATK += 50;
        this.maxATK += 50;
    }


}
