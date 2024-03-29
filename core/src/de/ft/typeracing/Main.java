package de.ft.typeracing;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import de.ft.typeracing.car.AutonomCar;
import de.ft.typeracing.car.Car;
import de.ft.typeracing.car.steuerung.NormalSteuerung;


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

	public static long timebetweenpresses=0;
	public static long presses=0;

	public static long timelastpress=0;

	public static Texture img_car1;
	public static Texture  img_car2;
	public static Texture img_car3;


	public static Car spielerauto;

	public static AutonomCar gegnerauto_1;
	public static AutonomCar gegnerauto_2;
	public static AutonomCar gegnerauto_3;
	public static AutonomCar gegnerauto_4;


	private static boolean fehlercounted = false;
	public static int fehlercounter = 0;
	public static long millissave2=0;

 public static float cpm = 0;


	public static int h_strasse=0;

	public static float durchschnittsspeedrechner=0;
	public static float values =0;
	public static float durchschnittsspeed=0;




	@Override
	public void create () {
		img_car1 = new Texture("cars/1_car.png");
		img_car2 = new Texture("cars/2_car.png");
		img_car3 = new Texture("cars/3_car.png");

		spielerauto=new Car(new NormalSteuerung(),img_car1,200,textfeldheight,100,50);

		gegnerauto_1=new AutonomCar(img_car2,1f,0.6f,0f);
		gegnerauto_2=new AutonomCar(img_car3,1f,0.6f,0f);
		gegnerauto_3=new AutonomCar(img_car2,1f,0.6f,0f);
		gegnerauto_4=new AutonomCar(img_car3,1f,0.6f,0f);



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
					speed=spielerauto.getCarSteuerung().correctKeyTyped(speed);
					fehler=false;

					if(presses>0) {


						//Calc CPM
						if(System.currentTimeMillis()-timelastpress<4000) {
							presses++;
							timebetweenpresses = timebetweenpresses + System.currentTimeMillis() - timelastpress;
							timelastpress = System.currentTimeMillis();
							cpm = (60000f/((float)timebetweenpresses / (float) presses));
						}else{
							timelastpress = System.currentTimeMillis();
						}


					}else{
						presses=1;
						timelastpress = System.currentTimeMillis();
					}

				}else{
					fehler=true;

					speed=spielerauto.getCarSteuerung().fehler(speed);

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


		gegnerauto_1.setX(200);
		gegnerauto_2.setX(200);
		gegnerauto_3.setX(200);
		gegnerauto_4.setX(200);
neuesSpiel();
	}

	public synchronized static void durchschnittsspeed(float speed){
		values++;
		durchschnittsspeedrechner+=speed;
		durchschnittsspeed=durchschnittsspeedrechner/values;
		Gdx.app.log("durchschnittsspeed: ",String.valueOf(durchschnittsspeed)+"  speed: "+Main.speed);


		if(values>30) {

			durchschnittsspeedrechner=durchschnittsspeedrechner/values;
			durchschnittsspeed = durchschnittsspeedrechner;
			values=1;

		}

		gegnerauto_1.setSollSpeed(durchschnittsspeed);
		gegnerauto_2.setSollSpeed(durchschnittsspeed);
		gegnerauto_3.setSollSpeed(durchschnittsspeed);
		gegnerauto_4.setSollSpeed(durchschnittsspeed);



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
			current_text = "You found an Easteregg. Viel Spaß damit noch! Vielen dank für die benutzung von TypeRacing!";
			anzeige_text = current_text;
		}

			speed=spielerauto.getCarSteuerung().dagegenarbeiter(speed);

		if (System.currentTimeMillis() > millissave2) {
			durchschnittsspeed(speed);
			millissave2=System.currentTimeMillis()+500;
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
		strassenbewegungsposition +=  speed;
		if (strassenbewegungsposition > img_strasse.getWidth()) {
			strassenbewegungsposition = 0;
		}
		strasse_y = textfeldheight;

		h_strasse=Gdx.graphics.getHeight() - textfeldheight;

		batch.draw(img_strasse, strasse_x - strassenbewegungsposition, strasse_y, img_strasse.getWidth(), h_strasse);
		batch.draw(img_strasse, strasse_x - strassenbewegungsposition + img_strasse.getWidth(), strasse_y, img_strasse.getWidth(), h_strasse);

		batch.draw(img_amatur, 0, 0, Gdx.graphics.getWidth(), textfeldheight);

		glyphLayout.setText(font, anzeige_text);
		glyphLayout.setText(font, anzeige_text, new Color(1, 1, 1, 1), glyphLayout.width, (int) glyphLayout.height, false);
		font.draw(batch, glyphLayout, 100, textfeldheight / 2 + glyphLayout.height / 2);
		if (fehler){

			if(!fehlercounted) {
				fehlercounter++;
				fehlercounted = true;
			}

			glyphLayout.setText(font, anzeige_text.substring(0, 1));
			glyphLayout.setText(font, anzeige_text.substring(0, 1), new Color(1, 0, 0, 1), glyphLayout.width, (int) glyphLayout.height, false);
			font.draw(batch, glyphLayout, 100, textfeldheight / 2 + glyphLayout.height / 2);
		}

		if(!fehler&&fehlercounted) {
			fehlercounted = false;
		}



		batch.draw(img_amaturrahmen, 0,0,Gdx.graphics.getWidth(),textfeldheight);

		float autoverkleinerung=0.28f;

		spielerauto.setBounds(200,(int)(strasse_y+(h_strasse/10*5)-h_strasse/2*autoverkleinerung/2),(int)(h_strasse*autoverkleinerung),(int)(h_strasse/2*autoverkleinerung));
		spielerauto.draw(batch);


		gegnerauto_1.setBounds((int)(strasse_y+(h_strasse/10*1)-h_strasse/2*autoverkleinerung/2),(int)(h_strasse*autoverkleinerung),(int)(h_strasse/2*autoverkleinerung));
		gegnerauto_1.draw(batch);
		gegnerauto_2.setBounds((int)(strasse_y+(h_strasse/10*3)-h_strasse/2*autoverkleinerung/2),(int)(h_strasse*autoverkleinerung),(int)(h_strasse/2*autoverkleinerung));
		gegnerauto_2.draw(batch);
		gegnerauto_3.setBounds((int)(strasse_y+(h_strasse/10*7)-h_strasse/2*autoverkleinerung/2),(int)(h_strasse*autoverkleinerung),(int)(h_strasse/2*autoverkleinerung));
		gegnerauto_3.draw(batch);
		gegnerauto_4.setBounds((int)(strasse_y+(h_strasse/10*9)-h_strasse/2*autoverkleinerung/2),(int)(h_strasse*autoverkleinerung),(int)(h_strasse/2*autoverkleinerung));
		gegnerauto_4.draw(batch);


		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img_strasse.dispose();
	}
}
