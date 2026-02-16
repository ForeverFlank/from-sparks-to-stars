package fsts.logic.tier;

public enum TechTier {

    PRIMITIVE (1, "Primitive Age" ),
    MEDIEVAL  (2, "Medieval Age"  ),
    INDUSTRIAL(3, "Industrial Age"),
    ELECTRICAL(4, "Electrical Age"),
    RENEWABLE (5, "Renewable Age" ),
    SPACE     (6, "Space Age"     ),
    STELLAR   (7, "Stellar Age"   ),
    GALACTIC  (8, "Galactic Age"  ),
    COSMIC    (9, "Cosmic Age"    );

    private final int level;
    private final String name;

    TechTier(int level, String name) {
        this.level = level;
        this.name = name;
    }
}

