package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

//    MemberService memberService = new MemberService();
    MemberService memberService;
    // MemberService 에서의 MemoryMemberRepository 가 다른 곳이다. 같은 인스턴스를 사용해야 한다.
//    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
    MemoryMemberRepository memoryMemberRepository;


    // MemberService 리포지토리 인스턴스를 동작하지 전에 넣어 준다.
    @BeforeEach
    public void beforeEach() {
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    // 돌때 마다 DB 날준다.
    @AfterEach
    public void afterEach() {
        memoryMemberRepository.clearStore();
    }


    @Test
    void join() {
        // given 상황이 주어줬을때
        Member member = new Member();
        member.setName("hello");
        // when 이걸 실행했을때
        Long saveId = memberService.join(member);
        // then 이것이 나와야 한다. 검증단계
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
        // 문법 이렇게 주석을 깔고하는 것이 편하다.
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        // when
        // 방법 1
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        assertThrows(NullPointerException.class, () -> memberService.join(member2));

/*
        try {
            memberService.join(member2);
            fail("예외가 발생해야 합니다.");
        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다. ㄴㄹㄴㅇㄹㅇㄴㄹㅇㄴㄹ");
        }
*/

        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}