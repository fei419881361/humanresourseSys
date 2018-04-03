package vo;

import entity.Employee;
import entity.SysDep;

import java.util.Date;

public class EmployeeVO {
    private Integer id;

    private Date createDate;

    private Date modifyDate;

    private String name;

    private Integer gender;

    private String birthday;

    private String idCard;

    private String depName;

    private String position;

    private String education;

    private String phone;

    private String workTime;

    private String remark;

    private String major;

    private Integer status;

    public EmployeeVO(){}

    public EmployeeVO(Employee employee){
        this.id = employee.getId();
        this.name = employee.getName();
        this.gender = employee.getGender();
        this.birthday = employee.getBirthday();
        this.idCard = employee.getIdCard();
        this.position = employee.getPosition();
        this.education = employee.getEducation();
        this.phone = employee.getPhone();
        this.workTime = employee.getWorkTime();
        this.remark = employee.getRemark();
        this.major = employee.getMajor();
        this.status = employee.getStatus();
    }

    @Override
    public String toString() {
        return "EmployeeVO{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthday='" + birthday + '\'' +
                ", idCard='" + idCard + '\'' +
                ", depName=" + depName+
                ", position='" + position + '\'' +
                ", education='" + education + '\'' +
                ", phone='" + phone + '\'' +
                ", workTime='" + workTime + '\'' +
                ", remark='" + remark + '\'' +
                ", major='" + major + '\'' +
                ", status=" + status +
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
