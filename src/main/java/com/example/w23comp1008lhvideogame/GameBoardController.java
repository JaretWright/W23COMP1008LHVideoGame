package com.example.w23comp1008lhvideogame;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public class GameBoardController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button startButton;

    @FXML
    void startGame(ActionEvent event) {
        startButton.setVisible(false);

        //create a canvas to "draw" on
        Canvas canvas = new Canvas(anchorPane.getWidth(),anchorPane.getHeight());

        //attach the canvas to the AnchorPane
        anchorPane.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();  //this is our "paint brush" to draw images

        //Create a Sprite to display a ship
        Image shipImage = new Image(Main.class.getResourceAsStream("images/ship.png"));
        Image background = new Image(Main.class.getResourceAsStream("images/space.png"));
        Sprite ship = new Sprite(shipImage,100,100,100,70,2);

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

                //draw the ship
                ship.draw(gc);

                //update the position the ship
                ship.moveRight();

                //create a method that allows us to move the ship down and test your code by running it
                ship.moveDown();


            }
        };

        timer.start();



    }

}
