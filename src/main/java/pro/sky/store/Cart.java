package pro.sky.store;

import java.util.Set;

public interface Cart {
    int addItem(int productId);

    Set<Integer> getItems();
}