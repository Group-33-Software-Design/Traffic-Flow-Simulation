package com.group33.graphics;

import com.group33.time.timeclass;

import javax.swing.*;
import java.awt.*;

public class TopControls  extends Container  {

    private JButton start;
    private JButton stop;
    private JButton reset;

    public TopControls() {
        this.start = new JButton("Show Green Light");
        this.stop= new JButton("Show Red Light");
        this.reset= new JButton("Restart Simulation");
        this.setLayout(new GridLayout(1,3));
        this.add(start);
        this.add(stop);
        this.add(reset);
    }

    public JButton getStart() {
        return start;
    }

    public JButton getStop() {
        return stop;
    }

    public JButton getReset() {
        return reset;
    }
}
