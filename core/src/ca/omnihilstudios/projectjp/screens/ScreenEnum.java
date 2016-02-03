package ca.omnihilstudios.projectjp.screens;

import com.badlogic.gdx.Screen;

/**
 * Created by Sean on 1/26/2016.
 */
public enum ScreenEnum {

    SPLASH_SCREEN {
        public Screen getScreen(Object... params) {
            return new SplashScreen();
        }
    },
    MAIN_MENU_SCREEN {
        public Screen getScreen(Object... params) {
            return new MainMenuScreen();
        }
    };

    public abstract Screen getScreen(Object... params);
}
