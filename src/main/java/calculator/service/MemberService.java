package calculator.service;

import calculator.domain.Member;
import calculator.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //회원 가입
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    //회원 가입 내 중복 체크
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByEmail(member.getEmail());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();}

    //회원 id로 조회
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    //회원 email로 조회
    public Member findOneEmail(String memberEmail) { return memberRepository.findOneEmail(memberEmail);
    }

    //회원 정보 업데이트, 미구현


    // todo: D예외처리ㅜ가
    public boolean login(Member member) {
        Member findMember = memberRepository.findOne(member.getId());

        if (findMember == null) {
            System.out.println("널값");
            return false;
        }

        if (!findMember.getPw().equals(member.getPw())) {
            System.out.println("비번틀림");
            return false;
        }

        return true;
    }
}
