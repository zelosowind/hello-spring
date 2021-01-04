package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private MemberService memberService;

//    @Autowired
//    // 퍼블릿하게 노출된다는 단점이 있다. setter 사용시
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

    /**
     *
     * @param memberService
     */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
