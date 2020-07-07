package com.example.demo.model;

import java.time.LocalDate;

public class UserApprove {
    private Integer Id;
    private String uId;
    private String uToken;
    private String gscName;
    private String gseName;
    private String busLicense;
    private String regAddress;
    private String busAddress;
    private String regDate;
    private String regFund;
    private String representative;
    private String companyType;
    private String applicant;
    private String applicantDepart;
    private String applicantPost;
    private String appTime;
    private String status;

    public UserApprove() {
    }

    public UserApprove(String uId, String uToken, String gscName, String gseName, String busLicense, String regAddress, String busAddress, String regDate, String regFund, String representative, String companyType, String applicant, String applicantDepart, String applicantPost, String appTime,String status) {
        this.uId = uId;
        this.uToken = uToken;
        this.gscName = gscName;
        this.gseName = gseName;
        this.busLicense = busLicense;
        this.regAddress = regAddress;
        this.busAddress = busAddress;
        this.regDate = regDate;
        this.regFund = regFund;
        this.representative = representative;
        this.companyType = companyType;
        this.applicant = applicant;
        this.applicantDepart = applicantDepart;
        this.applicantPost = applicantPost;
        this.appTime = appTime;
        this.status = status;

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuToken() {
        return uToken;
    }

    public void setuToken(String uToken) {
        this.uToken = uToken;
    }

    public String getGscName() {
        return gscName;
    }

    public void setGscName(String gscName) {
        this.gscName = gscName;
    }

    public String getGseName() {
        return gseName;
    }

    public void setGseName(String gseName) {
        this.gseName = gseName;
    }

    public String getBusLicense() {
        return busLicense;
    }

    public void setBusLicense(String busLicense) {
        this.busLicense = busLicense;
    }

    public String getRegAddress() {
        return regAddress;
    }

    public void setRegAddress(String regAddress) {
        this.regAddress = regAddress;
    }

    public String getBusAddress() {
        return busAddress;
    }

    public void setBusAddress(String busAddress) {
        this.busAddress = busAddress;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getRegFund() {
        return regFund;
    }

    public void setRegFund(String regFund) {
        this.regFund = regFund;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getApplicantDepart() {
        return applicantDepart;
    }

    public void setApplicantDepart(String applicantDepart) {
        this.applicantDepart = applicantDepart;
    }

    public String getApplicantPost() {
        return applicantPost;
    }

    public void setApplicantPost(String applicantPost) {
        this.applicantPost = applicantPost;
    }

    public String getAppTime() {
        return appTime;
    }

    public void setAppTime(String appTime) {
        this.appTime = appTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserApprove{" +
                "Id=" + Id +
                ", uId='" + uId + '\'' +
                ", uToken='" + uToken + '\'' +
                ", gscName='" + gscName + '\'' +
                ", gseName='" + gseName + '\'' +
                ", busLicense='" + busLicense + '\'' +
                ", regAddress='" + regAddress + '\'' +
                ", busAddress='" + busAddress + '\'' +
                ", regDate='" + regDate + '\'' +
                ", regFund='" + regFund + '\'' +
                ", representative='" + representative + '\'' +
                ", companyType='" + companyType + '\'' +
                ", applicant='" + applicant + '\'' +
                ", applicantDepart='" + applicantDepart + '\'' +
                ", applicantPost='" + applicantPost + '\'' +
                ", appTime='" + appTime + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
