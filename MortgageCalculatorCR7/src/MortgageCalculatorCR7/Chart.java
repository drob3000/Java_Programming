/*
 * Author: Dan Roberts, University of Phoenix Copyright 2012
 * Current Release Date: Monday March 12, 2012
 * Version: 1.1.0
 * Submitted for PRG421 Java Programming II | course at the University of Phoenix
 * Scope: 
 * Creates the Pie chart from the mortgage data
 */
package MortgageCalculatorCR7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;


public class Chart extends JPanel {
    private PieSlice[] slice;
    private int current = 0;
    private float totalSize = 0;
    private Color background;

    public Chart (int sliceCount) {
        slice = new PieSlice[sliceCount];
        background = getBackground();
        
    }

    public void addSlice(Color sColor, float sSize) {
        if (current <= slice.length) {
            slice[current] = new PieSlice(sColor, sSize);
            totalSize += sSize;
            current++;
        }
    }

    public void paintComponent(Graphics comp) {
//        super.paintComponent(comp);
        Graphics2D comp2D = (Graphics2D) comp;
        int width = getSize().width - 10;
        int height = getSize().height - 15;
        int xInset = 5;
        int yInset = 5;
        if (width < 5) {
            xInset = width;
        }
        if (height < 5) {
            yInset = height;
        }
        comp2D.setColor(background);
        comp2D.fillRect(0, 0, getSize().width, getSize().height);
        comp2D.setColor(Color.lightGray);
        Ellipse2D.Float pie = new Ellipse2D.Float(
                xInset, yInset, width, height);
        comp2D.fill(pie);
        float start = 0;
        for (int i = 0; i < slice.length; i++) {
            float extent = slice[i].size * 360F / totalSize;
            comp2D.setColor(slice[i].color);
            Arc2D.Float drawSlice = new Arc2D.Float(
                    xInset, yInset, width, height, start, extent,
                    Arc2D.Float.PIE);
            start += extent;
            comp2D.fill(drawSlice);
        }
    }
}

class PieSlice {

    Color color = Color.lightGray;
    float size = 0;

    PieSlice(Color pColor, float pSize) {
        color = pColor;
        size = pSize;
    }
    
}
