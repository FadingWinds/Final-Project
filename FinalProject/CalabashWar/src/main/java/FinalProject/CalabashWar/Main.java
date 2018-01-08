package FinalProject.CalabashWar;

import FinalProject.CalabashWar.Patterns.PatternGenerator;

import javax.swing.*;


public class Main {

    public static void main(String args[]){
        PatternGenerator pt = new PatternGenerator();
        Lawn l = new Lawn(pt.next(),pt.next());
        l.Init();
        l.warstart();
    }
}


