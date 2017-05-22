package com.redbadger.martianrobots.model;

public interface Robot {

    Robot move(String command);
    Robot left();
    Robot right();
    Robot forward();
    boolean isLost();
}