package ca.omnihilstudios.projectjp;

import ca.omnihilstudios.projectjp.screens.ScreenEnum;
import ca.omnihilstudios.projectjp.screens.ScreenManager;
import com.badlogic.gdx.Game;

public class ProjectJP extends Game {

	private ScreenManager screenManager;

	public ProjectJP() {

	}

	@Override
	public void create() {
		screenManager = new ScreenManager(this);

		screenManager.showScreen(ScreenEnum.SPLASH_SCREEN);
	}

	public ScreenManager getScreenManager() {
		return screenManager;
	}

}
