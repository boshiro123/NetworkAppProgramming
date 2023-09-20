package org.example;

public class Square {
    private int length;

    public Square(int length) {
        this.length = length;
    }

    public Square() {
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int Square(int a){
        return a*a;
    }

    public int Perimeter(int a){
        return a*4;
    }
}
