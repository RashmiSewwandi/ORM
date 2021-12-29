package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class registration {
    @Id
    private String rId;
    private String date;
    private String sId;
    private String name;
    private String pId;
    private String pName;

    public registration() {
    }

    public registration(String rId, String date, String sId, String name, String pId, String pName) {
        this.setrId(rId);
        this.setDate(date);
        this.setsId(sId);
        this.setName(name);
        this.setpId(pId);
        this.setpName(pName);
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "registration{" +
                "rId='" + rId + '\'' +
                ", date='" + date + '\'' +
                ", sId='" + sId + '\'' +
                ", name='" + name + '\'' +
                ", pId='" + pId + '\'' +
                ", pName='" + pName + '\'' +
                '}';
    }
}
