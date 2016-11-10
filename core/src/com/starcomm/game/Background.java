package com.starcomm.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {
    class Star {
        Vector2 position; // x y
        float speed;
        private int size;

        public Star() {
            this.position = new Vector2((float)(Math.random() * Gdx.graphics.getWidth()), (float)(Math.random() * Gdx.graphics.getHeight()));
            this.speed = 0.5f + (float)(Math.random() * 5.0f);
            size = (int)(6 * (this.speed)); // this можно и не писать в данном случае
        }

        public void update() {
            position.x -= speed;
            if (position.x < 0)
                position.x = 1350;
        }
    }

    private Texture texture;
    private Texture texStar;
    private Star[] stars;
    private final int STARS_COUNT = 200;

    public Background() {
        texture = new Texture("bg.png");
        texStar = new Texture("star12.tga");
        stars = new Star[STARS_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star();
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, 0, 0);
        for (int i = 0; i < stars.length; i++) {
            //batch.draw(texStar, stars[i].position.x, stars[i].position.y);
            batch.draw(texStar, stars[i].position.x, stars[i].position.y, stars[i].size, stars[i].size);
        }
    }

    public void update() {
        for (int i = 0; i < stars.length; i++) {
            stars[i].update();
        }
    }
}
