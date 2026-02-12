package fsts.manager.item;

import fsts.logic.item.Item;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

public final class ItemParser {
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";

    public static HashMap<ItemId, Item> parseItems(InputStream stream) {
        HashMap<ItemId, Item> items = new HashMap<>();
        ItemParserState state = new ItemParserState();

        try (Scanner scanner = new Scanner(stream)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                parseLine(line, state, items);
            }
        }

        return items;
    }

    private static void parseLine(
        String line,
        ItemParserState state,
        HashMap<ItemId, Item> items
    ) {
        if (line.isEmpty()) {
            return;
        }

        switch (line) {
            case "{" -> {
                state.clear();
                return;
            }
            case "}" -> {
                addItem(state, items);
                return;
            }
        }

        int equalsIndex = line.indexOf('=');
        if (equalsIndex < 0) {
            return;
        }

        String key = line.substring(0, equalsIndex).trim();
        String value = line.substring(equalsIndex + 1).trim();

        switch (key) {
            case KEY_ID -> state.id = new ItemId(value);
            case KEY_NAME -> state.name = value;
        }
    }

    private static void addItem(
        ItemParserState state,
        HashMap<ItemId, Item> items
    ) {
        if (state.id == null || state.name == null) {
            return;
        }

        Item item = new Item(state.id, state.name);
        items.put(state.id, item);

        System.out.println("Added item " + state.id);
    }

    private static final class ItemParserState {
        ItemId id;
        String name;

        void clear() {
            id = null;
            name = null;
        }
    }
}
