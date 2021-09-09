package ru.gb.utils;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import ru.gb.math.Rect;
import ru.gb.pool.EnemyPool;
import ru.gb.sprite.EnemyShip;

public class EnemyEmitter {

    private static final float GENERATE_INTERVAL = 4f;

    private static final float ENEMY_SMALL_HEIGHT = 0.1f;
    private static final float ENEMY_SMALL_BULLET_HEIGHT = 0.01f;
    private static final int ENEMY_SMALL_BULLET_DAMAGE = 1;
    private static final float ENEMY_SMALL_RELOAD_INTERVAL = 3f;
    private static final int ENEMY_SMALL_HP = 1;

    private static final float ENEMY_MEDIUM_HEIGHT = 0.15f;
    private static final float ENEMY_MEDIUM_BULLET_HEIGHT = 0.02f;
    private static final int ENEMY_MEDIUM_BULLET_DAMAGE = 5;
    private static final float ENEMY_MEDIUM_RELOAD_INTERVAL = 4f;
    private static final int ENEMY_MEDIUM_HP = 5;

    private static final float ENEMY_BIG_HEIGHT = 0.2f;
    private static final float ENEMY_BIG_BULLET_HEIGHT = 0.04f;
    private static final int ENEMY_BIG_BULLET_DAMAGE = 10;
    private static final float ENEMY_BIG_RELOAD_INTERVAL = 1f;
    private static final int ENEMY_BIG_HP = 10;

    private final Vector2 enemySmallBulletV = new Vector2(0, -0.3f);
    private final Vector2 enemyMediumBulletV = new Vector2(0, -0.25f);
    private final Vector2 enemyBigBulletV = new Vector2(0, -0.3f);
    private final Vector2 enemySmallV = new Vector2(0, -0.2f);
    private final Vector2 enemyMediumV = new Vector2(0, -0.03f);
    private final Vector2 enemyBigV = new Vector2(0, -0.005f);

    private final Rect worldBounds;
    private final Sound bulletSound;

    private float generateTimer;

    private final TextureRegion[] enemySmallRegions;
    private final TextureRegion[] enemyMediumRegions;
    private final TextureRegion[] enemyBigRegions;
    private final TextureRegion bulletRegion;

    private final EnemyPool enemyPool;

    public EnemyEmitter(TextureAtlas atlas, EnemyPool enemyPool, Rect worldBounds, Sound bulletSound) {
        this.enemyPool = enemyPool;
        this.worldBounds = worldBounds;
        this.bulletSound = bulletSound;
        enemySmallRegions = Regions.split(atlas.findRegion("enemy0"), 1, 2, 2);
        enemyMediumRegions = Regions.split(atlas.findRegion("enemy1"), 1, 2, 2);
        enemyBigRegions = Regions.split(atlas.findRegion("enemy2"), 1, 2, 2);
        bulletRegion = atlas.findRegion("bulletEnemy");
    }

    public void generate(float delta) {
        generateTimer += delta;
        if (generateTimer >= GENERATE_INTERVAL) {
            generateTimer = 0f;
            EnemyShip enemyShip = enemyPool.obtain();
            float type = (float) Math.random();
            if (type < 0.5f) {
                enemyShip.set(
                        enemySmallRegions,
                        enemySmallV,
                        bulletRegion,
                        ENEMY_SMALL_BULLET_HEIGHT,
                        enemySmallBulletV,
                        ENEMY_SMALL_BULLET_DAMAGE,
                        ENEMY_SMALL_RELOAD_INTERVAL,
                        bulletSound,
                        ENEMY_SMALL_HEIGHT,
                        ENEMY_SMALL_HP
                );
            } else if (type < 0.8f) {
                enemyShip.set(
                        enemyMediumRegions,
                        enemyMediumV,
                        bulletRegion,
                        ENEMY_MEDIUM_BULLET_HEIGHT,
                        enemyMediumBulletV,
                        ENEMY_MEDIUM_BULLET_DAMAGE,
                        ENEMY_MEDIUM_RELOAD_INTERVAL,
                        bulletSound,
                        ENEMY_MEDIUM_HEIGHT,
                        ENEMY_MEDIUM_HP
                );
            } else {
                enemyShip.set(
                        enemyBigRegions,
                        enemyBigV,
                        bulletRegion,
                        ENEMY_BIG_BULLET_HEIGHT,
                        enemyBigBulletV,
                        ENEMY_BIG_BULLET_DAMAGE,
                        ENEMY_BIG_RELOAD_INTERVAL,
                        bulletSound,
                        ENEMY_BIG_HEIGHT,
                        ENEMY_BIG_HP
                );
            }
            enemyShip.pos.x = MathUtils.random(
                    worldBounds.getLeft() + enemyShip.getHalfWidth(),
                    worldBounds.getRight() - enemyShip.getHalfWidth()
            );
            enemyShip.setBottom(worldBounds.getTop());
        }
    }
}
