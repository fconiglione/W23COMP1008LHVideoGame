package com.example.w23comp1008lhvideogame;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;

public class GameBoardController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button startButton;

    private HashSet<KeyCode> activeKeys;

    @FXML
    void startGame(ActionEvent event) {
        startButton.setVisible(false);

        // configure the environment to know which keys are pressed
        // Sets are similar to a List (they hold collections of objects), but it automatically prevents duplicates
        activeKeys = new HashSet<>();

        // the -> is called a "lambda expression" and is covered in the Advanced course
        // when a key is pressed, add it to the "activeKey" set
        // when a key is released, remove it from the "activeKey" set
        anchorPane.getScene().setOnKeyPressed(keyPressed -> activeKeys.add(keyPressed.getCode()));
        anchorPane.getScene().setOnKeyReleased(keyReleased -> activeKeys.remove(keyReleased.getCode()));

        //create a canvas to "draw" on
        Canvas canvas = new Canvas(anchorPane.getWidth(),anchorPane.getHeight());

        //attach the canvas to the AnchorPane
        anchorPane.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();  //this is our "paint brush" to draw images

        //Create a Sprite to display a ship
        Image background = new Image(Main.class.getResourceAsStream("images/space.png"));
        Ship ship = new Ship(100,100);

        // SecureRandom is a class that creates random numbers
        SecureRandom rng = new SecureRandom();
        ArrayList<Alien> aliens = new ArrayList<>();
        for (int i=1; i<=12; i++)
            aliens.add(new Alien(rng.nextInt(500,1000), rng.nextInt(0,740)));
        AnimationTimer timer = new AnimationTimer() {
            /**
             * The "handle()" method is abstract in the AnimationTimer class, so we
             * need to override it here and tell it what we want it to do.
             *
             * Anything inside the {...} will be executed everytime the timer advances
             * @param now
             *            The timestamp of the current frame given in nanoseconds. This
             *            value will be the same for all {@code AnimationTimers} called
             *            during one frame.
             */
            @Override
            public void handle(long now) {
                //draw the background
                gc.drawImage(background,0,0,anchorPane.getWidth(),anchorPane.getHeight());

                updateShip(ship);

                //draw the ship
                ship.draw(gc);

                //draw the Aliens
                for (Alien alien : aliens)
                    alien.draw(gc);
            }
        };

        timer.start();

    }

    private void updateShip(Ship ship)
    {
        if (activeKeys.contains(KeyCode.DOWN))
            ship.moveDown();
        if (activeKeys.contains(KeyCode.RIGHT))
            ship.moveRight();
        if (activeKeys.contains(KeyCode.LEFT))
            ship.moveLeft();
        if (activeKeys.contains(KeyCode.UP))
            ship.moveUp();
        if(activeKeys.contains(KeyCode.SPACE))
            ship.shootMissile();
    }
}
