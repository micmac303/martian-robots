package com.redbadger.martianrobots;

import com.redbadger.martianrobots.model.RobotController;
import org.springframework.boot.SpringApplication;

import java.io.IOException;

public class MartianRobotsApplication {

    public static void main(String[] args) throws IOException {

        RobotController robotController = new RobotController();
        robotController.start();
    }
}
