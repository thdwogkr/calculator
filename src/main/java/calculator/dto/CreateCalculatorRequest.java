package calculator.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateCalculatorRequest {

    private Long memberId;

    private Long firstNumber;

    private Long secondNumber;
    @NotEmpty
    private String symbol;
}
