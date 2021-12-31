package dto;

public class StudentDTO {

    private String studentId;
    private String studentName;
    private String age;
    private String gender;
    private String contactNumber;
    private String address;
    private String eMail;

    public StudentDTO() {
    }

    public StudentDTO(String studentId, String studentName, String age, String gender, String contactNumber, String address, String eMail) {
        this.setStudentId(studentId);
        this.setStudentName(studentName);
        this.setAge(age);
        this.setGender(gender);
        this.setContactNumber(contactNumber);
        this.setAddress(address);
        this.seteMail(eMail);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", address='" + address + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
