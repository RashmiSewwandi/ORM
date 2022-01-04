package dto;

public class RegistrationDTO {
    private String id;
    private String studentId;
    private String programId;
    private String registrationDate;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String studentId, String programId) {
        this.studentId = studentId;
        this.programId = programId;
    }

    public RegistrationDTO(String id, String studentId, String programId, String registrationDate) {
        this.setId(id);
        this.setStudentId(studentId);
        this.setProgramId(programId);
        this.setRegistrationDate(registrationDate);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "RegistrationDTO{" +
                "id='" + id + '\'' +
                ", studentId='" + studentId + '\'' +
                ", programId='" + programId + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                '}';
    }
}
