package calculator.controller;

import calculator.domain.Member;
import calculator.dto.MemberDTO;
import calculator.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String login() {
        return "join";
    }

    @PostMapping("/join")
    public String LoginId(@ModelAttribute @Valid MemberDTO request) {

        Member member = memberService.createMember(request);
        memberService.join(member);

        return "login";
    }
}
