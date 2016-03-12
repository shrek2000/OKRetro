package com.tikalk.okretro.realm.recall;

import com.tikalk.okretro.beans.recall.*;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;

/**
 * Created by oren on 02/03/16.
 */
public class RecallUtils {

    public static final com.tikalk.okretro.beans.recall.Recall convert(Recall recall) {
        com.tikalk.okretro.beans.recall.Recall retVal = new com.tikalk.okretro.beans.recall.Recall();
        List<com.tikalk.okretro.beans.recall.RecallHolder> recallHolders = new ArrayList<>();
        for (RecallHolder recallHolder : recall.getRecallHolder()) {
            recallHolders.add(convert(recallHolder));
        }
        retVal.setRecallHolder(recallHolders);
        return retVal;
    }

    public static final com.tikalk.okretro.beans.recall.RecallHolder convert(RecallHolder recallHolder) {
        com.tikalk.okretro.beans.recall.RecallHolder retVal = new com.tikalk.okretro.beans.recall.RecallHolder();
        retVal.setComponentDescription(recallHolder.componentDescription);
        retVal.setDefectConsequence(recallHolder.defectConsequence);
        retVal.setDefectCorrectiveAction(recallHolder.defectCorrectiveAction);
        retVal.setId(recallHolder.id);
        retVal.setRecallNumber(recallHolder.recallNumber);
        retVal.setManufacturedFrom(recallHolder.manufacturedFrom);
        retVal.setManufacturedTo(recallHolder.manufacturedTo);
        retVal.setOwnerNotificationDate(recallHolder.ownerNotificationDate);
        retVal.setNumberOfVehiclesAffected(recallHolder.numberOfVehiclesAffected);
        retVal.setInfluencedBy(recallHolder.influencedBy);
        retVal.setDefectDescription(recallHolder.defectDescription);
        retVal.setModelYear(recallHolder.modelYear);
        return retVal;
    }

    public static final Recall convert(Realm realm, com.tikalk.okretro.beans.recall.Recall recall) {
        Recall retVal = realm.createObject(Recall.class);
        RealmList<RecallHolder> recallHolders = new RealmList<>();
        for (com.tikalk.okretro.beans.recall.RecallHolder recallHolder : recall.getRecallHolder()) {
            recallHolders.add(convert(realm, recallHolder));
        }
        retVal.setRecallHolder(recallHolders);
        return retVal;
    }

    public static final RecallHolder convert(Realm realm, com.tikalk.okretro.beans.recall.RecallHolder recallHolder) {
        RecallHolder retVal = realm.createObject(RecallHolder.class);
        retVal.componentDescription = recallHolder.getComponentDescription();
        retVal.defectConsequence = recallHolder.getDefectConsequence();
        retVal.defectCorrectiveAction = recallHolder.getDefectCorrectiveAction();
        retVal.id = recallHolder.getId();
        retVal.recallNumber = recallHolder.getRecallNumber();
        retVal.manufacturerRecallNumber = recallHolder.getManufacturerRecallNumber();
        retVal.manufacturedFrom = recallHolder.getManufacturedFrom();
        retVal.manufacturedTo = recallHolder.getManufacturedTo();
        retVal.ownerNotificationDate = recallHolder.getOwnerNotificationDate();
        retVal.numberOfVehiclesAffected = recallHolder.getNumberOfVehiclesAffected();
        retVal.influencedBy = recallHolder.getInfluencedBy();
        retVal.defectDescription = recallHolder.getDefectDescription();
        retVal.modelYear = recallHolder.getModelYear();
        return retVal;
    }
}
