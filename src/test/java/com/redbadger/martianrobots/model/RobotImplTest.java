package com.redbadger.martianrobots.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class RobotImplTest {

    //System under test
    private RobotImpl robot;

    @Before
    public void setup() {

        Grid grid = new Grid();
        grid.setMaxX("5");
        grid.setMaxY("3");
        robot = new RobotImpl(grid);
    }

    @Test
    public void initialState() {

        assertEquals(robot.getOrientation(), "N");
        assertEquals(robot.getxPosition(), 0);
        assertEquals(robot.getyPosition(), 0);
    }

    @Test
    public void left() throws Exception {

        robot.left();
        assertEquals(robot.getOrientation(), "W");

        robot.left();
        assertEquals(robot.getOrientation(), "S");

        robot.left();
        assertEquals(robot.getOrientation(), "E");

        robot.left();
        assertEquals(robot.getOrientation(), "N");
    }

    @Test
    public void right() throws Exception {

        robot.right();
        assertEquals(robot.getOrientation(), "E");

        robot.right();
        assertEquals(robot.getOrientation(), "S");

        robot.right();
        assertEquals(robot.getOrientation(), "W");

        robot.right();
        assertEquals(robot.getOrientation(), "N");
    }

    @Test
    public void forward() throws Exception {

        robot.forward();
        assertEquals(1, robot.getyPosition());

        robot.right().forward();
        assertEquals(1, robot.getxPosition());

        robot.forward().forward();
        assertEquals(3, robot.getxPosition());

        robot.left().forward().forward().forward();
        assertEquals(4, robot.getyPosition());
    }

    @Test
    public void move() {

        robot.setxPosition(1);
        robot.setyPosition(1);
        robot.setOrientation("E");

        String[] commands = "RFRFRFRF".split("");
        Arrays.stream(commands).forEach(robot::move);

        assertEquals(1, robot.getxPosition());
        assertEquals(1, robot.getyPosition());
        assertEquals("E", robot.getOrientation());

        robot.setxPosition(3);
        robot.setyPosition(2);
        robot.setOrientation("N");

        commands = "FRRFLLFFRRFLL".split("");
        Arrays.stream(commands).forEach(robot::move);

        assertEquals(3, robot.getxPosition());
        assertEquals(3, robot.getyPosition());
        assertEquals("N", robot.getOrientation());
    }

    @Test
    public void moveWithScentPoint() {

        Grid grid = new Grid();
        grid.setMaxX("5");
        grid.setMaxY("3");
        ScentPoint scentPoint = new ScentPoint();
        scentPoint.setX(3);
        scentPoint.setY(3);
        scentPoint.setOrientation("N");
        grid.getScentPoints().add(scentPoint);

        robot = new RobotImpl(grid);


        robot.setxPosition(0);
        robot.setyPosition(3);
        robot.setOrientation("W");

        String[] commands = "LLFFFLFLFL".split("");
        Arrays.stream(commands).forEach(robot::move);

        assertEquals(2, robot.getxPosition());
        assertEquals(3, robot.getyPosition());
        assertEquals("S", robot.getOrientation());
    }
}