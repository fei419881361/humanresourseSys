package entity;

import java.util.Date;

public class Salary {
    private Integer id;

    private Date createDate;

    private Date modifyDate;

    private Double basePay;

    private Double overtimePay;

    private Double misstimePay;

    private Double attendancePay;

    private Double insurancePay;

    private Integer empId;

    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public Double getBasePay() {
        return basePay;
    }

    public void setBasePay(Double basePay) {
        this.basePay = basePay;
    }

    public Double getOvertimePay() {
        return overtimePay;
    }

    public void setOvertimePay(Double overtimePay) {
        this.overtimePay = overtimePay;
    }

    public Double getMisstimePay() {
        return misstimePay;
    }

    public void setMisstimePay(Double misstimePay) {
        this.misstimePay = misstimePay;
    }

    public Double getAttendancePay() {
        return attendancePay;
    }

    public void setAttendancePay(Double attendancePay) {
        this.attendancePay = attendancePay;
    }

    public Double getInsurancePay() {
        return insurancePay;
    }

    public void setInsurancePay(Double insurancePay) {
        this.insurancePay = insurancePay;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
}