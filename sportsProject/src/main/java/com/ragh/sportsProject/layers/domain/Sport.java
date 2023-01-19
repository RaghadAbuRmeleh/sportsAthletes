package com.ragh.sportsProject.layers.domain;
import java.util.Objects;

public class Sport {
    private String sportName;
    private Integer athletesNum;
    private Double sportTime;
    private String sportPlace;
    private boolean equipmentNeeded;
    private boolean individualOrTeam;

    public Sport() {
    }

    public Sport(String sportName, Integer athletesNum, Double sportTime, String sportPlace, boolean equipmentNeeded, boolean individualOrTeam) {
        this.sportName = sportName;
        this.athletesNum = athletesNum;
        this.sportTime = sportTime;
        this.sportPlace = sportPlace;
        this.equipmentNeeded = equipmentNeeded;
        this.individualOrTeam = individualOrTeam;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public Integer getAthletesNum() {
        return athletesNum;
    }

    public void setAthletesNum(Integer athletesNum) {
        this.athletesNum = athletesNum;
    }

    public Double getSportTime() {
        return sportTime;
    }

    public void setSportTime(Double sportTime) {
        this.sportTime = sportTime;
    }

    public String getSportPlace() {
        return sportPlace;
    }

    public void setSportPlace(String sportPlace) {
        this.sportPlace = sportPlace;
    }

    public boolean isEquipmentNeeded() {
        return equipmentNeeded;
    }

    public void setEquipmentNeeded(boolean equipmentNeeded) {
        this.equipmentNeeded = equipmentNeeded;
    }

    public boolean isIndividualOrTeam() {
        return individualOrTeam;
    }

    public void setIndividualOrTeam(boolean individualOrTeam) {
        this.individualOrTeam = individualOrTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sport sport = (Sport) o;
        return equipmentNeeded == sport.equipmentNeeded && individualOrTeam == sport.individualOrTeam && Objects.equals(sportName, sport.sportName) && Objects.equals(athletesNum, sport.athletesNum) && Objects.equals(sportTime, sport.sportTime) && Objects.equals(sportPlace, sport.sportPlace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sportName, athletesNum, sportTime, sportPlace, equipmentNeeded, individualOrTeam);
    }

    @Override
    public String toString() {
        return "Sport{" +
                "sportName='" + sportName + '\'' +
                ", athletesNum=" + athletesNum +
                ", sportTime=" + sportTime +
                ", sportPlace='" + sportPlace + '\'' +
                ", equipmentNeeded=" + equipmentNeeded +
                ", individualOrTeam=" + individualOrTeam +
                '}';
    }
}
