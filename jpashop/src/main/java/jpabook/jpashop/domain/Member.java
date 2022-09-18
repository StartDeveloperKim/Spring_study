package jpabook.jpashop.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
    private String name;

    @Embedded
    private Address address;

    @JsonIgnore // 양방향 연관관계가 있다면 한쪽은 JsonIgnore을 해줘야한다.
    @OneToMany(mappedBy = "member")
    // 한명에 회원은 여러개의 주문을 가질 수 있다.
    private List<Order> orders = new ArrayList<>();
    // OneToMany 관계에서는 여러 건과 연관관계를 맺을 수 있으므로 컬렉션을 사용해야한다.
}
