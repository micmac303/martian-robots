package com.redbadger.martianrobots.model;

import java.util.Arrays;
import java.util.Scanner;

public class RobotController {

    private Grid gridMap = new Grid();

    public void start() {

        Scanner fileScanner = new Scanner(this.getClass().getResourceAsStream("/input.txt"));
        gridMap.setMaxX(fileScanner.next());
        gridMap.setMaxY(fileScanner.next());
        fileScanner.nextLine();
        while (fileScanner.hasNext()) {
            moveNewRobot(fileScanner);
        }
    }

    private void moveNewRobot(Scanner fileScanner) {

        RobotImpl robot = new RobotImpl(gridMap);
        robot.setxPosition(Integer.valueOf(fileScanner.next()));
        robot.setyPosition(Integer.valueOf(fileScanner.next()));
        robot.setOrientation(fileScanner.next());

        fileScanner.nextLine();
        Arrays.stream(fileScanner.nextLine().split("")).forEach(robot::move);
        if (fileScanner.hasNextLine()) fileScanner.nextLine();

        System.out.print(String.valueOf(robot.getxPosition())
                + String.valueOf(robot.getyPosition())
                + robot.getOrientation());

        if (robot.isLost()) {
            System.out.print("LOST");
        }
        System.out.println();
    }
}