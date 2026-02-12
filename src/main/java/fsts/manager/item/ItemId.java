package fsts.manager.item;

public record ItemId(String value) {
    public static final ItemId ENERGY = new ItemId("energy");
}
