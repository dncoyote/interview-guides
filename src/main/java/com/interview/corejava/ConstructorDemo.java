package com.interview.corejava;

class Rectangle {
    int width;
    int height;

    public Rectangle(int width, int height) {
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException("width & height required");

        this.width = width;
        this.height = height;

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}

public class ConstructorDemo {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1, 2);
        System.out.println("Height: " + rectangle.getHeight() + " Width: " + rectangle.getWidth());
    }
}