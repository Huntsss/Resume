package com.warx1a.graphing;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by WJ001 on 6/14/15.
 */
public class GDataTracker<T extends GPainter> {

    private final ArrayList<T> data;

    public GDataTracker() {
        this.data = new ArrayList<T>();
    }

    public synchronized boolean addPoint(final T pt) {
        synchronized (data) {
            return data.add(pt);
        }
    }

    public synchronized boolean removePoint(final T pt) {
        synchronized (data) {
            return data.remove(pt);
        }
    }

    public synchronized ArrayList<T> getPoints() {
        synchronized (data) {
            return data;
        }
    }

}
