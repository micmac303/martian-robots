package com.redbadger.martianrobots.model;

public class RobotImpl implements Robot {

    private int xPosition = 0;
    private int yPosition = 0;
    private String orientation = "N";
    private Grid gridMap;
    private boolean lost;

    public RobotImpl(Grid gridMap) {
        this.gridMap = gridMap;
    }

    public RobotImpl left() {

        if ("N".equals(orientation)) {
            orientation = "W";
        } else if ("E".equals(orientation)) {
            orientation = "N";
        } else if ("S".equals(orientation)) {
            orientation = "E";
        } else if ("W".equals(orientation)) {
            orientation = "S";
        }

        return this;
    }

    public RobotImpl right() {

        if ("N".equals(orientation)) {
            orientation = "E";
        } else if ("E".equals(orientation)) {
            orientation = "S";
        } else if ("S".equals(orientation)) {
            orientation = "W";
        } else if ("W".equals(orientation)) {
            orientation = "N";
        }

        return this;
    }

    public RobotImpl forward() {

        if ("N".equals(orientation)) {
            yPosition++;
        } else if ("E".equals(orientation)) {
            xPosition++;
        } else if ("S".equals(orientation)) {
            yPosition--;
        } else if ("W".equals(orientation)) {
            xPosition--;
        }

        return this;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public RobotImpl move(String command) {

        if (!lost) {

            if ("L".equals(command))
                left();
            else if ("R".equals(command))
                right();
            else if ("F".equals(command)) {

                if (xPosition == Integer.valueOf(gridMap.getMaxX()) && "E".equals(orientation) || yPosition == Integer.valueOf(gridMap.getMaxY()) && "N".equals(orientation)) {

                    boolean scentPointFound = false;
                    if (gridMap.getScentPoints().stream()
                            .filter(scentPoint -> scentPoint.getX() == this.getxPosition()
                                    && scentPoint.getY() == this.getyPosition()
                                    && scentPoint.getOrientation().equals(this.getOrientation())).count() > 0) {

                        scentPointFound = true;
                    }

                    if (!scentPointFound) {
                        lost = true;
                        ScentPoint scentPoint = new ScentPoint();
                        scentPoint.setX(this.getxPosition());
                        scentPoint.setY(this.getyPosition());
                        scentPoint.setOrientation(this.getOrientation());
                        gridMap.getScentPoints().add(scentPoint);
                    }
                } else {
                    forward();
                }
            }
        }
        return this;
    }
}