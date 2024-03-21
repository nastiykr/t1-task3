package model.cart;

public record ProductInShoppingCart(Integer id,
                                    String name,
                                    String category,
                                    Double price,
                                    Double discount,
                                    Integer quantity) {
}