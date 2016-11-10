package com.starcomm.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Hero {
    private Vector2 position;
    private float speed;
    private Texture texture;

    public Hero() {
        position = new Vector2(100.0f, 100.0f);
        speed = 4.0f;
        texture = new Texture("ship80x60.tga");
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void update() {
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            position.y += speed;
            if(position.y > 730) {
                position.y = -70;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            position.y -= speed;
            if(position.y < -70) {
                position.y = 730;
            }
        }
    }
}
