package com.warx1a.graphing;

import java.awt.*;

/**
 * Created by WJ001 on 6/14/15.
 */
public class GPoint extends GPainter {

    private static final GPaintUtils utils = new GPaintUtils();

    public GPoint(final int x, final int y) {
        super(utils, x , y);
    }

    public void draw(final Graphics2D g) {
        g.fillOval(x, y, 4, 4);
    }

    @Override
    public void connectPoints(final Graphics2D g, final GPainter pt_1, final GPainter pt_2) {
        g.drawLine(pt_1.x, pt_1.y, pt_2.x, pt_2.y);
    }

    @Override public String toString() {
        return "X:" + x + " Y:" + y;
    }
}
