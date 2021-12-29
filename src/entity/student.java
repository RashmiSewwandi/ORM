package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="student")
public class student {
    @Id
    private String sId;
    private String name;
    private String age;
    private String gender;
    private String contactnumber;
    private String address;

    public student() {
    }

    public student(String sId, String name, String age, String gender, String contactnumber, String address) {
        this.setSId(sId);
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
        this.setContactnumber(contactnumber);
        this.setAddress(address);
    }

    public String getSId() {
        return sId;
    }

    public void setSId(String sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "student{" +
                "sId='" + sId + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", contactnumber='" + contactnumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
