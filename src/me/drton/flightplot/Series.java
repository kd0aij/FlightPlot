package me.drton.flightplot;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ton on 09.03.15.
 */
public class Series extends ArrayList<XYPoint> {
    private final String title;
    private final double skipOut;
    private Double lastTime = null;
    private Double lastValue = null;
    protected int hasNaNs = 0;

    public Series(String title, double skipOut) {
        this.title = title;
        this.skipOut = skipOut;
    }

    public String getTitle() {
        return title;
    }

    public String getFullTitle(String processorTitle) {
        if (hasNaNs > 0) {
            return processorTitle + (title.isEmpty() ? "" : (":" + title)) + " NaNs:" + Integer.toString(hasNaNs);
        } else {
            return processorTitle + (title.isEmpty() ? "" : (":" + title));
        }
    }

    public void addPoint(double time, double value) {
        if (lastTime != null && time - lastTime < skipOut) {
            lastValue = value;
            return;
        }
        if (lastValue != null && lastTime != null && time - lastTime > skipOut * 2) {
            add(new XYPoint(lastTime, lastValue));
        }
        lastTime = time;
        lastValue = null;
        add(new XYPoint(time, value));
    }
}
