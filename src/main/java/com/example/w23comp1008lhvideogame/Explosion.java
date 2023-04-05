package com.example.w23comp1008lhvideogame;

import javafx.scene.image.Image;

public class Explosion extends Sprite {
    /**
     *
     * @param posX
     * @param posY
     */
    public Explosion(int posX, int posY) {
        super(new Image(Explosion.class.getResourceAsStream("images/fullExplosion2.png")),
                posX, posY, 100, 100, 0);
    }
}
