package croissius.manager;


import croissius.logic.ship.PlayerShip;

public class ShooterManager {
    
    private PlayerShip playerShip;

    public ShooterManager(PlayerShip playerShip) {
        this.playerShip = playerShip;
    }

    public void update(double dt) {
        playerShip.update(dt);
    }


}