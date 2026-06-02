package com.student360.dto;

public class StudentDashboardDTO {

    private String studentName;

    private int academicRecords;

    private int sportsActivities;

    private int certifications;

    private int leadershipActivities;

    private int innovationProjects;

    private int communicationSkills;

    public StudentDashboardDTO() {
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAcademicRecords() {
        return academicRecords;
    }

    public void setAcademicRecords(int academicRecords) {
        this.academicRecords = academicRecords;
    }

    public int getSportsActivities() {
        return sportsActivities;
    }

    public void setSportsActivities(int sportsActivities) {
        this.sportsActivities = sportsActivities;
    }

    public int getCertifications() {
        return certifications;
    }

    public void setCertifications(int certifications) {
        this.certifications = certifications;
    }

    public int getLeadershipActivities() {
        return leadershipActivities;
    }

    public void setLeadershipActivities(int leadershipActivities) {
        this.leadershipActivities = leadershipActivities;
    }

    public int getInnovationProjects() {
        return innovationProjects;
    }

    public void setInnovationProjects(int innovationProjects) {
        this.innovationProjects = innovationProjects;
    }

    public int getCommunicationSkills() {
        return communicationSkills;
    }

    public void setCommunicationSkills(int communicationSkills) {
        this.communicationSkills = communicationSkills;
    }
}