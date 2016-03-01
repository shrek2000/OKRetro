package com.tikalk.okretro.realm.recall;

import io.realm.RealmObject;

/**
 * Created by oren on 01/03/16.
 */
public class RecallHolder  extends RealmObject {
    private Integer id;
    private String recallNumber;
    private String componentDescription;
    private String manufacturerRecallNumber;
    private String manufacturedFrom;
    private String manufacturedTo;
    private String ownerNotificationDate;
    private String numberOfVehiclesAffected;
    private String influencedBy;
    private String defectConsequence;
    private String defectCorrectiveAction;
    private String defectDescription;
    private String modelYear;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecallNumber() {
        return recallNumber;
    }

    public void setRecallNumber(String recallNumber) {
        this.recallNumber = recallNumber;
    }

    public String getComponentDescription() {
        return componentDescription;
    }

    public void setComponentDescription(String componentDescription) {
        this.componentDescription = componentDescription;
    }

    public String getManufacturerRecallNumber() {
        return manufacturerRecallNumber;
    }

    public void setManufacturerRecallNumber(String manufacturerRecallNumber) {
        this.manufacturerRecallNumber = manufacturerRecallNumber;
    }

    public String getManufacturedFrom() {
        return manufacturedFrom;
    }

    public void setManufacturedFrom(String manufacturedFrom) {
        this.manufacturedFrom = manufacturedFrom;
    }

    public String getManufacturedTo() {
        return manufacturedTo;
    }

    public void setManufacturedTo(String manufacturedTo) {
        this.manufacturedTo = manufacturedTo;
    }

    public String getOwnerNotificationDate() {
        return ownerNotificationDate;
    }

    public void setOwnerNotificationDate(String ownerNotificationDate) {
        this.ownerNotificationDate = ownerNotificationDate;
    }

    public String getNumberOfVehiclesAffected() {
        return numberOfVehiclesAffected;
    }

    public void setNumberOfVehiclesAffected(String numberOfVehiclesAffected) {
        this.numberOfVehiclesAffected = numberOfVehiclesAffected;
    }

    public String getInfluencedBy() {
        return influencedBy;
    }

    public void setInfluencedBy(String influencedBy) {
        this.influencedBy = influencedBy;
    }

    public String getDefectConsequence() {
        return defectConsequence;
    }

    public void setDefectConsequence(String defectConsequence) {
        this.defectConsequence = defectConsequence;
    }

    public String getDefectCorrectiveAction() {
        return defectCorrectiveAction;
    }

    public void setDefectCorrectiveAction(String defectCorrectiveAction) {
        this.defectCorrectiveAction = defectCorrectiveAction;
    }

    public String getDefectDescription() {
        return defectDescription;
    }

    public void setDefectDescription(String defectDescription) {
        this.defectDescription = defectDescription;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }
}
