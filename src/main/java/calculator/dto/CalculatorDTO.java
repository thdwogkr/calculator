package calculator.dto;

import calculator.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalculatorDTO {

    private Long firstNumber;
    private Long secondNumber;
    private String symbol;
    private Long answer;
    private Member member;
}
