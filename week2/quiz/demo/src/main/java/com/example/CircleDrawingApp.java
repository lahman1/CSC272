package com.example;

import javax.swing.JFrame;

public class CircleDrawingApp {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle Drawing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        DrawingPanel panel = new DrawingPanel();
        frame.add(panel);

        frame.setVisible(true);
    }
}
