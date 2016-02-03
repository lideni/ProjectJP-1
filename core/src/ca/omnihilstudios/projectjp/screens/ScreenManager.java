package ca.omnihilstudios.projectjp.screens;

import ca.omnihilstudios.projectjp.ProjectJP;
import com.badlogic.gdx.Screen;

/**
 * Created by Sean on 1/26/2016.
 */
public class ScreenManager {

    private static ScreenManager instance = new ScreenManager();
    private ProjectJP game;

    private ScreenManager() {
        super();
    }

    public static ScreenManager getInstance() {
        return instance;
    }

    // Initialization
    public void initialize(ProjectJP game) {
        this.game = game;
    }

    // Show the screen retrieved from the enum
    public void showScreen(ScreenEnum screenEnum, Object... params) {
        // Get current screen to dispose of it
        Screen currentScreen = game.getScreen();

        // Show new screen
        Screen newScreen = screenEnum.getScreen(params);
        game.setScreen(newScreen);

        // Dispose of previous screen
        if (currentScreen != null) {
            currentScreen.dispose();
        }
    }

}
