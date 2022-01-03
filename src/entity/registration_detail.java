package entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class registration_detail implements SuperEntity{
    @Id
    private String studentId;
    private String programId;
    @CreationTimestamp
    private String registrationDate;

    public registration_detail() {
    }

    public registration_detail(String studentId, String programId, String registrationDate) {
        this.setStudentId(studentId);
        this.setProgramId(programId);
        this.setRegistrationDate(registrationDate);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "registration_detail{" +
                "studentId='" + studentId + '\'' +
                ", programId='" + programId + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                '}';
    }
}
