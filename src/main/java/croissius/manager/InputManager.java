package croissius.manager;

import java.util.HashSet;
import java.util.Set;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class InputManager {

    private static final Set<KeyCode> pressedKeys = new HashSet<>();

    public InputManager(Scene scene) {

        scene.setOnKeyPressed(event ->
            pressedKeys.add(event.getCode())
        );

        scene.setOnKeyReleased(event ->
            pressedKeys.remove(event.getCode())
        );
    }

    public static boolean isPressed(KeyCode key) {
        return pressedKeys.contains(key);
    }
}