package com.starcomm.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Background bg;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		bg = new Background();
	}

	@Override
	public void render () { // этот метод вызывается как правило 60 раз в секунду
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1); // RGBA
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin(); // всё что мы хотим отрисовать, должно находиться между batch.begin()...
		bg.render(batch);
		batch.end(); // ... и batch.end()
	}

	public void update() { // этот метод будет отвечать за всю игровую логику
		bg.update();
	}
}
