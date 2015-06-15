package com.warx1a.graphing;

import java.awt.*;

/**
 * Created by WJ001 on 6/14/15.
 */
public class Main {

    public final GDataTracker<GPoint> points;

    public Main() {
        this.points = new GDataTracker<GPoint>();
    }

    public static void main(String[] args) {
        final Main main = new Main();
        main.points.addPoint(new GPoint(100,100));
        main.points.addPoint(new GPoint(200,100));
        main.points.addPoint(new GPoint(373,158));
        main.points.addPoint(new GPoint(147,298));
        final GGraph graph = new GGraph();
        graph.init();
        graph.drawPoints(main.points);
    }
}
