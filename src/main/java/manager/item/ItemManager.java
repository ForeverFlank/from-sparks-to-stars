package manager.item;

import logic.item.Item;
import math.BigNum;
import util.ResourceUtils;

import java.io.InputStream;
import java.util.*;

public class ItemManager {
    public HashMap<String, Item> itemByName;
    public HashMap<String, BigNum> itemQuantities;

    public ItemManager() {
        itemByName = new HashMap<>();
        itemQuantities = new HashMap<>();
        loadAllItems();
    }

    private void loadAllItems() {
        Map<String, InputStream> inputStreams = ResourceUtils.loadResourceFiles("items");

        for (InputStream stream : inputStreams.values()) {
            HashMap<String, Item> items = ItemParser.parseItems(stream);
            itemByName.putAll(items);
        }

        for (String itemName : itemByName.keySet()) {
            itemQuantities.put(itemName, new BigNum(0));
        }

        System.out.println(itemByName.size() + " items loaded.");
    }

    public Item getItem(String name) {
        return itemByName.get(name);
    }

    public BigNum getQuantity(String itemName) {
        return itemQuantities.get(itemName);
    }

    public void setQuantity(String itemName, BigNum quantity) {
        BigNum clampedQuantity = BigNum.max(quantity, new BigNum(0));
        itemQuantities.put(itemName, clampedQuantity);
    }

    public boolean hasEnough(String itemName, BigNum quantity) {
        return getQuantity(itemName).cmp(quantity) >= 0;
    }

    public boolean hasEnough(String itemName, double quantity) {
        return hasEnough(itemName, new BigNum(quantity));
    }

    public void add(String itemName, BigNum quantity) {
        setQuantity(itemName, getQuantity(itemName).add(quantity));
    }

    public void remove(String itemName, BigNum quantity) {
        setQuantity(itemName, getQuantity(itemName).sub(quantity));
    }
}