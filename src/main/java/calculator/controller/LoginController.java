package calculator.controller;

import calculator.domain.Member;
import calculator.dto.MemberDTO;
import calculator.service.MemberService;
import calculator.session.SessionConst;
import calculator.session.SessionManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginId(@ModelAttribute MemberDTO memberDTO,
                          HttpServletRequest request) {

        Member findMember = memberService.findOneEmail(memberDTO.getEmail());

        if (!memberService.login(findMember)) {
            return "login";
        }

//        HttpSession session = request.getSession();
//        session.setAttribute(SessionConst.LOGIN_USER, memberDTO);


        /*//쿠키 생성
        Cookie idCookie = new Cookie("email", String.valueOf(request.getEmail()));

        //응답에 쿠키 추가가
       response.addCookie(idCookie);*/

        return "calculator";
    }
}
