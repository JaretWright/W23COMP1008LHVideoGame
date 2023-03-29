package com.example.w23comp1008lhvideogame;

import javafx.scene.image.Image;

/**
 * When we write "extends" that means we are creating a custom version of the Sprite
 * class.  It will inherit all methods and attributes (instance variables) from the Sprite class
 */
public class Ship extends Sprite {


    /**
     * The ship image is known, so we do not need to pass that into the constructor
     * Similarly, the image height and width are known, so we can remove those arguments
     *
     * @param posX
     * @param posY
     */
    public Ship(int posX, int posY) {
        super(new Image(Main.class.getResourceAsStream("images/ship.png")), posX, posY,
                100, 70, 8);
    }

    /**
     * Increase the x coordinate moves the Sprite to the right
     * the width of the gameboard is 1000
     */
    public void moveRight()
    {
        int furthestRight = GAMEWIDTH-imageWidth;
        posX = posX + speed;
        if (posX>furthestRight)
            posX=furthestRight;
    }

    public void moveDown()
    {
        int furthestDown = GAMEHEIGHT-imageHeight;

        posY += speed;

        if (posY > furthestDown)
            posY=furthestDown;

    }
    //create method for moveLeft and move up
    public void moveLeft()
    {
        posX -= speed;
        if (posX<0)
            posX=0;
    }

    public void moveUp()
    {
        posY -= speed;
        if (posY<0)
            posY=0;
    }

}
