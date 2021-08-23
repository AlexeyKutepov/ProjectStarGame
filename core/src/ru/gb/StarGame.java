package ru.gb;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class StarGame extends ApplicationAdapter {

	private SpriteBatch batch;
	private Texture img;
	private TextureRegion region;

	private float x;
	private float y;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		region = new TextureRegion(img, 100, 100, 100, 50);
	}

	@Override
	public void render () {
		x++; y++;
		ScreenUtils.clear(0.5f, 0.67f, 0.63f, 1f);
		batch.begin();
		batch.setColor(1f, 1f, 1f, 1f);
		batch.draw(img, x, y);
		batch.setColor(0.23f, 0.76f, 0.33f, 0.5f);
		batch.draw(img, 250, 250, 100, 100);
		batch.setColor(1f, 1f, 1f, 0.5f);
		batch.draw(region, 20, 34);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
