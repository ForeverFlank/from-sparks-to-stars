package manager;

public class Game {
    private static Game instance;

    public final EnergyManager energyManager;
    public final ItemManager itemManager;
    public final RecipeManager recipeManager;
    public final ResearchManager researchManager;

    public static void init() { instance = new Game(); }
    public static Game getInstance() {
        return instance;
    }

    private Game() {
        energyManager = new EnergyManager();
        itemManager = new ItemManager();
        recipeManager = new RecipeManager();
        researchManager = new ResearchManager();
    }
}
