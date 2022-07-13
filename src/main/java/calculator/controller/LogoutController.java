package calculator.controller;


import calculator.session.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LogoutController {

    @PostMapping("/logout")
    public String logoutId(//@ModelAttribute MemberDTO memberDTO,
                          HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.removeAttribute(SessionConst.LOGIN_USER);

        return "login";
    }
}
