package pro.sky.store;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/store/order")
public class ControllerCart {
    private CartImpl cartImpl;

    public ControllerCart(CartImpl cartImpl) {
        this.cartImpl = cartImpl;
    }

    @GetMapping("/add")
    public ResponseEntity<String> addItem(@RequestParam int productID, HttpSession session) {
        CartImpl cart = (CartImpl) session.getAttribute("Корзина");
        if (cart == null) {
            cart = new CartImpl();
            session.setAttribute("Корзина", cart);
        }
        cart.addItem(productID);
        return ResponseEntity.status(HttpStatus.OK).body("Товар добавлен");
    }

    @GetMapping("/get")
    public ResponseEntity<Set<Integer>> getItems(HttpSession session) {
        CartImpl cart = (CartImpl) session.getAttribute("Корзина");
        if (cart == null) {
            cart = new CartImpl();
            session.setAttribute("Корзина", cart);
        }
        return ResponseEntity.ok(cart.getItems());
    }
}

