package entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class registration_detail implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "student",referencedColumnName = "studentId")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "program",referencedColumnName = "programId")
    private program program;
    @CreationTimestamp
    private Date registrationDate;

    public registration_detail() {
    }

    public registration_detail(Student student, entity.program program) {
        this.student = student;
        this.program = program;
    }

    public registration_detail(Integer id, Student student, entity.program program, Date registrationDate) {
        this.setId(id);
        this.setStudent(student);
        this.setProgram(program);
        this.setRegistrationDate(registrationDate);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public entity.program getProgram() {
        return program;
    }

    public void setProgram(entity.program program) {
        this.program = program;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "registration_detail{" +
                "id='" + id + '\'' +
                ", student=" + student +
                ", program=" + program +
                ", registrationDate='" + registrationDate + '\'' +
                '}';
    }
}
