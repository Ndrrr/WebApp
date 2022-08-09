package model;

import java.sql.Date;

public class EmploymentHistory extends Entity{
    private int id;
    private String header;
    private Date beginDate;
    private Date endDate;
    private String jobDescription;
    private int userId;

    public EmploymentHistory() {
    }

    public EmploymentHistory(int id, String header, Date beginDate,
                             Date endDate, String jobDescription, int userId) {
        this.id = id;
        this.header = header;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
        this.userId = userId;
    }

    // region Getters and Setters
    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    // endregion


    @Override
    public String toString() {
        return "EmploymentHistory{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", jobDescription='" + jobDescription + '\'' +
                ", userId=" + userId +
                '}';
    }
}
