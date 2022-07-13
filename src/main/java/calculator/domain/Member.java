package calculator.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {


    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String email;
    private String pw;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Calculator> calculators = new ArrayList<>();
}
