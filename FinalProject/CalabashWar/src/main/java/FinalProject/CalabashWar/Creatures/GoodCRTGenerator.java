package FinalProject.CalabashWar.Creatures;

import FinalProject.CalabashWar.*;

import java.util.Random;

public class GoodCRTGenerator implements Generator<Creature> {
    private Class[] good = {CB1.class, CB2.class, CB3.class, CB4.class, CB5.class, CB6.class, CB7.class, Grandpa.class};
    private static Random r = new Random();

    @Override
    public Creature next() {
        try {
            return (Creature) good[r.nextInt(good.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
