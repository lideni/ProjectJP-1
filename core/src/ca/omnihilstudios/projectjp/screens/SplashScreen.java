package ca.omnihilstudios.projectjp.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Sean on 1/26/2016.
 */
public class SplashScreen implements Screen {

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private TextureAtlas atlas;
    private TextureRegion background;
    private Sprite backgroundSprite;
    private TextureRegion logo;
    private Sprite logoSprite;
    private Music introTheme;

    private float deviceWidth, deviceHeight;
    private float deviceAspectRatio;

    static final int WORLD_WIDTH = 256;
    static final int WORLD_HEIGHT = 128;

    public SplashScreen() {
        deviceWidth = Gdx.graphics.getWidth();
        deviceHeight = Gdx.graphics.getHeight();
        deviceAspectRatio = deviceWidth / deviceHeight;

        batch = new SpriteBatch();
        atlas = new TextureAtlas("images/splash_screen.pack");

        background = atlas.findRegion("main_background");
        backgroundSprite = new Sprite(background);
        backgroundSprite.setPosition(0, 0);

        logo = atlas.findRegion("jp_logo");
        logoSprite = new Sprite(logo);
        logoSprite.setPosition(WORLD_WIDTH /2f - logoSprite.getWidth()/2f, WORLD_HEIGHT /2f - logoSprite.getHeight()/2f);

        camera = new OrthographicCamera(WORLD_HEIGHT * deviceAspectRatio, WORLD_HEIGHT);
        camera.position.set(WORLD_WIDTH / 2f, WORLD_HEIGHT /2f, 0);
        camera.update();

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
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        backgroundSprite.draw(batch);
        logoSprite.draw(batch);
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
        atlas.dispose();
        introTheme.dispose();
    }

}
