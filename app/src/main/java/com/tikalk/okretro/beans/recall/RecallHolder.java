
package com.tikalk.okretro.beans.recall;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class RecallHolder {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("recallNumber")
    @Expose
    private String recallNumber;
    @SerializedName("componentDescription")
    @Expose
    private String componentDescription;
    @SerializedName("manufacturerRecallNumber")
    @Expose
    private String manufacturerRecallNumber;
    @SerializedName("manufacturedFrom")
    @Expose
    private String manufacturedFrom;
    @SerializedName("manufacturedTo")
    @Expose
    private String manufacturedTo;
    @SerializedName("ownerNotificationDate")
    @Expose
    private String ownerNotificationDate;
    @SerializedName("numberOfVehiclesAffected")
    @Expose
    private String numberOfVehiclesAffected;
    @SerializedName("influencedBy")
    @Expose
    private String influencedBy;
    @SerializedName("defectConsequence")
    @Expose
    private String defectConsequence;
    @SerializedName("defectCorrectiveAction")
    @Expose
    private String defectCorrectiveAction;
    @SerializedName("defectDescription")
    @Expose
    private String defectDescription;
    @SerializedName("modelYear")
    @Expose
    private String modelYear;

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The recallNumber
     */
    public String getRecallNumber() {
        return recallNumber;
    }

    /**
     * 
     * @param recallNumber
     *     The recallNumber
     */
    public void setRecallNumber(String recallNumber) {
        this.recallNumber = recallNumber;
    }

    /**
     * 
     * @return
     *     The componentDescription
     */
    public String getComponentDescription() {
        return componentDescription;
    }

    /**
     * 
     * @param componentDescription
     *     The componentDescription
     */
    public void setComponentDescription(String componentDescription) {
        this.componentDescription = componentDescription;
    }

    /**
     * 
     * @return
     *     The manufacturerRecallNumber
     */
    public String getManufacturerRecallNumber() {
        return manufacturerRecallNumber;
    }

    /**
     * 
     * @param manufacturerRecallNumber
     *     The manufacturerRecallNumber
     */
    public void setManufacturerRecallNumber(String manufacturerRecallNumber) {
        this.manufacturerRecallNumber = manufacturerRecallNumber;
    }

    /**
     * 
     * @return
     *     The manufacturedFrom
     */
    public String getManufacturedFrom() {
        return manufacturedFrom;
    }

    /**
     * 
     * @param manufacturedFrom
     *     The manufacturedFrom
     */
    public void setManufacturedFrom(String manufacturedFrom) {
        this.manufacturedFrom = manufacturedFrom;
    }

    /**
     * 
     * @return
     *     The manufacturedTo
     */
    public String getManufacturedTo() {
        return manufacturedTo;
    }

    /**
     * 
     * @param manufacturedTo
     *     The manufacturedTo
     */
    public void setManufacturedTo(String manufacturedTo) {
        this.manufacturedTo = manufacturedTo;
    }

    /**
     * 
     * @return
     *     The ownerNotificationDate
     */
    public String getOwnerNotificationDate() {
        return ownerNotificationDate;
    }

    /**
     * 
     * @param ownerNotificationDate
     *     The ownerNotificationDate
     */
    public void setOwnerNotificationDate(String ownerNotificationDate) {
        this.ownerNotificationDate = ownerNotificationDate;
    }

    /**
     * 
     * @return
     *     The numberOfVehiclesAffected
     */
    public String getNumberOfVehiclesAffected() {
        return numberOfVehiclesAffected;
    }

    /**
     * 
     * @param numberOfVehiclesAffected
     *     The numberOfVehiclesAffected
     */
    public void setNumberOfVehiclesAffected(String numberOfVehiclesAffected) {
        this.numberOfVehiclesAffected = numberOfVehiclesAffected;
    }

    /**
     * 
     * @return
     *     The influencedBy
     */
    public String getInfluencedBy() {
        return influencedBy;
    }

    /**
     * 
     * @param influencedBy
     *     The influencedBy
     */
    public void setInfluencedBy(String influencedBy) {
        this.influencedBy = influencedBy;
    }

    /**
     * 
     * @return
     *     The defectConsequence
     */
    public String getDefectConsequence() {
        return defectConsequence;
    }

    /**
     * 
     * @param defectConsequence
     *     The defectConsequence
     */
    public void setDefectConsequence(String defectConsequence) {
        this.defectConsequence = defectConsequence;
    }

    /**
     * 
     * @return
     *     The defectCorrectiveAction
     */
    public String getDefectCorrectiveAction() {
        return defectCorrectiveAction;
    }

    /**
     * 
     * @param defectCorrectiveAction
     *     The defectCorrectiveAction
     */
    public void setDefectCorrectiveAction(String defectCorrectiveAction) {
        this.defectCorrectiveAction = defectCorrectiveAction;
    }

    /**
     * 
     * @return
     *     The defectDescription
     */
    public String getDefectDescription() {
        return defectDescription;
    }

    /**
     * 
     * @param defectDescription
     *     The defectDescription
     */
    public void setDefectDescription(String defectDescription) {
        this.defectDescription = defectDescription;
    }

    /**
     * 
     * @return
     *     The modelYear
     */
    public String getModelYear() {
        return modelYear;
    }

    /**
     * 
     * @param modelYear
     *     The modelYear
     */
    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    @Override
    public String toString() {
        return "RecallHolder{" +
                "id=" + id +
                ", recallNumber='" + recallNumber + '\'' +
                ", componentDescription='" + componentDescription + '\'' +
                ", manufacturerRecallNumber='" + manufacturerRecallNumber + '\'' +
                ", manufacturedFrom='" + manufacturedFrom + '\'' +
                ", manufacturedTo='" + manufacturedTo + '\'' +
                ", ownerNotificationDate='" + ownerNotificationDate + '\'' +
                ", numberOfVehiclesAffected='" + numberOfVehiclesAffected + '\'' +
                ", influencedBy='" + influencedBy + '\'' +
                ", defectConsequence='" + defectConsequence + '\'' +
                ", defectCorrectiveAction='" + defectCorrectiveAction + '\'' +
                ", defectDescription='" + defectDescription + '\'' +
                ", modelYear='" + modelYear + '\'' +
                '}';
    }
}
