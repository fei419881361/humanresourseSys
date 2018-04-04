package entity;

import vo.TrainVO;

import java.util.Date;

public class Train {
    private Integer id;

    private Date createDate;

    private Date modifyDate;

    private String trainerName;

    private String theme;

    private String time;

    private String place;

    private String remark;

    private Integer eId;

    public Train(){}
    public Train(TrainVO vo) {
        this.id = vo.getId();
        this.trainerName = vo.getTrainerName();
        this.theme = vo.getTheme();
        this.time = vo.getTime();
        this.place = vo.getPlace();
        this.remark = vo.getRemark();
        this.eId = vo.geteId();
    }


    public Integer getEId() {
        return eId;
    }

    public void setEId(Integer eId) {
        this.eId = eId;
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

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName == null ? null : trainerName.trim();
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}