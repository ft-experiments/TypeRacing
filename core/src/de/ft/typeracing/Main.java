package de.ft.typeracing;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img_strasse;
	BitmapFont font;

	float speed = 0;

	long millissave=0;

	int strassenbewegungsposition=0;
	int strasse_x=0;
	int strasse_y=0;



	@Override
	public void create () {


		batch = new SpriteBatch();
		img_strasse = new Texture("strasse.png");
		font = new BitmapFont();

		Gdx.app.setLogLevel(Application.LOG_INFO);



		Gdx.input.setInputProcessor(new InputProcessor() {
			@Override
			public boolean keyDown(int keycode) {

				if(speed<99) {
					speed++;
				}

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



				speed-=1;

			millissave=System.currentTimeMillis()+400;
			if(speed<0) {
				speed=0;
			}
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
		strassenbewegungsposition+=(int)speed;
		if(strassenbewegungsposition>img_strasse.getWidth()){
			strassenbewegungsposition=0;
		}
		batch.draw(img_strasse, strasse_x+strassenbewegungsposition, strasse_y);
		batch.draw(img_strasse, strassenbewegungsposition-img_strasse.getWidth(), strasse_y);


		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img_strasse.dispose();
	}
}
