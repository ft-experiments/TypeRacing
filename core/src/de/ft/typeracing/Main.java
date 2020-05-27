package de.ft.typeracing;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	BitmapFont font;

	long timelastpressed = 0;
	long timepressaverage =0;

	float speed = 0;

	long millissave=0;

	long presser=1;
	
	@Override
	public void create () {


		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		font = new BitmapFont();

		Gdx.app.setLogLevel(Application.LOG_INFO);

		timelastpressed = System.currentTimeMillis();


		Gdx.input.setInputProcessor(new InputProcessor() {
			@Override
			public boolean keyDown(int keycode) {
				timepressaverage = timepressaverage + System.currentTimeMillis() - timelastpressed;
				timelastpressed = System.currentTimeMillis();
				presser++;

				speed++;

				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				return false;
			}

			@Override
			public boolean keyTyped(char character) {

				return false;
			}

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				return false;
			}

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer, int button) {
				return false;
			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				return false;
			}

			@Override
			public boolean mouseMoved(int screenX, int screenY) {
				return false;
			}

			@Override
			public boolean scrolled(int amount) {
				return false;
			}
		});

	}
	@Override
	public void render () {
			Gdx.app.log("Average", String.valueOf(speed));



		if(System.currentTimeMillis()>millissave){


			if(speed>0) {
				speed--;
			}
			millissave=System.currentTimeMillis()+400;
		}





/*
		if(presser>20) {
			timepressaverage = timepressaverage/presser;
			presser =1;

		}
*/





		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
