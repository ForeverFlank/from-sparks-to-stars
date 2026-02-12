package fsts.component;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import fsts.manager.Game;
import fsts.manager.item.ItemId;

import java.util.ArrayList;
import java.util.Comparator;

public class ItemPane extends BorderPane {
    enum SortingState {
        NAME, AMOUNT
    }

    private final Button sortByNameButton;
    private final Button sortByAmountButton;
    private SortingState sortingState;
    private boolean isSortDescending;

    private final VBox itemsContainer;
    private final ArrayList<ItemAmountPane> itemAmountPanes;

    public ItemPane() {
        sortByNameButton = new Button("Name");
        sortByAmountButton = new Button("Amount");

        sortByNameButton.setOnAction(_ -> onSortButtonClick(SortingState.NAME));
        sortByAmountButton.setOnAction(_ -> onSortButtonClick(SortingState.AMOUNT));

        HBox sortButtonsContainer = new HBox();
        sortButtonsContainer.getChildren().add(sortByNameButton);
        sortButtonsContainer.getChildren().add(sortByAmountButton);

        itemsContainer = new VBox();
        itemAmountPanes = new ArrayList<>();
        for (ItemId itemId : Game.getInstance().itemManager.getAllItems()) {
            if (itemId.equals(ItemId.ENERGY)) continue;

            ItemAmountPane itemAmountPane = new ItemAmountPane(itemId);
            itemAmountPanes.add(itemAmountPane);
            itemsContainer.getChildren().add(itemAmountPane);
        }

        setTop(sortButtonsContainer);
        setCenter(itemsContainer);

        sortingState = SortingState.AMOUNT;
        isSortDescending = true;
        applySorting();
    }

    private void onSortButtonClick(SortingState targetState) {
        if (targetState == sortingState) {
            isSortDescending = !isSortDescending;
        } else if (targetState == SortingState.NAME) {
            isSortDescending = false;
        } else if (targetState == SortingState.AMOUNT) {
            isSortDescending = true;
        }
        sortingState = targetState;
        applySorting();
    }

    private void applySorting() {
        String arrow = isSortDescending ? "▾" : "▴";

        if (sortingState == SortingState.NAME) {
            sortByNameButton.setText("Name " + arrow);
            sortByAmountButton.setText("Amount");
        } else {
            sortByNameButton.setText("Name");
            sortByAmountButton.setText("Amount " + arrow);
        }

        Comparator<ItemAmountPane> nameComparator = getNameComparator();
        Comparator<ItemAmountPane> amountComparator = getAmountComparator(nameComparator);

        Comparator<ItemAmountPane> comparator = sortingState == SortingState.NAME
                                                ? nameComparator.thenComparing(amountComparator)
                                                : amountComparator.thenComparing(nameComparator);
        itemAmountPanes.sort(isSortDescending
                             ? comparator
                             : comparator.reversed());
        itemsContainer.getChildren().setAll(itemAmountPanes);
    }

    private static Comparator<ItemAmountPane> getNameComparator() {
        return Comparator.comparing(pane -> pane.displayName.toLowerCase());
    }

    private Comparator<ItemAmountPane> getAmountComparator(Comparator<ItemAmountPane> nameComparator) {
        return Comparator.comparing(
            pane -> Game.getInstance().itemManager.getAmount(pane.itemId),
            (a, b) -> a.cmp(b)
        );
    }

    public void update() {
        for (ItemAmountPane pane : itemAmountPanes) {
            pane.update();
        }
        applySorting();
    }
}
