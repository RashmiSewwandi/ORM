package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="student")
public class student {
    @Id
    private String studentId;
    private String studentName;
    private String age;
    private String gender;
    private String contactNumber;
    private String eMail;
    private String address;

    public student() {
    }

}
