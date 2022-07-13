package calculator.controller;

import calculator.domain.Member;
import calculator.dto.MemberDTO;
import calculator.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final MemberService memberService;

    @RequestMapping("/join")
    public String login() {
        return "join";
    }

    @PostMapping("/join")
    public String LoginId(@ModelAttribute @Valid MemberDTO request) {

        Member member = new Member();
        member.setEmail(request.getEmail());
        member.setPw(request.getPw());
        Long id = memberService.join(member);

        return "login";
    }
}
