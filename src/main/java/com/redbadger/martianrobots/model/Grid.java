package com.redbadger.martianrobots.model;

import java.util.ArrayList;
import java.util.Collection;

public class Grid {

    private String maxX;
    private String maxY;
    private String minX;
    private String miny;

    private Collection<ScentPoint> scentPoints;

    public String getMaxX() {
        return maxX;
    }

    public void setMaxX(String maxX) {
        this.maxX = maxX;
    }

    public String getMaxY() {
        return maxY;
    }

    public void setMaxY(String maxY) {
        this.maxY = maxY;
    }

    public Collection<ScentPoint> getScentPoints() {
        if (scentPoints != null) {
            return scentPoints;
        } else {
            scentPoints = new ArrayList<>();
            return scentPoints;
        }
    }

    public void setScentPoints(Collection<ScentPoint> scentPoints) {
        this.scentPoints = scentPoints;
    }
}
