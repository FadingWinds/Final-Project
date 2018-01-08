package FinalProject.CalabashWar.Creatures;

import FinalProject.CalabashWar.Creatures.*;
import FinalProject.CalabashWar.Patterns.*;
import FinalProject.CalabashWar.*;

import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.awt.Image;


public abstract class Creature implements Runnable {
    public boolean isalive;
    public boolean isgood;
    protected double HP;
    protected int minATK;
    protected int maxATK;
    protected int x;
    protected int y;
    protected CyclicBarrier cyclicBarrier;
    protected Lock lock = new ReentrantLock();
    protected Image img;

    public Creature() {
        this.isalive = true;
        this.x = -1;
        this.y = -1;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Image getImg() {
        return img;
    }

    public boolean getLock() {
        return this.lock.tryLock();
    }

    public void releaseLock() {
        this.lock.unlock();
    }

    public void setCyclicBarrier(CyclicBarrier barrier) {
        this.cyclicBarrier = barrier;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getHP() {
        return HP;
    }

    public synchronized int Attack() {
        Random r = new Random();
        int ATK = r.nextInt(maxATK) % (maxATK - minATK + 1) + minATK;
        return ATK;
    }

    public synchronized void beAttacked(Creature enemy, int enemyATK) {
        if (this.isgood) {
            System.out.println("Fightround:" + this.getClass().getName() + " & " + enemy.getClass().getName());
        } else {
            System.out.println("Fightround:" + enemy.getClass().getName() + " & " + this.getClass().getName());
        }
        this.HP = this.HP - enemyATK;
        System.out.println(this.getClass().getName() + " was attacked by " + enemyATK + " HP now: " + this.HP);
        setIsalive();
    }

    public void setIsalive() {
        if (this.HP <= 0) {
            this.isalive = false;
        } else {
            this.isalive = true;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() == obj.getClass()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public abstract void move();

    public class Detect {
        boolean detect;
        Creature c;

        public Detect() {
            detect = false;
        }

        public void setC(Creature c) {
            this.c = c;
        }

        public Creature getC() {
            return c;
        }

        public boolean isDetect() {
            return detect;
        }

        public void setDetect(boolean detect) {
            this.detect = detect;
        }
    }

    public synchronized Detect detect() {
        Detect fightflag = new Detect();
        Point p = new Point();
        p.setX(this.x);
        p.setY(this.y);
        //In order to avoid the situation that some creatures could never get in a fight due to patterns
        //whatever their distance, the two creatures could fight as long as they are in the same column
        //and this kind of fight has top priority.
        for (int i = 0; i < Lawn.getRow(); i++) {
            p.setY(i);
            Creature c = (Creature) Lawn.getField().get(p);
            if (c != null && c.isalive && c.isgood != this.isgood) {
                fightflag.setDetect(true);
                fightflag.setC(c);
                break;
            }
        }
        p.setY(this.y);
        if (!fightflag.isDetect()) {
            Set<Point> set = Lawn.getField().keySet();
            for (Point key : set) {
                Creature c = (Creature) Lawn.getField().get(key);
                int dx = p.getX() - key.getX();
                int dy = p.getY() - key.getY();
                if (c != null && c.isalive && c.isgood != this.isgood && (dx * dx + dy * dy) <= 2) {
                    fightflag.setDetect(true);
                    fightflag.setC(c);
                    break;
                }
            }
        }
        return fightflag;
    }

    public synchronized void fight(Creature enemy) {
        this.setIsalive();
        if (enemy != null && enemy.getLock() && this.getLock()) {
            while (this.isalive && enemy.isalive) {
                enemy.beAttacked(this, this.Attack());
                enemy.fight(this);
            }
            this.releaseLock();
            enemy.releaseLock();
        }
    }

    public void run() {
        try {
            while (!Thread.interrupted() && this.isalive) {
                this.setIsalive();
                this.move();
                this.detect();
                while (detect().isDetect() && this.isalive) {
                    this.detect();
                    this.fight(detect().getC());
                    this.setIsalive();
                }
                TimeUnit.MILLISECONDS.sleep(200);
                this.cyclicBarrier.await();
            }
            TimeUnit.MILLISECONDS.sleep(200);
            System.out.println(this.getClass().getName() + " Dead.");
        } catch (InterruptedException e) {
            System.out.println("War is end.");
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
