package com.ragh.sportsProject.layers.dto;


//data transfer object
public class SportDto {
    private String sportName;
    private Integer athletesNum;
    private Double sportTime;
    private String sportPlace;
    private boolean equipmentNeeded;
    private boolean individualOrTeam;

    @Override
    public String toString() {
        return "SportDto{" +
                "sportName='" + sportName + '\'' +
                ", athletesNum=" + athletesNum +
                ", sportTime=" + sportTime +
                ", sportPlace='" + sportPlace + '\'' +
                ", equipmentNeeded=" + equipmentNeeded +
                ", individualOrTeam=" + individualOrTeam +
                '}';
    }

    public SportDto() {
    }

    public SportDto(String sportName, Integer athletesNum, Double sportTime, String sportPlace, boolean equipmentNeeded, boolean individualOrTeam) {
        this.sportName = sportName;
        this.athletesNum = athletesNum;
        this.sportTime = sportTime;
        this.sportPlace = sportPlace;
        this.equipmentNeeded = equipmentNeeded;
        this.individualOrTeam = individualOrTeam;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public void setAthletesNum(Integer athletesNum) {
        this.athletesNum = athletesNum;
    }

    public void setSportTime(Double sportTime) {
        this.sportTime = sportTime;
    }

    public void setSportPlace(String sportPlace) {
        this.sportPlace = sportPlace;
    }

    public void setEquipmentNeeded(boolean equipmentNeeded) {
        this.equipmentNeeded = equipmentNeeded;
    }

    public void setIndividualOrTeam(boolean individualOrTeam) {
        this.individualOrTeam = individualOrTeam;
    }

    public String getSportName() {
        return sportName;
    }

    public Integer getAthletesNum() {
        return athletesNum;
    }

    public Double getSportTime() {
        return sportTime;
    }

    public String getSportPlace() {
        return sportPlace;
    }

    public boolean isEquipmentNeeded() {
        return equipmentNeeded;
    }

    public boolean isIndividualOrTeam() {
        return individualOrTeam;
    }
}
