package calculator.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Calculator {

    @Id @GeneratedValue
    @Column(name = "calculator_id")
    private Long id;

    private Long firstNumber;
    private Long secondNumber;
    private String symbol;
    private Long answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;


    //생성 메서드
    public static Calculator createCalculator(Member member) {
        Calculator calculator = new Calculator();
        calculator.setMember(member);
        return calculator;
    }


    public void cal(Long firstNumber, Long secondNumber, String symbol) {
        if (symbol.equals("+")) {
            this.answer = firstNumber + secondNumber;
        } else if (symbol.equals("-")) {
            this.answer = firstNumber - secondNumber;
        } else if (symbol.equals("*")) {
            this.answer = firstNumber * secondNumber;
        } else if (symbol.equals("/")) {
            this.answer = firstNumber / secondNumber;
        } else {
            throw new IllegalStateException("사칙 연산만 가능합니다. +,-,*,/");
        }
    }

}
