package calculator.controller;

import calculator.domain.Member;
import calculator.dto.MemberDTO;
import calculator.service.MemberService;
import calculator.session.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LogoutController {

    private MemberService memberService;

    @PostMapping("/logout")
    public String logoutId(//@ModelAttribute MemberDTO memberDTO,
                          HttpServletRequest request) {

//        Member findMember = memberService.findOneEmail(memberDTO.getEmail());

        HttpSession session = request.getSession();
        session.removeAttribute(SessionConst.LOGIN_USER);

        return "login";
    }
}
