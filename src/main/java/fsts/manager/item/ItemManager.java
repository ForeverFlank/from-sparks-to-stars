package fsts.manager.item;

import fsts.logic.item.Item;
import fsts.math.BigNum;
import fsts.util.ResourceUtils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ItemManager {
    private final Map<ItemId, Item> itemById;
    private final Map<ItemId, BigNum> itemAmounts;

    public ItemManager() {
        itemById = new HashMap<>();
        itemAmounts = new HashMap<>();

        Item energy = new Item(ItemId.ENERGY, "Energy");
        itemById.put(ItemId.ENERGY, energy);

        loadAllItems();
    }

    private void loadAllItems() {
        Map<String, InputStream> inputStreams = ResourceUtils.loadResourceFiles("items");

        for (InputStream stream : inputStreams.values()) {
            HashMap<ItemId, Item> items = ItemParser.parseItems(stream);
            itemById.putAll(items);
        }

        for (ItemId itemId : itemById.keySet()) {
            itemAmounts.put(itemId, new BigNum(0));
        }

        System.out.println(itemById.size() + " items loaded.");
    }

    public Item getItem(ItemId name) {
        return itemById.get(name);
    }

    public Set<ItemId> getAllItems() {
        return itemById.keySet();
    }

    public BigNum getAmount(ItemId itemName) {
        return itemAmounts.get(itemName);
    }

    public void setAmount(ItemId itemId, BigNum amount) {
        BigNum clampedAmount = BigNum.max(amount, new BigNum(0));
        itemAmounts.put(itemId, clampedAmount);
    }

    public boolean hasEnough(ItemId itemId, BigNum amount) {
        return getAmount(itemId).cmp(amount) >= 0;
    }

    public boolean hasEnough(ItemId itemId, BigNum amount, double epsilon) {
        return getAmount(itemId).cmp(amount.sub(epsilon)) >= 0;
    }

    public void add(ItemId itemId, BigNum amount) {
        setAmount(itemId, getAmount(itemId).add(amount));
    }

    public void remove(ItemId itemId, BigNum amount) {
        setAmount(itemId, getAmount(itemId).sub(amount));
    }
}