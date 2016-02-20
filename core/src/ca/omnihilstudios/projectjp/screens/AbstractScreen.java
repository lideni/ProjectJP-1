package ca.omnihilstudios.projectjp.screens;

import ca.omnihilstudios.projectjp.ProjectJP;
import com.badlogic.gdx.Screen;

/**
 * Created by Sean on 2/20/2016.
 */
public abstract class AbstractScreen implements Screen {

    protected final ProjectJP game;

    public AbstractScreen(ProjectJP game) {
        this.game = game;
    }

}
