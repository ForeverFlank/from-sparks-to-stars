package croissius.logic.ship;

import croissius.math.BigNum;

public class BaseShip {

    private BigNum maxHealth;
    private BigNum maxShield;

    private BigNum health;
    private BigNum shield;

    private float baseMovementSpeed;
    private float posX;
    private float posY;

    public BaseShip(BigNum health, BigNum shield, float speed, float posX, float posY) {
        setMaxHealth(health);
        setHealth(health);
        setMaxShield(shield);
        setShield(shield);
        
        setBaseMovementSpeed(speed);
        setPosX(posX);
        setPosY(posY);
    }

    public BigNum getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(BigNum maxHealth) {
        this.maxHealth = BigNum.max(maxHealth, BigNum.ZERO);
    }

    public BigNum getMaxShield() {
        return maxShield;
    }

    public void setMaxShield(BigNum maxShield) {
        this.maxShield = BigNum.max(maxShield, BigNum.ZERO);
    }

    public BigNum getHealth() {
        return health;
    }

    public void setHealth(BigNum health) {
        this.health = BigNum.clamp(health, BigNum.ZERO, maxHealth);
    }

    public BigNum getShield() {
        return shield;
    }

    public void setShield(BigNum shield) {
        this.shield = BigNum.clamp(shield, BigNum.ZERO, maxShield);
    }

    public float getBaseMovementSpeed() {
        return baseMovementSpeed;
    }

    public void setBaseMovementSpeed(float baseMovementSpeed) {
        this.baseMovementSpeed = Math.max(baseMovementSpeed, 0);
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;   // TODO: clamp to game's min max pos
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }
    
}