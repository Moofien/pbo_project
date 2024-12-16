package io.github.some_example_name.gameobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import io.github.some_example_name.managers.GameManager;
public class Mole {
    public Sprite moleSprite;//to display the mole
    public Vector2 position = new Vector2();//mole position
    public float height,width;

    public float scaleFactor = 4000f;

    public enum State{GOINGUP,GOINGDOWN,UNDERGROUND,SNED};
    public State state = State.GOINGUP;
    public float currentHeight = 0.0f;
    public float speed =2f;

    public void update(){
        //draw some
        moleSprite.setRegion(0,0,(int)(width/scaleFactor),(int)(currentHeight/scaleFactor));
        moleSprite.setSize(moleSprite.getWidth(),currentHeight);

    }
    public void render(SpriteBatch batch) {
        moleSprite.draw(batch);
    }

        public boolean handleTouch(float touchX, float touchY) {
            if ((touchX>=position.x)&&touchX<=(position.x+width) && (touchY>=position.y)&&touchY<=(position.y+currentHeight)){
                return true;
            }
            return false;
    }
}
