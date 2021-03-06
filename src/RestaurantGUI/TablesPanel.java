/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestaurantGUI;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.JPanel;

/**
 *
 * @author ngsm
 */
public class TablesPanel extends JPanel {

    private ArrayList<Table> tList;

    public TablesPanel(ArrayList<Table> tables) {
        this.setSize(400, 400);
        tList = tables;
    }

    /**
     * draw tables on the panel
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.lightGray);
        for (Table t : tList) // draw each table on the panel
        {
            int x = t.getxPos();
            int y = t.getyPos();
            g.drawOval(x, y, 55, 55);
            g.drawString("Table " + t.getTableNo(), x, y + 12);
            g.drawString("Seats " + t.getSeatingCapacity(), x, y + 24);
            g.drawString(t.getCurrentStatus(), x, y + 36);
        }
    }

    /**
     * Find the tableNo of the table within an x and y radius
     */
    public int getTableNo(int x, int y) {
        for (Table t : tList) {
            int xDist = x - t.getxPos();
            int yDist = y - t.getyPos();
            if (xDist >= 0 && xDist <= 55 && yDist >= 0 && yDist <= 55) {
                return t.getTableNo();
            }
        }
        return -1; // not found
    }
}
