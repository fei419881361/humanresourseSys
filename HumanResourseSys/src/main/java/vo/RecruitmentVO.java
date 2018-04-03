package vo;

import entity.Recruitment;

import java.util.Date;

public class RecruitmentVO {
    private Integer id;

    private Date createDate;

    private Date modifyDate;

    private String name;

    private Integer gender;


    private String depName;

    private String position;

    private String education;

    private String phone;

    private String workExperience;

    private String major;

    private Integer hire;


    public RecruitmentVO(){}

    public RecruitmentVO(Recruitment entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.gender = entity.getGender();
        this.education = entity.getEducation();
        this.phone = entity.getPhone();
        this.workExperience = entity.getWorkExperience();
        this.major = entity.getMajor();
        this.hire = entity.getHire();
    }



    @Override
    public String toString() {
        return "RecruitmentVO{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", depName='" + depName + '\'' +
                ", position='" + position + '\'' +
                ", education='" + education + '\'' +
                ", phone='" + phone + '\'' +
                ", workExperience='" + workExperience + '\'' +
                ", major='" + major + '\'' +
                ", hire=" + hire +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }


    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getHire() {
        return hire;
    }

    public void setHire(Integer hire) {
        this.hire = hire;
    }
}
