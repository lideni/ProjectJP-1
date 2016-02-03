package ca.omnihilstudios.projectjp.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Sean on 1/26/2016.
 */
public class SplashScreen implements Screen {

    private SpriteBatch batch;
    private Texture img;
    private Music introTheme;

    public SplashScreen() {
        batch = new SpriteBatch();
        img = new Texture(Gdx.files.internal("images/title.png"));
        introTheme = Gdx.audio.newMusic(Gdx.files.internal("audio/intro_theme.mp3"));
        introTheme.setLooping(false);
        introTheme.setVolume(0.75f);
    }

    @Override
    public void show() {
        introTheme.play();
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
        introTheme.stop();
    }

    @Override
    public void resume() {
        introTheme.play();
    }

    @Override
    public void hide() {
        introTheme.stop();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        introTheme.dispose();
    }
}
