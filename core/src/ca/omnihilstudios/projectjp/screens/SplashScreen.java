package ca.omnihilstudios.projectjp.screens;

import ca.omnihilstudios.projectjp.ProjectJP;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Sean on 1/26/2016.
 */
public class SplashScreen implements Screen {

    private ProjectJP jpGame;
    private SpriteBatch batch;
    private Texture img;

    public SplashScreen(ProjectJP jpGame) {
        this.jpGame = jpGame;

        batch = new SpriteBatch();
        img = new Texture("title.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
