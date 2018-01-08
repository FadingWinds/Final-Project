package FinalProject.CalabashWar.Creatures;

import FinalProject.CalabashWar.Lawn;
import FinalProject.CalabashWar.Point;

//蛇精
public final class Snake extends Creature {

    public Snake() {
        this.isgood = false;
        this.HP = 1000;
        this.maxATK = 200;
        this.minATK = 100;
    }

    @Override
    public boolean equals(Object obj) {
        Snake sn = (Snake) obj;
        if (this.getClass() == sn.getClass()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 19;
        result = result * 31 + Double.valueOf(this.HP).hashCode();
        result = result * 31 + Integer.valueOf(this.minATK).hashCode();
        result = result * 31 + Integer.valueOf(this.maxATK).hashCode();
        return result;
    }

    public synchronized void move() {
        Point p1 = new Point();
        p1.setX(this.x);
        p1.setY(this.y);
        this.x--;
        Point p2 = new Point();
        p2.setX(this.x);
        p2.setY(this.y);
        try {
            if (Lawn.getField().get(p2)!=null) {
                wait(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (Lawn.getField().get(p2) == null) {
            Lawn.getField().remove(p1);
            Lawn.getField().put(p2, this);
            System.out.println(this.getClass().getName() + " moves.(" + this.getX() +"," +this.getY()+")");
            notifyAll();
        }
        else {
            this.x++;
        }
    }


}
