package calculator.dto;

import lombok.Data;

@Data
public class CreateCalculatorResponse {
    private Long answer;

    public CreateCalculatorResponse(Long answer) {
        this.answer = answer;
    }
}
