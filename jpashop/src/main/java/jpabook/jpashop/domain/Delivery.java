package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @JsonIgnore
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order; // 하나의 배송(Delivery)에는 하나의 주문(Order)

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // Type 기본이 ordinal인데 이는 상태가 숫자로 들어간다. 그래서 무조건 STRING으로 타입을 지정하자
    private DeliveryStatus status; // READY, COMP
}
