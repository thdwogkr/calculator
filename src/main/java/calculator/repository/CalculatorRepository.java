package calculator.repository;

import calculator.domain.Calculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CalculatorRepository {

    private final EntityManager em;

    public void save(Calculator calculator) {
        calculator.setAnswer(cal(calculator));
        em.persist(calculator);
    }

    public Long cal(Calculator calculator) {
        Long result;
        if (calculator.getSymbol().equals("+")) {
            result = calculator.getFirstNumber() + calculator.getSecondNumber();
        } else if (calculator.getSymbol().equals("-")) {
            result = calculator.getFirstNumber() - calculator.getSecondNumber();
        } else if (calculator.getSymbol().equals("*")) {
            result = calculator.getFirstNumber() * calculator.getSecondNumber();
        } else if (calculator.getSymbol().equals("/")) {
            result = calculator.getFirstNumber() / calculator.getSecondNumber();
        } else {
            throw new IllegalStateException("사칙 연산만 가능합니다. +,-,*,/");
        }
        return result;
    }


    public Calculator findOne(Long id) {
        return em.find(Calculator.class, id);
    }

    public List<Calculator> findAll() {
        return em.createQuery("select c from Calculator c join fetch c.member",Calculator.class)
                .getResultList();
    }
}
