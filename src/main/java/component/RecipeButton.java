package component;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.recipe.Recipe;
import logic.recipe.RecipeInput;
import logic.recipe.RecipeOutput;
import manager.Game;

import java.math.RoundingMode;
import java.util.ArrayList;

public class RecipeButton extends Button {
    public final Recipe recipe;
    private final VBox vBox;

    public RecipeButton(Recipe recipe) {
        this.recipe = recipe;

        setMinSize(100, 50);

        String recipeName = recipe.displayName;
        ArrayList<RecipeInput> recipeInputs = recipe.inputs;
        ArrayList<RecipeOutput> recipeOutputs = recipe.outputs;

        Text recipeText = new Text(recipeName);
        recipeText.setFont(new Font(12));

        vBox = new VBox();
        vBox.getChildren().add(recipeText);

        for (RecipeInput recipeInput : recipeInputs) {
            String itemName = recipeInput.getItemDisplayName();
            String itemQuantity = recipeInput.quantity.format(
                    3,
                    1e3,
                    RoundingMode.HALF_UP,
                    false);
            String recipeInputString = "< " + itemQuantity + " " + itemName;

            Text recipeInputText = new Text(recipeInputString);
             recipeInputText.setFont(new Font(10));
             vBox.getChildren().add(recipeInputText);
        }

        for (RecipeOutput recipeOutput : recipeOutputs) {
            String itemName = recipeOutput.getItemDisplayName();
            String itemQuantity = recipeOutput.quantity.format(
                    3,
                    1e3,
                    RoundingMode.HALF_UP,
                    false);
            String recipeOutputString = "> " + itemQuantity + " " + itemName;

            Text recipeOutputText = new Text(recipeOutputString);
            recipeOutputText.setFont(new Font(10));
            vBox.getChildren().add(recipeOutputText);
        }

        setGraphic(vBox);

        setOnAction(_ -> onClick());
    }

    public void onClick() {
        Game.getInstance().useRecipe(recipe);
    }
}
