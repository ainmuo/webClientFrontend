package ma.formations.msa.webclientfrontend.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpVo implements Serializable {
    private Long id;
    private String name;
    private String fonction;
    private Double salaire;

}
