package model.cart;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AddToCartRequest(
        @JsonProperty("product_id")
        Integer productId,
        Integer quantity) {
}
