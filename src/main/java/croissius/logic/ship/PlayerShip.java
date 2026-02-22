package croissius.logic.ship;

import croissius.manager.InputManager;
import croissius.math.BigNum;
import javafx.scene.input.KeyCode;

public class PlayerShip extends BaseShip {

    public PlayerShip(BigNum health, BigNum shield, float speed, float posX, float posY) {
        super(health, shield, speed, posX, posY);
    }

    public void update(double dt) {
        float moveX = 0f;
        float moveY = 0f;

        if (InputManager.isPressed(KeyCode.A)) {
            moveX -= 1.0f;
        }
        if (InputManager.isPressed(KeyCode.D)) {
            moveX += 1.0f;
        }

        float magnitude = (float) Math.sqrt(moveX * moveX + moveY * moveY);
        float normalizedMoveX = moveX / magnitude;
        float normalizedMoveY = moveY / magnitude;

        setPosX(getPosX() + normalizedMoveX);
        setPosY(getPosY() + normalizedMoveY);
    }

}