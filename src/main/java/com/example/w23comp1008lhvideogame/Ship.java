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
     */
    public void moveRight()
    {
        posX = posX + speed;
    }

    public void moveDown()
    {
        posY += speed;
    }

    // create methods for moveLeft and moveUp
    public void moveLeft()
    {
        posX -= speed;
    }

    public void moveUp()
    {
        posY -= speed;
    }
}