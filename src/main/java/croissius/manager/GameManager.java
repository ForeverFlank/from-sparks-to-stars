package croissius.manager;

import croissius.logic.ship.PlayerShip;
import croissius.math.BigNum;
import javafx.animation.AnimationTimer;

public class GameManager {

    private static GameManager instance;
    private final ShooterManager shooterManager;

    public static void initialize() {
        instance = new GameManager();
    }

    public static GameManager getInstance() {
        return instance;
    }

    private GameManager() {

        shooterManager = new ShooterManager(new PlayerShip(
                new BigNum(100),
                new BigNum(100),
                20, 50, 50
        ));

        new AnimationTimer() {

            private final double dt = 1.0 / 60.0;
            private long lastTime = 0;
            private double accumulator = 0;

            @Override
            public void handle(long now) {
                if (lastTime > 0) {
                    double deltaTime = (now - lastTime) / 1_000_000_000.0;
                    accumulator += deltaTime;

                    while (accumulator >= dt) {
                        update(dt);
                        accumulator -= dt;
                    }
                }
                lastTime = now;
            }
        }.start();
    }

    private void update(double dt) {
        shooterManager.update(dt);
    }

    public ShooterManager getShooterManager() {
        return shooterManager;
    }
}
