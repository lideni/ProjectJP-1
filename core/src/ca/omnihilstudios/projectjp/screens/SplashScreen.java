package ca.omnihilstudios.projectjp.screens;

import ca.omnihilstudios.projectjp.ProjectJP;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Sean on 1/26/2016.
 */
public class SplashScreen extends AbstractScreen {

    private Music introTheme;

    static final float WORLD_WIDTH = 256f;
    static final float WORLD_HEIGHT = 128f;
    static final String TEXTURE_PACK = "images/splash_screen.pack";
    static final String BACKGROUND = "main_background";
    static final String LOGO = "jp_logo";

    public SplashScreen(ProjectJP game) {
        super(game);
    }

    @Override
    public void show() {
        Camera camera = new OrthographicCamera();
        Viewport viewport = new FillViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        atlas = new TextureAtlas(Gdx.files.internal(TEXTURE_PACK));

        Image background = new Image(atlas.findRegion(BACKGROUND));
        stage.addActor(background);

        Table table = new Table();
        table.setFillParent(true);
        Image logo = new Image(atlas.findRegion(LOGO));
        logo.addAction(
                Actions.sequence(
                        Actions.alpha(0),
                        Actions.moveBy(0f, -20f),
                        Actions.parallel(
                                Actions.moveBy(0f, 20f, 3f),
                                Actions.fadeIn(3f))));
        table.add(logo);
        stage.addActor(table);

        introTheme = Gdx.audio.newMusic(Gdx.files.internal("audio/intro_theme.mp3"));
        introTheme.setLooping(false);
        introTheme.setVolume(0.75f);
        introTheme.play();
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
        dispose();
    }

    @Override
    public void dispose() {
        super.dispose();
        introTheme.dispose();
    }

}
