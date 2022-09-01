package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class Item {

    //@NotNull(groups = UpdateCheck.class)
    private Long id;

    //@NotBlank(groups = {SaveCheck.class, UpdateCheck.class}) /*빈값 + 공백을 허요하지 않는다.*/
    private String itemName;

    //@NotNull(groups = {SaveCheck.class, UpdateCheck.class}) /*NULL값을 허용하지 않는다.*/
    //@Range(min = 1000, max = 1000000, groups = {SaveCheck.class, UpdateCheck.class})
    private Integer price;

    //@NotNull(groups = {SaveCheck.class, UpdateCheck.class})
    //@Max(value = 9999, groups = {SaveCheck.class})
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
