package com.warx1a.graphing;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Collections;

/**
 * Created by WJ001 on 6/14/15.
 */
public class GGraph {
	
	private final GPaintUtils utils = new GPaintUtils();

    private final JFrame frame;
    private final JPanel panel;
    public final BufferedImage canvas;
    public final Graphics2D graphics;
    private final Dimension size;
    public final String x_label, y_label;
    
    public GGraph(final Dimension size) {
    	this(size, "x", "y");
    }

    public GGraph(final Dimension size, final String x_label, final String y_label) {
    	this.size = size;
    	this.x_label = x_label;
    	this.y_label = y_label;
        this.frame = new JFrame("Warx1a's grapher");
        this.panel = new JPanel();
        this.canvas = new BufferedImage(size.width,size.height, BufferedImage.TYPE_INT_RGB);
        this.graphics = this.canvas.createGraphics();
    }

    public void init() {
        frame.setSize(new Dimension(size.width + 25, size.height + 50));
        panel.setPreferredSize(frame.getSize());
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel(new ImageIcon(canvas)));
        frame.add(panel);
        frame.setVisible(true);
    }

    public <T extends GPainter<T>> void drawPoints(final GDataTracker<T> tracker) {
        GPainter<T> prev = null;
        utils.drawLabels(this);
        Collections.sort(tracker.getPoints());
        for(final GPainter<T> point: tracker.getPoints()) {
            point.draw(graphics);
            if(prev != null) {
                point.connectPoints(graphics, point, prev);
            }
            prev = point;
        }
    }

    public void draw() {
        graphics.setColor(Color.RED);
        graphics.drawString("Hello", 5, 10);
    }
    
    public Graphics2D getGraphics() {
    	synchronized(graphics) {
    		return graphics;
    	}
    }

}
