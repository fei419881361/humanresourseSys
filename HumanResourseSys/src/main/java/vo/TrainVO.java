package vo;

import entity.Train;

import java.util.Date;

public class TrainVO {
    private Integer id;

    private Date createDate;

    private Date modifyDate;

    private String trainerName;

    private String theme;

    private String time;

    private String place;

    private String remark;

    private String trainEmp;

    public TrainVO(){}
    public TrainVO(Train entity){
        this.id = entity.getId();
        this.trainerName = entity.getTrainerName();
        this.theme = entity.getTheme();
        this.time = entity.getTime();
        this.place = entity.getPlace();
        this.remark = entity.getRemark();
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
        this.trainerName = trainerName;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTrainEmp() {
        return trainEmp;
    }

    public void setTrainEmp(String trainEmp) {
        this.trainEmp = trainEmp;
    }
}
