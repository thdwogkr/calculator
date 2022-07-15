package calculator.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateCalculatorRequest {

    private String email;

    private Long firstNumber;

    private Long secondNumber;
    @NotEmpty
    private String symbol;
}
