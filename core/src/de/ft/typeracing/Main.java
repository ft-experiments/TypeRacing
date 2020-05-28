package de.ft.typeracing;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import de.ft.typeracing.car.Car;


public class Main extends ApplicationAdapter {
	public static SpriteBatch batch;


	public static BitmapFont font;
	private static final GlyphLayout glyphLayout = new GlyphLayout();

	public static Texture img_strasse;
	public static Texture img_amatur;
	public static Texture img_amaturrahmen;

	public static float speed = 0;

	public static long millissave=0;

	public static int strassenbewegungsposition=0;
	public static int strasse_x=0;
	public static int strasse_y=0;

	public static int textfeldheight=130;

	public static String current_text="";
	public static String anzeige_text="";

	public static boolean fehler=false;

	public static Car spielerauto=new Car();

public static boolean fmode = false;

	@Override
	public void create () {




		try {
			//schriftart
			FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("comicsans.ttf"));
			FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
			parameter.size = 50;
			font = generator.generateFont(parameter); // font size 12 pixels
			generator.dispose(); // don't forget to dispose to avoid memory leaks!
		} catch (Exception e) {
			System.out.println("Fehler beim Laden der Schrift");
		}




		batch = new SpriteBatch();
		img_amatur = new Texture("amatur.png");
		img_strasse = new Texture("strasse.png");
		img_amaturrahmen = new Texture("amaturrahmen.png");


		Gdx.app.setLogLevel(Application.LOG_INFO);



		Gdx.input.setInputProcessor(new InputProcessor() {
			@Override
			public boolean keyDown(int keycode) {

				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				return false;
			}

			@Override
			public boolean keyTyped(char character) {
				if(anzeige_text.startsWith(Character.toString(character))) {
					anzeige_text = anzeige_text.substring(1);
					if (speed < 99) {

						if(!fmode) {
							speed = speed + ((99 - speed) / 60);
						}else{
							speed = speed +1;
						}

					}

					Gdx.app.log("Speed", String.valueOf(((99 - speed) / 97)));
					fehler=false;
				}else{
					fehler=true;
					if(!fmode) {
						speed = speed - speed / 4.5f;
					}else{
						if(speed>0) {
							speed = speed - 1;
						}
					}
				}
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



neuesSpiel();
	}

	public static void neuesSpiel(){
		current_text=Texte.Text3;
		anzeige_text=current_text;

	}
	public static void SpielFertig(){

	}


	@Override
	public void render () {
		//	Gdx.app.log("Average", String.valueOf(speed));


		if (Gdx.input.isKeyJustPressed(Input.Keys.F) && Gdx.input.isKeyJustPressed(Input.Keys.T) && Gdx.input.isKeyJustPressed(Input.Keys.E)) {
			fmode = true;
			current_text = "You found an Easteregg. Viel Spaß damit noch! Vielen dank für die benutzung von TypeRacing!";
			anzeige_text = current_text;
		}

		if (System.currentTimeMillis() > millissave) {

			if(!fmode) {
			speed -= 1;


	if (speed > 9) {

		if (speed < 34) {
			millissave = (long) ((long) System.currentTimeMillis() + 250 - speed * 2);
		} else {
			millissave = System.currentTimeMillis() + 180;
		}
	} else {
		millissave = System.currentTimeMillis() + 600;
	}
	if (speed < 0) {
		speed = 0;
	}
}else{
				if(speed>0) {
					speed -= 1;
				}
	millissave=System.currentTimeMillis() + 400;
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
		strassenbewegungsposition += (int) speed;
		if (strassenbewegungsposition > img_strasse.getWidth()) {
			strassenbewegungsposition = 0;
		}
		strasse_y = textfeldheight;
		batch.draw(img_strasse, strasse_x - strassenbewegungsposition, strasse_y, img_strasse.getWidth(), Gdx.graphics.getHeight() - textfeldheight);
		batch.draw(img_strasse, strasse_x - strassenbewegungsposition + img_strasse.getWidth(), strasse_y, img_strasse.getWidth(), Gdx.graphics.getHeight() - textfeldheight);
		//batch.draw(img_strasse, strasse_x+strassenbewegungsposition+img_strasse.getWidth(), strasse_y);

		batch.draw(img_amatur, 0, 0, Gdx.graphics.getWidth(), textfeldheight);

		glyphLayout.setText(font, anzeige_text);
		glyphLayout.setText(font, anzeige_text, new Color(1, 1, 1, 1), glyphLayout.width, (int) glyphLayout.height, false);
		font.draw(batch, glyphLayout, 100, textfeldheight / 2 + glyphLayout.height / 2);
		if (fehler){
			glyphLayout.setText(font, anzeige_text.substring(0, 1));
			glyphLayout.setText(font, anzeige_text.substring(0, 1), new Color(1, 0, 0, 1), glyphLayout.width, (int) glyphLayout.height, false);
			font.draw(batch, glyphLayout, 100, textfeldheight / 2 + glyphLayout.height / 2);
		}


		batch.draw(img_amaturrahmen, 0,0,Gdx.graphics.getWidth(),textfeldheight);


		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img_strasse.dispose();
	}
}
