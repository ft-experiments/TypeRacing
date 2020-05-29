package de.ft.typeracing.car;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import de.ft.typeracing.Texte;
import de.ft.typeracing.car.steuerung.NormalSteuerung;

public class Car {
    CarSteuerung carSteuerung =null;
    Texture img_car;
    int x;
    int y;
    int w;
    int h;

    public Car(CarSteuerung carSteuerung, Texture img_car,int x,int y,int w,int h){
        this.carSteuerung=carSteuerung;
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;

    }


    public void draw(SpriteBatch batch){
        batch.draw(img_car,x,y,w,h);
    }

    public CarSteuerung getCarSteuerung() {
        return carSteuerung;
    }


    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setImg_car(Texture img_car) {
        this.img_car = img_car;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }

    public Texture getImg_car() {
        return img_car;
    }


    public void setCarSteuerung(CarSteuerung carSteuerung) {
        this.carSteuerung = carSteuerung;
    }
}
