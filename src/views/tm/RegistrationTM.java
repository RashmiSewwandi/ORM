package views.tm;

public class RegistrationTM {
    private String studentId;
    private String studentName;
    private String programId;
    private String programName;
    private String duration;
    private String registrationDate;

    public RegistrationTM() {
    }

    public RegistrationTM(String studentId, String studentName, String programId, String programName, String duration, String registrationDate) {
        this.setStudentId(studentId);
        this.setStudentName(studentName);
        this.setProgramId(programId);
        this.setProgramName(programName);
        this.setDuration(duration);
        this.setRegistrationDate(registrationDate);
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

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "RegistrationTM{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", programId='" + programId + '\'' +
                ", programName='" + programName + '\'' +
                ", duration='" + duration + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                '}';
    }
}
