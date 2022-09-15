package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id") // 테이블의 Attribute 이름을 item_id로 설정 그리고 mapping
    private Long id;

    private String name;

    private int price; // 가격
    private int stockQuantity; // 남은 수량

    @ManyToMany(mappedBy = "items")
    // 하나의 Item은 여러 카테고리에 포함될 수 있다.
    private List<Category> categories = new ArrayList<>();

    //== 비즈니스 로직 ==//
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity){
        int restStock = this.stockQuantity - quantity; // 남은 수량
        // 남은 수량이 0보다 작게된다면 예외를 던진다.
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
