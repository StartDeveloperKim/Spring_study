package hello.itemservice.domain.item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity; // 수량이 null일 수도 있다.

    private Boolean open; // 판매 여부
    private List<String> regions; // 등록 지역
    private ItemType itemType;
    private String deliveryCode;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
