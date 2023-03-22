package com.example.w23comp1008lhvideogame;

import javafx.scene.image.Image;

public class Sprite {
    private Image image;
    private int posX, posyY, imageWidth, imageHeight, speed;
    private boolean alive;

    public Sprite(Image image, int posX, int posyY, int imageWidth, int imageHeight, int speed) {
        setImage(image);
        setPosX(posX);
        setPosyY(posyY);
        setImageWidth(imageWidth);
        setImageHeight(imageHeight);
        setSpeed(speed);
        alive = true;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosyY() {
        return posyY;
    }

    public void setPosyY(int posyY) {
        this.posyY = posyY;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
