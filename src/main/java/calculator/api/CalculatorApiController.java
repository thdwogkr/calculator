package calculator.api;

import calculator.domain.Calculator;
import calculator.domain.Member;
import calculator.dto.*;
import calculator.service.CalculatorService;
import calculator.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/api/v1/calculators")
    public List<ShowCalculatorResponse> showCalculatorV1(@RequestBody @Valid ShowCalculatorRequest request) {

        List<Calculator> findCalculators = calculatorService.findCalculators();
        List<ShowCalculatorResponse> result = findCalculators.stream()
                .map(c -> new ShowCalculatorResponse(c))
                .collect(Collectors.toList());

        return result;
    }
}

