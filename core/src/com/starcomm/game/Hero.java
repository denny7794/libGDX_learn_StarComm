package com.starcomm.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Hero {
    private Vector2 position;
    private float speed;
    private Texture texture;
    private int firetimer;
    private final int FIRE_RATE = 10;
    private int hp = 5;

    public Hero() {
        position = new Vector2(100.0f, 100.0f);
        speed = 4.0f;
        texture = new Texture("ship80x60.tga");
        firetimer = 0;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getRect() { // узнать область астероида
        return new Rectangle(position.x, position.y, texture.getWidth(), texture.getHeight());
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void getDamage(int x){
        hp -= x;
        if(hp <= 0)
            destroy();
    }

    public void destroy() {
        position.x = -100;
        position.y = -100;
    }

    public void update() {
        if (hp > 0) {
            if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                position.y += speed;
                if (position.y > 730) {
                    position.y = -70;
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                position.y -= speed;
                if (position.y < -70) {
                    position.y = 730;
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                position.x -= speed;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                position.x += speed;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                firetimer++;
                if (firetimer > FIRE_RATE) {
                    firetimer = 0;
                    for (int i = 0; i < MyGdxGame.bullets.length; i++) {
                        if (!MyGdxGame.bullets[i].isActive()) {
                            MyGdxGame.bullets[i].setup(position.x + 60, position.y + 15);
                            break;
                        }
                    }
                }
            }
        }
    }
}
