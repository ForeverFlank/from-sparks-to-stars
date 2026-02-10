package logic;

public class Game {
    private final static Game instance = new Game();

    public final ResourceManager resourcesManager;
    public final EnergyManager energyManager;
    public final ResearchManager researchManager;

    public static Game getInstance() {
        return instance;
    }

    private Game() {

    }





}
