package views.tm;

public class StudentTM {
    private String studentId;
    private String studentName;
    private String age;
    private String gender;
    private String contactNumber;
    private String address;
    private String mail;

    public StudentTM() {
    }

    public StudentTM(String studentId, String studentName, String age, String gender, String contactNumber, String address, String eMail) {
        this.setStudentId(studentId);
        this.setStudentName(studentName);
        this.setAge(age);
        this.setGender(gender);
        this.setContactNumber(contactNumber);
        this.setAddress(address);
        this.setMail(eMail);
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "StudentTM{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", address='" + address + '\'' +
                ", eMail='" + mail + '\'' +
                '}';
    }
}
