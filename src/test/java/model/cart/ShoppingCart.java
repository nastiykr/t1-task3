package model.cart;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ShoppingCart(
        ProductInShoppingCart cart,
        @JsonProperty("total_price")
        Double totalPrice,
        @JsonProperty("total_discount")
        Double totalDiscount) {
}
