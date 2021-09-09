package ru.gb.sprite;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.gb.base.Ship;
import ru.gb.math.Rect;
import ru.gb.pool.BulletPool;

public class EnemyShip extends Ship {

    public EnemyShip(BulletPool bulletPool, Rect worldBounds) {
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
        this.bulletV = new Vector2();
        this.bulletPos = new Vector2();
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        this.bulletPos.set(pos.x, pos.y - getHalfHeight());
    }

    public void set(
            TextureRegion[] regions,
            Vector2 v0,
            TextureRegion bulletRegion,
            float bulletHeight,
            Vector2 bulletV,
            int bulletDamage,
            float reloadInterval,
            Sound bulletSound,
            float height,
            int hp
    ) {
        this.regions = regions;
        this.v0.set(v0);
        this.bulletRegion = bulletRegion;
        this.bulletHeight = bulletHeight;
        this.bulletV.set(bulletV);
        this.bulletDamage = bulletDamage;
        this.reloadInterval = reloadInterval;
        this.bulletSound = bulletSound;
        setHeightProportion(height);
        this.hp = hp;
        v.set(v0);
    }
}
