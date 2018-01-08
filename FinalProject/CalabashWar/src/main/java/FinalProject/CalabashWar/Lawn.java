package FinalProject.CalabashWar;

import FinalProject.CalabashWar.Creatures.Creature;
import FinalProject.CalabashWar.Creatures.*;
import FinalProject.CalabashWar.Patterns.*;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.*;

//Where the war takes place
//Good group will stand in the left part, bad group will stand in the right part
public class Lawn<LP extends Pattern, RP extends Pattern> extends JPanel implements Runnable {
    private static final int row = 15;
    private static final int column = 20;
    private static final int CRTnumperside = 8;
    private static ConcurrentHashMap<Point, Creature> Field;
    private ExecutorService exec;
    public LP LeftPattern;
    public RP RightPattern;

    public Lawn(LP lp, RP rp) {
        Field = new ConcurrentHashMap<Point,Creature>();
        this.LeftPattern = lp;
        this.RightPattern = rp;
    }


    public static ConcurrentHashMap<Point, Creature> getField() {
        return Field;
    }

    public static int getColumn() {
        return column;
    }

    public static int getRow() {
        return row;
    }

    //Initialize the lawn.
    public void Init() {
        //Initialize left side
        //Get good creatures together
        HashSet<Creature> LeftC = new HashSet<Creature>();
        GoodCRTGenerator geng = new GoodCRTGenerator();
        while (LeftC.size() < this.CRTnumperside) {
            Creature c = geng.next();
            LeftC.add(c);
        }
        //Put good creatures on field
        int spaceg = (int) Math.floor((this.row - LeftPattern.getRow()) / 2);
        Iterator<Creature> itg = LeftC.iterator();
        for (int i = 0; i < LeftPattern.getRow(); i++) {
            for (int j = 0; j < LeftPattern.getColumn(); j++) {
                if (LeftPattern.getIsavl(i, j) && itg.hasNext()) {
                    Point p = new Point();
                    Creature c = itg.next();
                    p.setX(j);
                    p.setY(i + spaceg);
                    c.setX(j);
                    c.setY(i + spaceg);
                    Field.put(p, c);
                }
            }
        }

        //Initialize right side
        //Get bad creatures together
        HashSet<Creature> RightC = new HashSet<Creature>();
        BadCRTGenerator genb = new BadCRTGenerator();
        while (RightC.size() < this.CRTnumperside) {
            Creature c = genb.next();
            RightC.add(c);
        }
        //Put bad creatures on field
        Iterator<Creature> itb = RightC.iterator();
        int spaceb = (int) Math.floor((this.row - LeftPattern.getRow()) / 2);
        for (int i = 0; i < RightPattern.getRow(); i++) {
            for (int j = 0; j < RightPattern.getColumn(); j++) {
                if (RightPattern.getIsavl(i, j) && itb.hasNext()) {
                    Point p = new Point();
                    Creature c = itb.next();
                    p.setX(this.column - j - 1);
                    p.setY(i + spaceb); //Symmetry
                    c.setX(this.column - j - 1);
                    c.setY(i + spaceb);
                    Field.put(p, c);
                }
            }
        }


        System.out.println("Current Creatures: " + Field.size());
        System.out.println("Left Pattern:" + this.LeftPattern.getClass().getName());
        System.out.println("Right Pattern:" + this.RightPattern.getClass().getName());
        for (Map.Entry<Point, Creature> entry : Field.entrySet()) {
            if (entry.getValue() != null) {
                System.out.println("Creature:" + entry.getValue().getClass() + " Point:" + entry.getKey().getX() + "," + entry.getKey().getY());
            }
        }
    }


    //Judge if the war should end.
    public static synchronized boolean warend() {
        boolean goodalive = false;
        boolean badalive = false;
        for (Creature c : Field.values()) {
            if (c.isgood && c.isalive) {
                goodalive = true;
            }
            if (!c.isgood && c.isalive) {
                badalive = true;
            }
        }
        if (goodalive == false) {
            System.out.println("WAR END, bad creatures win!");
            return true;
        } else if (badalive == false) {
            System.out.println("WAR END, good creatures win!");
            return true;
        } else {
            return false;
        }
    }

    public void run() {
        System.out.println("BARRIER WAIT SUCCESSFULLY");
        if (warend()) {
            this.exec.shutdownNow();
        } else {
            for (Map.Entry<Point, Creature> entry : Field.entrySet()) {
                if (entry.getValue().isalive == false) {
                    Field.remove(entry.getKey());
                }
            }
            System.out.println("Current Creatures: " + Field.size());
            CyclicBarrier barrier = new CyclicBarrier(Field.size(), this);
            try {
                TimeUnit.MILLISECONDS.sleep(700);
                ;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (Creature c : Field.values()) {
                c.setCyclicBarrier(barrier);
            }
        }
    }

    public void warstart() {
        CyclicBarrier barrier = new CyclicBarrier(Field.size(), this);
        for (Creature c : Field.values()) {
            c.setCyclicBarrier(barrier);
        }
        this.exec = Executors.newCachedThreadPool();
        for (Creature c : Field.values()) {
            this.exec.execute(new Thread(c));
        }
    }


}
