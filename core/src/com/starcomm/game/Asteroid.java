package com.starcomm.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
    private Vector2 position;
    private float speed;
    private Texture texture;

    public Rectangle getRect() { // узнать область астероида
        return new Rectangle(position.x, position.y, texture.getWidth(), texture.getHeight());
    }

    public Vector2 getPosition() {
        return position;
    }

    public Asteroid() {
        position = new Vector2(1300.0f + (float)(Math.random() * 1000), (float)Math.random() * 720);
        speed = 2.0f + (float)Math.random() * 10.0f;
        if(texture == null)
            texture = new Texture("asteroid60.tga");
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void update() {
        position.x -= speed;
        if(position.x < -80) {
            position.x = 1350;
        }
    }

    public void recreate() {
        position = new Vector2(1300.0f + (float)(Math.random() * 1000), (float)Math.random() * 720);
        speed = 2.0f + (float)Math.random() * 10.0f;
    }
}
