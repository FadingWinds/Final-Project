package FinalProject.CalabashWar.Patterns;

import FinalProject.CalabashWar.*;

import java.util.Random;

public class PatternGenerator implements Generator<Pattern> {
    private Class[] PT = {ChangShe.class, HeYi.class, YanXing.class, HengE.class, YuLin.class, FangYuan.class, YanYue.class, FengShi.class};
    private static Random r = new Random();

    @Override
    public Pattern next() {
        try {
            return (Pattern) PT[r.nextInt(PT.length)].newInstance();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
