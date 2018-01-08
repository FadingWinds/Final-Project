package FinalProject.CalabashWar.Creatures;

import FinalProject.CalabashWar.Lawn;
import FinalProject.CalabashWar.Point;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

//小喽啰
public final class Underling extends Creature {
    public Underling() {
        this.HP = 700;
        this.maxATK = 90;
        this.minATK = 60;
        this.isgood = false;
        //URL loc = this.getClass().getClassLoader().getResource("underling.png");
        //ImageIcon icon = new ImageIcon(loc);
        //Image image = icon.getImage();
        //this.setImg(image);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
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
            System.out.println(this.getClass().getName() + " moves.(" + this.getX() + "," + this.getY() + ")");
            notifyAll();
        } else {
            this.x++;
        }
    }
}
