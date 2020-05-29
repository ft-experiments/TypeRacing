package de.ft.typeracing.car;

import com.badlogic.gdx.graphics.Texture;
import de.ft.typeracing.Texte;

public class Car {
    CarSteuerung carSteuerung =null;
    Texture img_car;

    public Car(CarSteuerung carSteuerung, Texture img_car){
        this.carSteuerung=carSteuerung;

    }

    public CarSteuerung getCarSteuerung() {
        return carSteuerung;
    }



    public void setCarSteuerung(CarSteuerung carSteuerung) {
        this.carSteuerung = carSteuerung;
    }
}
