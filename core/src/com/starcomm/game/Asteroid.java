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
    private float angle;

    public Rectangle getRect() { // узнать область астероида
        return new Rectangle(position.x, position.y, texture.getWidth(), texture.getHeight());
    }

    public Vector2 getPosition() {
        return position;
    }

    public Asteroid() {
        position = new Vector2(1300.0f + (float)(Math.random() * 1000), (float)Math.random() * 720);
        speed = 2.0f + (float)Math.random() * 10.0f;
        angle = (float)Math.random() * 360;
        if(texture == null)
            texture = new Texture("asteroid60.tga");
    }

    public void render(SpriteBatch batch) {
//        batch.draw(texture, position.x, position.y);
        batch.draw(texture, position.x, position.y,30,30,60,60,1,1,angle,0,0,60,60,false,false);
    }

    public void update() {
        angle += 0.0f + (float)(Math.random() * 4);
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
