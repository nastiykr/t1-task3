package model.product;

public record Product(Integer id,
                      String name,
                      String category,
                      Double price,
                      Integer discount) {
}