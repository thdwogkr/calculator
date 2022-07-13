package calculator.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Data
public class MemberDTO {
    @NotEmpty
    private String email;

    @NotEmpty
    private String pw;

    private boolean rememberId;
}



