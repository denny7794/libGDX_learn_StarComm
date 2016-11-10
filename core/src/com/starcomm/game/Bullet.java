package com.starcomm.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Denis on 10.11.2016.
 */
public class Bullet {
    private Vector2 position;
    private float speed;
    private Texture texture;
    private boolean active;

    public boolean isActive(){
        return active;
    }

    public Bullet() {
        position = new Vector2(0.0f, 0.0f);
        speed = 5.0f;
        active = false;
        if(texture == null)
            texture = new Texture("bullet20.tga");
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void destroy() {
        active = false;
    }

    public void setup(float x, float y) {
        position.x = x;
        position.y = y;
        active = true;
    }

    public void update() {
        position.x += speed;
        if(position.x > 1350) {
            active = false;
        }
    }
}
