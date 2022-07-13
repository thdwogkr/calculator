package calculator.api;

import calculator.domain.Calculator;
import calculator.domain.Member;
import calculator.service.CalculatorService;
import calculator.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequiredArgsConstructor
public class CalculatorApiController {

    private final MemberService memberService;
    private final CalculatorService calculatorService;

    @PostMapping("/api/v1/calculators")
    public CreateCalculatorResponse saveCalculatorV1(@RequestBody @Valid CreateCalculatorRequest request) {

        Calculator calculator = createCalculator(request);
        calculatorService.saveCalculator(calculator);



        return new CreateCalculatorResponse(calculator.getAnswer());
    }

    private Calculator createCalculator(CreateCalculatorRequest request) {
        Member member = new Member();
        member.setId(request.memberId);
        Calculator calculator = new Calculator();
        calculator.setFirstNumber(request.firstNumber);
        calculator.setSecondNumber(request.secondNumber);
        calculator.setSymbol(request.symbol);
        calculator.setMember(member);
        return calculator;
    }

    @Data
    static class CreateCalculatorResponse {
        private Long answer;

        public CreateCalculatorResponse(Long answer) {
            this.answer = answer;
        }
    }

    @Data
    static class CreateCalculatorRequest {

        private Long memberId;

        private Long firstNumber;

        private Long secondNumber;
        @NotEmpty
        private String symbol;
    }

}
