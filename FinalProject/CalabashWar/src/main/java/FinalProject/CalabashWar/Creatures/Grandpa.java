package FinalProject.CalabashWar.Creatures;

import FinalProject.CalabashWar.Lawn;
import FinalProject.CalabashWar.Point;

//葫芦娃的爷爷
public final class Grandpa extends Creature {
    private ULTs ult;

    public Grandpa() {
        this.isgood = true;
        this.HP = 800;
        this.maxATK = 110;
        this.minATK = 80;
        this.ult = ULTs.COLORFUL_LOTUS;
    }

    @Override
    public boolean equals(Object obj) {
        Grandpa gp = (Grandpa) obj;
        if (this.getClass() == gp.getClass()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + Double.valueOf(this.HP).hashCode();
        result = result * 31 + Integer.valueOf(this.minATK).hashCode();
        result = result * 31 + Integer.valueOf(this.maxATK).hashCode();
        return result;
    }

    public synchronized void move() {
        Point p1 = new Point();
        p1.setX(this.x);
        p1.setY(this.y);
        this.x++;
        Point p2 = new Point();
        p2.setX(this.x);
        p2.setY(this.y);
        try {
            if (Lawn.getField().get(p2) != null) {
                wait(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (Lawn.getField().get(p2) == null) {
            Lawn.getField().remove(p1);
            Lawn.getField().put(p2, this);
            System.out.println(this.getClass().getName() + " moves.(" + this.getX() + "," + this.getY() + ")");
            notifyAll();
        } else {
            this.x--;
            System.out.println(this.getClass().getName() + " Move failed");
        }
    }
}
