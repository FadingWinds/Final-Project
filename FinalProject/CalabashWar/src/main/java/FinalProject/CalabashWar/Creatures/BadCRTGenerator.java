package FinalProject.CalabashWar.Creatures;

import FinalProject.CalabashWar.Generator;

import java.util.Random;

public class BadCRTGenerator implements Generator<Creature> {
    private Class[] bad = {Scorpion.class,Snake.class,Underling.class};
    private static Random r = new Random();

    public Creature next() {
        try{
            return (Creature) bad[r.nextInt(bad.length)].newInstance();
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }
}
