package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class registration {
    @Id
    private String regId;
    private String regDate;
    private String studentName;
    private String programId;
    private String programName;


}
