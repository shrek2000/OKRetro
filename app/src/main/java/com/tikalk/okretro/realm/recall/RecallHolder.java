package com.tikalk.okretro.realm.recall;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by oren on 01/03/16.
 */
public class RecallHolder  extends RealmObject {
    @Required
    public Integer id;
    public String recallNumber;
    public String componentDescription;
    public String manufacturerRecallNumber;
    public String manufacturedFrom;
    public String manufacturedTo;
    public String ownerNotificationDate;
    public String numberOfVehiclesAffected;
    public String influencedBy;
    public String defectConsequence;
    public String defectCorrectiveAction;
    public String defectDescription;
    public String modelYear;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecallHolder)) return false;

        RecallHolder that = (RecallHolder) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
