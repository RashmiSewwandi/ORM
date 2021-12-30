package entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class registration {
    @Id
    private String regId;
    @CreationTimestamp
    private String regDate;
    private String studentName;
    private String programId;
    private String programName;

    public registration() {
    }

    public registration(String regId, String regDate, String studentName, String programId, String programName) {
        this.regId = regId;
        this.regDate = regDate;
        this.studentName = studentName;
        this.programId = programId;
        this.programName = programName;
    }


}
