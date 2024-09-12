package com.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {

    private int x = -1;
    private int y = -1;
    private int radius = 0;

    public DrawingPanel() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();

                String radiusStr = JOptionPane.showInputDialog("Enter the radius of the circle:");
                try {
                    radius = Integer.parseInt(radiusStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number for the radius.");
                    return;
                }

                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (x >= 0 && y >= 0 && radius > 0) {
            g.setColor(Color.RED);
            g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
        }
    }
}
