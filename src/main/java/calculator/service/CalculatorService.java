package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.Member;
import calculator.repository.CalculatorFormula;
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

    public List<Calculator> findCalculators() {
        return calculatorRepository.findAll();}

    public Calculator findOne(Long calculatorId) {
        return calculatorRepository.findOne(calculatorId);
    }

}
