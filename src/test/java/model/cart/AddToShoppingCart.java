package model.cart;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AddToShoppingCart(
        @JsonProperty("product_id")
        Integer productId,
        Integer quantity) {
}
