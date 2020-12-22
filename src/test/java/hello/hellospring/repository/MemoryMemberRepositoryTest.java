package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
//        System.out.println("result == member = " + (result == member));
//        Assertions.assertEquals(member, result);
//        assertThat 메소드 오류, Assertions ALT + ENTER static import -> ADD 해서 사용할 수 있다.
//        Assertions.assertThat(member).isEqualTo(result);
    }
}
