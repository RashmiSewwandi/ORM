package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class program implements SuperEntity {
    @Id
    private String programId;
    private String programName;
    private String duration;
    private double programFee;

    @OneToMany(mappedBy = "program",cascade = CascadeType.ALL)
    private List<registration_detail> registration_details;

    public program() {
    }

    public program(String programId) {
        this.programId = programId;
    }

    public program(String programId, String programName, String duration, double programFee) {
        this.setProgramId(programId);
        this.setProgramName(programName);
        this.setDuration(duration);
        this.setProgramFee(programFee);
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getProgramFee() {
        return programFee;
    }

    public void setProgramFee(double programFee) {
        this.programFee = programFee;
    }

    @Override
    public String toString() {
        return "program{" +
                "programId='" + programId + '\'' +
                ", programName='" + programName + '\'' +
                ", duration='" + duration + '\'' +
                ", programFee=" + programFee +
                '}';
    }
}
