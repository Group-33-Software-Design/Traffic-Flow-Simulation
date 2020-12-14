package com.group33.view.graphics;

import javax.swing.*;
import java.awt.*;

public class Stage extends JFrame {

    private Dimension dimension;
    private RoadContainer roadContainer;
    private TopControls topControls;
    private BottomControls bottomControls;

    public Stage(String title,int newWidth,int newHeight) throws HeadlessException {
        super(title);
        dimension = new Dimension(newWidth,newHeight);
        this.setSize(dimension);
        this.setPreferredSize(new Dimension(dimension));
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.drawStage();
        this.setVisible(true);
    }

    public void drawStage(){
        roadContainer = new RoadContainer(dimension);
        topControls = new TopControls();
        bottomControls = new BottomControls();
        this.add(roadContainer,BorderLayout.CENTER);
        this.add(topControls, BorderLayout.NORTH);
        this.add(bottomControls, BorderLayout.SOUTH);

    }

    public Dimension getDimension() {
        return dimension;
    }

    public RoadContainer getRoadContainer() {
        return roadContainer;
    }

    public TopControls getTopControls() {
        return topControls;
    }

    public BottomControls getBottomControls() {
        return bottomControls;
    }
}
