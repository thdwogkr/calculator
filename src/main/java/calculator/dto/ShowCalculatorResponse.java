package calculator.dto;

import calculator.domain.Calculator;
import calculator.domain.Member;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class ShowCalculatorResponse {
    private Long firstNumber;
    private Long secondNumber;
    private String symbol;
    private Long answer;
    private String email;

    public ShowCalculatorResponse(Calculator calculator) {
        firstNumber = calculator.getFirstNumber();
        secondNumber = calculator.getSecondNumber();
        symbol = calculator.getSymbol();
        answer = calculator.getAnswer();
        email = calculator.getMember().getEmail();
    }
}
