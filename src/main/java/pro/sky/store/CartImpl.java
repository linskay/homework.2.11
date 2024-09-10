package pro.sky.store;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Scope("prototype")

public class CartImpl implements Cart {

    private final Set<Integer> items;

    public CartImpl() {
        this.items = new HashSet<>();
    }

    @Override
    public int addItem(int productId) {
        items.add(productId);
        return productId;
    }

    @Override
    public Set<Integer> getItems() {
        return items;
    }
}
