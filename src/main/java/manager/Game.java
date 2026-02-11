package manager;

public class Game {
    private final static Game instance = new Game();

    public final EnergyManager energyManager;
    public final ItemManager itemManager;
    public final ResearchManager researchManager;

    public static Game getInstance() {
        return instance;
    }

    private Game() {
        energyManager = new EnergyManager();
        itemManager = new ItemManager();
        researchManager = new ResearchManager();
    }


}
