//whack A Mole

package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.some_example_name.managers.GameManager;



/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class WhackAMole extends ApplicationAdapter {
    //private
    SpriteBatch batch; //for drawing
    OrthographicCamera camera;
    private Texture image;

    @Override
    public void create() {
        //set dimensi
        float height = Gdx.graphics.getHeight();
        float width = Gdx.graphics.getWidth();
        //camera viewpoint
        camera = new OrthographicCamera(width,height);
        //center the camera at w/2, h/2
        camera.setToOrtho(false);

        batch = new SpriteBatch();
        //initialize the game
        GameManager.initialize(width,height);

    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        GameManager.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //set the spritebatch
        batch.setProjectionMatrix(camera.combined);
        //render game object
        batch.begin();
        GameManager.renderGame(batch);
        batch.end();
    }

}
