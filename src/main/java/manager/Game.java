package manager;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import logic.recipe.Recipe;
import logic.recipe.RecipeInput;
import logic.recipe.RecipeOutput;
import manager.item.ItemManager;
import manager.recipe.RecipeManager;
import math.BigNum;

public class Game {
    private static Game instance;

    public final ItemManager itemManager;
    public final RecipeManager recipeManager;
    public final ResearchManager researchManager;
    public final TimeManager timeManager;

    public static void init() {
        instance = new Game();
    }

    public static Game getInstance() {
        return instance;
    }

    private Game() {
        itemManager = new ItemManager();
        recipeManager = new RecipeManager();
        researchManager = new ResearchManager();
        timeManager = new TimeManager();

        itemManager.setQuantity("energy", new BigNum(10));

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.05), _ -> step());
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void step() {

    }

    public boolean useRecipe(Recipe recipe) {
        for (RecipeInput input : recipe.inputs) {
            if (!itemManager.hasEnough(input.itemName, input.quantity)) {
                return false;
            }
        }

        for (RecipeInput input : recipe.inputs) {
            itemManager.remove(input.itemName, input.quantity);
        }

        for (RecipeOutput output : recipe.outputs) {
            itemManager.add(output.itemName, output.quantity);
        }

        return true;
    }
}
