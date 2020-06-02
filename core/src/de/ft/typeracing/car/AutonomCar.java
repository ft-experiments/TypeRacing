package de.ft.typeracing.car;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import de.ft.typeracing.Main;

public class AutonomCar {
    float sollmindestgeschwindigkeit=5;
    float mindestgeschwindig=0;
    float d=0;
    float sollSpeed=0;
    float speed=0;
    int y,w,h;
    float x=0;
    float pwert=1;
    float iwert=0.6f;
    Texture img_car;
    float sollspeedalt=-999;
    public AutonomCar(Texture img_car,float pwert,float iwert, float d){
        this.img_car=img_car;
        this.pwert = pwert;
        this.iwert = iwert;
        this.d =d;
    }

    public void draw(SpriteBatch batch){
            mindestgeschwindig-=((mindestgeschwindig-sollmindestgeschwindigkeit)*0.01f);
            sollSpeed+=1-Math.random()*2;
            if(sollspeedalt!=sollSpeed) {
                speed -= ((speed - sollSpeed) * pwert + (speed - sollSpeed + d) * iwert);
                d += (speed - sollSpeed);
                sollspeedalt=sollSpeed;
            }

            if(speed<mindestgeschwindig){
                speed=mindestgeschwindig;
            }




        x+=speed - Main.speed;
        batch.draw(img_car,x,y,w,h);
    }

    public void setBounds(int y, int w,int h){
        this.y=y;
        this.w=w;
        this.h=h;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }



    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public float getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setImg_car(Texture img_car) {
        this.img_car = img_car;
    }

    public Texture getImg_car() {
        return img_car;
    }

    public void setSollSpeed(float sollSpeed) {
        this.sollSpeed = sollSpeed;
    }

    public float getSollSpeed() {
        return sollSpeed;
    }

    public float getSpeed() {
        return speed;
    }
}
