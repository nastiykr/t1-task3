package model.cart;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ShoppingCart {

        public record Root(
                @JsonProperty("cart")
                List<ProductInShoppingCart> carts,
                @JsonProperty("total_price")
                Double totalPrice,
                @JsonProperty("total_discount")
                Double totalDiscount) {
        }

        public record ProductInShoppingCart(Integer id,
                                            String name,
                                            String category,
                                            Double price,
                                            Double discount,
                                            Integer quantity) {
        }
}

