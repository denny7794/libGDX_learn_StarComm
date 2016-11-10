package com.starcomm.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	final int ASTEROID_COUNT = 20;
	SpriteBatch batch;
	Background bg;
	Hero hero;
	Asteroid[] asteroids;
	public static Bullet[] bullets;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		bg = new Background();
		hero = new Hero();
		asteroids = new Asteroid[ASTEROID_COUNT];
		for (int i = 0; i < ASTEROID_COUNT; i++) {
			asteroids[i] = new Asteroid();
		}
		bullets = new Bullet[50];
		for (int i = 0; i < bullets.length; i++) {
			bullets[i] = new Bullet();
		}
	}

	@Override
	public void render () { // этот метод вызывается как правило 60 раз в секунду
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1); // RGBA
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin(); // всё что мы хотим отрисовать, должно находиться между batch.begin()...
		bg.render(batch);
		hero.render(batch);
		for (int i = 0; i < ASTEROID_COUNT; i++) {
			asteroids[i].render(batch);
		}
		for (int i = 0; i < bullets.length; i++) {
			if(bullets[i].isActive())
				bullets[i].render(batch);
		}
		batch.end(); // ... и batch.end()
	}

	public void update() { // этот метод будет отвечать за всю игровую логику
		bg.update();
		hero.update();
		for (int i = 0; i < ASTEROID_COUNT; i++) {
			asteroids[i].update();
		}
		for (int i = 0; i < bullets.length; i++) {
			if(bullets[i].isActive())
				bullets[i].update();
		}
		for (int i = 0; i < asteroids.length; i++) {
			for (int j = 0; j < bullets.length; j++) {
				if(asteroids[i].getPosition().cpy().sub(bullets[j].getPosition()).len() < 20) { // проверяем столкновение астероида с пулей
					asteroids[i].recreate();
					bullets[j].destroy();
				}
			}
		}
	}
}
