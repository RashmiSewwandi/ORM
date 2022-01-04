package dto;

import java.util.Date;

public class CustomDTO {
    private String student_id;
    private String student_name;
    private String program_id;
    private String program_name;
    private String duration;
    private Date joined_date;

    public CustomDTO() {
    }

    public CustomDTO(String student_id, String student_name, String program_id, String program_name, String duration, Date joined_date) {
        this.setStudent_id(student_id);
        this.setStudent_name(student_name);
        this.setProgram_id(program_id);
        this.setProgram_name(program_name);
        this.setDuration(duration);
        this.setJoined_date(joined_date);
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getProgram_id() {
        return program_id;
    }

    public void setProgram_id(String program_id) {
        this.program_id = program_id;
    }

    public String getProgram_name() {
        return program_name;
    }

    public void setProgram_name(String program_name) {
        this.program_name = program_name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getJoined_date() {
        return joined_date;
    }

    public void setJoined_date(Date joined_date) {
        this.joined_date = joined_date;
    }
}
