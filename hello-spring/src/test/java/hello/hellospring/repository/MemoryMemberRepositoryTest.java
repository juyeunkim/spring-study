package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        // 메소드 실행될때마다 호출되는 함수
        repository.clearStore();
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // import org.assertj.core.api.Assertions;
        // Assertions.assertEquals(member, result);
        // System.out.println 으로 결과값을 확인할 수 도 있지만 확인하는게 어려움으로
        // Assertions 사용 - true이면 아무런 결과 X, false이면 에러를 리턴한다
        // Assertions.assertEquals( expected, actual);

        // import static org.assertj.core.api.Assertions.*;
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

    // 전체 테스트의 순서는 보장이 안된다
    // ==> 테스트 마다 의존관계가 낮아야한다
    // 전체 실행시켰을때 - findAll이 먼저 실행되면 findNyName에서 중복된 값이 있어서 문제가 발생한다

}
