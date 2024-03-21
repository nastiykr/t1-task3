package model.product;

public record ProductCart(Integer id,
                          String name,
                          String category,
                          Double price,
                          Integer discount) {
}