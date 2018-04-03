package entity;

import vo.RecruitmentVO;

import java.util.Date;

public class Recruitment {
    private Integer id;

    private String name;

    private Integer gender;

    private Integer depId;

    private String major;

    private String education;

    private String workExperience;

    private Integer hire;

    private Date createDate;

    private Date modifyDate;

    private String phone;

    public Recruitment(){}

    public Recruitment(RecruitmentVO vo){
        this.id = vo.getId();
        this.name = vo.getName();
        this.gender = vo.getGender();
        this.education = vo.getEducation();
        this.phone = vo.getPhone();
        this.workExperience = vo.getWorkExperience();
        this.major = vo.getMajor();
        this.hire = vo.getHire();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience == null ? null : workExperience.trim();
    }

    public Integer getHire() {
        return hire;
    }

    public void setHire(Integer hire) {
        this.hire = hire;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}