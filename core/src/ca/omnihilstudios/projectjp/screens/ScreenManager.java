package ca.omnihilstudios.projectjp.screens;

import ca.omnihilstudios.projectjp.ProjectJP;
import com.badlogic.gdx.Screen;

/**
 * Created by Sean on 1/26/2016.
 */
public class ScreenManager {

    private final ProjectJP game;

    public ScreenManager(ProjectJP game) {
        this.game = game;
    }

    public void showScreen(ScreenEnum screenEnum, Object... params) {
        // Get current screen to dispose of it
        Screen currentScreen = game.getScreen();

        // Show new screen
        AbstractScreen newScreen;
        switch(screenEnum) {
            case SPLASH_SCREEN:
                newScreen = new SplashScreen(game);
                break;
            default:
                newScreen = null;
        }
        game.setScreen(newScreen);

        // Dispose of previous screen
        if (currentScreen != null) {
            currentScreen.dispose();
        }
    }

}
