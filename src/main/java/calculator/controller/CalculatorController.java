package calculator.controller;

import calculator.dto.MemberDTO;
import calculator.session.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class CalculatorController {

    @RequestMapping("/")
    public String login(
            @SessionAttribute(name = SessionConst.LOGIN_USER, required = false)
            MemberDTO memberDTO) {

        if (memberDTO == null) {
            return "login";
        }

        return "calculator";
    }
}
