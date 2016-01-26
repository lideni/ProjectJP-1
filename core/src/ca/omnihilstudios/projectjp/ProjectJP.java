package ca.omnihilstudios.projectjp;

import ca.omnihilstudios.projectjp.screens.SplashScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ProjectJP extends Game {

	private SplashScreen splashScreen;
	
	@Override
	public void create () {
		splashScreen = new SplashScreen(this);
		setScreen(splashScreen);
	}

}
