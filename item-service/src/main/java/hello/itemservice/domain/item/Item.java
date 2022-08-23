package hello.itemservice.domain.item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity; // 수량이 null일 수도 있다.

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
