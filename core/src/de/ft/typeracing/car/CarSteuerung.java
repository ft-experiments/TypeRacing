package de.ft.typeracing.car;

public interface CarSteuerung {
    float correctKeyTyped(float speed);
    float dagegenarbeiter(float speed);
    float fehler(float speed);
}
