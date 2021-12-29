package entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class program {
    @Id
    private String pId;
    private String pName;
    private String duration;
    private String fee;

    public program() {
    }

    public program(String pId, String pName, String duration, String fee) {
        this.setpId(pId);
        this.setpName(pName);
        this.setDuration(duration);
        this.setFee(fee);
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "program{" +
                "pId='" + pId + '\'' +
                ", pName='" + pName + '\'' +
                ", duration='" + duration + '\'' +
                ", fee='" + fee + '\'' +
                '}';
    }
}
