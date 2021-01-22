package cn.tedu.store.study.demo1;

public class Rectangle {
    private
        double length;
        double width;

    public Rectangle(double length, double width) {
        this.length=length;
        this.width=width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea(){
        return width*length;
    }
}
