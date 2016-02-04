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

    private float width, height;
    private float aspectRatio;

    static final int WORLD_WIDTH = 1024;
    static final int WORLD_HEIGHT = 512;

    public SplashScreen() {
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        aspectRatio = width / height;

        batch = new SpriteBatch();
        atlas = new TextureAtlas("images/splash_screen.pack");
        background = atlas.findRegion("main_screen_bkg");
        backgroundSprite = new Sprite(background);
        backgroundSprite.setPosition(0, 0);
        backgroundSprite.setSize(WORLD_WIDTH, WORLD_HEIGHT);
        logo = atlas.findRegion("title");
        logoSprite = new Sprite(logo);
        logoSprite.setScale(0.3f);
        logoSprite.setPosition(WORLD_WIDTH/2f - logoSprite.getWidth()/2f, WORLD_HEIGHT/2f - logoSprite.getHeight()/2f);

        camera = new OrthographicCamera(WORLD_HEIGHT * aspectRatio, WORLD_HEIGHT);
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
