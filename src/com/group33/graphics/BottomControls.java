package com.group33.graphics;

import com.group33.trafficlight.LightClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BottomControls extends Container{

    private JButton experiencedDriver;
    private JButton recklessDriver;
    private JButton normalDriver;
    private JButton experiencedDriver2;
    private JButton recklessDriver2;
    private JButton normalDriver2;
    private LightClass lightClass;

    public BottomControls() {
        this.experiencedDriver = new JButton("Add Experienced Driver");
        this.recklessDriver = new JButton("Add Reckless Driver");
        this.normalDriver = new JButton("Add Normal Driver");
        this.experiencedDriver2 = new JButton("Add Experienced Driver");
        this.recklessDriver2 = new JButton("Add Reckless Driver");
        this.normalDriver2= new JButton("Add Normal Driver");
        this.setLayout(new GridLayout(2,3));
        this.add(experiencedDriver);
        this.add(recklessDriver);
        this.add(normalDriver);
        this.add(experiencedDriver2);
        this.add(recklessDriver2);
        this.add(normalDriver2);

    }

    public JButton getExperiencedDriver() {
        return experiencedDriver;
    }

    public JButton getRecklessDriver() {
        return recklessDriver;
    }

    public JButton getNormalDriver() {
        return normalDriver;
    }

    public JButton getExperiencedDriver2() {
        return experiencedDriver2;
    }

    public JButton getRecklessDriver2() {
        return recklessDriver2;
    }

    public JButton getNormalDriver2() {
        return normalDriver2;
    }

    public LightClass getLightClass() {
        return lightClass;
    }
}
