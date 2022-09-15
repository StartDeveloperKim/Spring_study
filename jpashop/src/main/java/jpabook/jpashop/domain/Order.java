package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity // Entity 객체라는 것을 명ㅅ
@Table(name = "orders")
@Getter
@Setter // Entity클래스를 생성할 때는 Setter를 열어두는 것은 지양하자.
public class Order {

    @Id // PK
    @GeneratedValue // PK값 자동생성 기본은 AUTO
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // 지연로딩 설정
    // LAZY 로 지연로딩 설정을 하지않으면 연관되어있는 모든 데이터들이 딸려 올라온다. 필수설정임
    @JoinColumn(name = "member_id") // FK설정
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    // 하나의 주문(Order)에 여러개의 물건(Item)을 주문할 수 있다. 그래서 OnetoMany
    // CASCADE 설정은 따로 persist를 하지않아도 설정한 것에 대해 persist를 자동으로 해준다 --> 다시 공부하자... 애매쓰
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // 하나의 주문(Order)에 하나의 배송(Delivery)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    /**
     * 도메인 모델 패턴
     * 도메인 객체가 속성뿐만 아니라 비즈니스 행위를 가지고 있어 책임을 수행하게 된다.
     * @param member
     */

    // == 연관관계 편의 메서드 == //
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    //==생성메서드==//
    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) {
        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);
        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }
        order.setStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDateTime.now());
        return order;
    }

    //==비즈니스 로직==//
    public void cancel() {
        if (delivery.getStatus() == DeliveryStatus.COMP) {
            throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다.");
        }

        this.setStatus(OrderStatus.CANCEL);
        for (OrderItem orderItem : this.orderItems) {
            orderItem.cancel();
        }
    }

    //==조회 로직==//
    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getTotalPrice();
        }
        return totalPrice;
    }

}
