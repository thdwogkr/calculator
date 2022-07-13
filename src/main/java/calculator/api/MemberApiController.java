package calculator.api;

import calculator.domain.Member;
import calculator.dto.MemberDTO;
import calculator.service.MemberService;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/v1/members")
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid MemberDTO request) {
        Member member = new Member();
        member.setEmail(request.getEmail());
        member.setPw(request.getPw());
        Long id = memberService.join(member);

        return new CreateMemberResponse(id);
    }

    @GetMapping("/api/v1/members")
    public ShowMembers MemberV1() {
        List<Member> findMembers = memberService.findMembers();
        List<MemberDto> collect = findMembers.stream()
                .map(m->new MemberDto(m.getEmail()))
                .collect(Collectors.toList());
        return new ShowMembers(collect);
    }

    @Data
    static class CreateMemberResponse {
        private Long id;

        public CreateMemberResponse(Long id) {
            this.id = id;
        }
    }


    @Data
    @AllArgsConstructor
    private class ShowMembers<T> {
        private T data;
    }

    @Data
    @AllArgsConstructor
    private class MemberDto {
        private String email;
    }
}

