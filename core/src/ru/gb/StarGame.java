package ru.gb;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
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

		Vector2 v1 = new Vector2(2, 1);
		Vector2 v2 = new Vector2(2, 2);
		v1.add(v2);
		System.out.println("v1.add(v2) v1.x = " + v1.x + " v1.y = " + v1.y);

		v1.set(10, 2);
		v2.set(4, 8);
		v1.sub(v2);
		System.out.println("v1.sub(v2) v1.x = " + v1.x + " v1.y = " + v1.y);

		System.out.println("v1.len = " + v1.len());

		v1.setLength(100);
		System.out.println("v1.len = " + v1.len());
		System.out.println("v1 v1.x = " + v1.x + " v1.y = " + v1.y);
		v1.scl(0.95f);
		System.out.println("v1.len = " + v1.len());
		System.out.println("v1 v1.x = " + v1.x + " v1.y = " + v1.y);
		v1.nor();
		System.out.println("v1.len = " + v1.len());

		System.out.println("v1 v1.x = " + v1.x + " v1.y = " + v1.y);
		Vector2 v3 = v1.cpy().add(v2);
		System.out.println("v1 v1.x = " + v1.x + " v1.y = " + v1.y);
		System.out.println("v3.sub(v2) v3.x = " + v3.x + " v3.y = " + v3.y);

		v1.set(1, 1);
		v2.set(-1, 1);
		v1.nor();
		v2.nor();
		System.out.println(Math.acos(v1.dot(v2)));
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
