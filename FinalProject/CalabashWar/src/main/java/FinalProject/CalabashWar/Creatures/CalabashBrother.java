package FinalProject.CalabashWar.Creatures;

import FinalProject.CalabashWar.*;

//葫芦娃
public abstract class CalabashBrother extends Creature {
    protected Rank rank;
    protected Color color;
    protected ULTs ult;

    public CalabashBrother() {
        this.isgood = true;
        this.HP = 1000;
        this.maxATK = 150;
        this.minATK = 100;
    }

    public Rank getRank() {
        return rank;
    }

    public Color getColor() {
        return color;
    }

    public int getOrdinal() {
        return rank.ordinal();
    }

    @Override
    public boolean equals(Object obj) {
        CalabashBrother cb = (CalabashBrother) obj;
        if (this.rank == cb.rank && this.color == cb.color) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.rank.ordinal();
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
