package croissius.component;

import croissius.manager.GameManager;
import croissius.manager.ShooterManager;
import javafx.scene.layout.Pane;


class ShooterPane extends Pane {

    

    public void update() {
        ShooterManager shooterManager = GameManager.getInstance().getShooterManager();


    }
}
