package ca.omnihilstudios.projectjp;

import ca.omnihilstudios.projectjp.screens.ScreenEnum;
import ca.omnihilstudios.projectjp.screens.ScreenManager;
import ca.omnihilstudios.projectjp.screens.SplashScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ProjectJP extends Game {
	
	@Override
	public void create () {
		ScreenManager.getInstance().initialize(this);
		ScreenManager.getInstance().showScreen(ScreenEnum.SPLASH_SCREEN);
	}

}
