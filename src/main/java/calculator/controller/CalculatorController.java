package calculator.controller;

import calculator.dto.MemberDTO;
import calculator.session.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class CalculatorController {

    @GetMapping("/")
    public String login(
            @SessionAttribute(name = SessionConst.LOGIN_USER, required = false)
            MemberDTO memberDTO) {

        System.out.println(memberDTO);
        if (memberDTO == null) {
            return "login";
        }

        return "calculator";
    }
}
