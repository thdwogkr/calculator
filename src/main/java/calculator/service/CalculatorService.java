package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.Member;
import calculator.dto.CreateCalculatorRequest;
import calculator.repository.CalculatorRepository;
import calculator.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CalculatorService {

    private final CalculatorRepository calculatorRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void saveCalculator(Calculator calculator) {
        calculatorRepository.save(calculator);
    }

    public List<Calculator> findCalculators(String email) {
        return calculatorRepository.findAll(email);}

    public Calculator findOne(Long calculatorId) {
        return calculatorRepository.findOne(calculatorId);
    }

    public Calculator createCalculator(CreateCalculatorRequest request) {
        Member findMember = memberRepository.findOneEmail(request.getEmail());

        Calculator calculator = new Calculator();
        calculator.setFirstNumber(request.getFirstNumber());
        calculator.setSecondNumber(request.getSecondNumber());
        calculator.setSymbol(request.getSymbol());
        calculator.setMember(findMember);
        System.out.println(calculator.getSymbol());
        System.out.println(calculator.getMember());
        return calculator;
    }
}
