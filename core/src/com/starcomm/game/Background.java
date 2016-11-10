package com.starcomm.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {
    class Star {
        Vector2 position; // x y
        float speed;

        public Star() {
            this.position = new Vector2((float)(Math.random() * 1280), (float)(Math.random() * 720));
            this.speed = 1.0f + (float)(Math.random() * 10);
        }

        public void update() {
            position.x -= speed;
            if(position.x < 0)
                position.x = 1350;
        }
    }

    private Texture texture;
    private Texture texStar;
    private Star[] stars;

    public Background() {
        texture = new Texture("bg.png");
        texStar = new Texture("star12.tga");
        stars = new Star[300];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star();
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, 0, 0);
        for (int i = 0; i < stars.length; i++) {
            batch.draw(texStar, stars[i].position.x, stars[i].position.y);
        }
    }

    public void update() {
        for (int i = 0; i < stars.length; i++) {
            stars[i].update();
        }
    }
}
