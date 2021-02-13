package hello.hellospring.domain;

import javax.persistence.*;

// ORM를 어노테이션으로 설
@Entity
public class Member {
    // @Id - PK
    // @IDENTITY - 자바에서 알아서 생성
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

