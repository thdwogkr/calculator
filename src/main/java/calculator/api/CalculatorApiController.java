package calculator.api;

import calculator.domain.Calculator;
import calculator.domain.Member;
import calculator.dto.CreateCalculatorRequest;
import calculator.dto.CreateCalculatorResponse;
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

        Calculator calculator = calculatorService.createCalculator(request);
        calculatorService.saveCalculator(calculator);

        return new CreateCalculatorResponse(calculator.getAnswer());
    }




}
