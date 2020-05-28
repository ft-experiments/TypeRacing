package de.ft.typeracing.car;

public class Car {
    CarSteuerung carSteuerung =null;

    public Car(CarSteuerung carSteuerung){
        this.carSteuerung=carSteuerung;
    }

    public CarSteuerung getCarSteuerung() {
        return carSteuerung;
    }



    public void setCarSteuerung(CarSteuerung carSteuerung) {
        this.carSteuerung = carSteuerung;
    }
}
