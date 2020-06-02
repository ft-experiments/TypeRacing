package de.ft.typeracing.car.steuerung;

import com.badlogic.gdx.Gdx;
import de.ft.typeracing.car.CarSteuerung;

public class NormalSteuerung implements CarSteuerung {
    public long millissave;
    public NormalSteuerung(){

    }
    @Override
    public float correctKeyTyped(float speed) {
        if (speed < 99) {

            if(((99 - speed) / 60)>0.77f) {
                speed = speed + ((99 - speed) / 60);
            }else{
                speed = 0.77f;
            }


        }
        return speed;
    }

    @Override
    public float dagegenarbeiter(float speed) {
        if (System.currentTimeMillis() > millissave) {

            speed -= 1;
            if(speed<0){
                speed=0;
            }



        millissave=System.currentTimeMillis()+400;
        }
     return speed;
    }

    @Override
    public float fehler(float speed) {
        return speed = speed - speed / 4.5f;
    }
}
