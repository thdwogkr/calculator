package calculator.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MemberDTO {
    @NotEmpty
    private String email;

    @NotEmpty
    private String pw;

    private boolean rememberId;
}



