package calculator.service;

import calculator.domain.Member;
import calculator.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public boolean login(Member member) {

        Member findMember = memberRepository.findOne(member.getId());
        if (findMember == null) {
            return false;
        }

        if (!findMember.getPw().equals(member.getPw())) {
            return false;
        }

        return true;
    }
}
