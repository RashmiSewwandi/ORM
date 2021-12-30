package entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class program {
    @Id
    private String programId;
    private String programName;
    private String duration;
    private String programFee;


}
