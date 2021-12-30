package views.tm;

public class ProgramTM {
    private String programId;
    private String programName;
    private String duration;
    private double programFee;

    public ProgramTM() {
    }

    public ProgramTM(String programId, String programName, String duration, double programFee) {
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
        return "ProgramTM{" +
                "programId='" + programId + '\'' +
                ", programName='" + programName + '\'' +
                ", duration='" + duration + '\'' +
                ", programFee=" + programFee +
                '}';
    }
}
