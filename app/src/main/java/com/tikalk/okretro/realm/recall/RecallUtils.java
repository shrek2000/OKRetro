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

    public static final  com.tikalk.okretro.beans.recall.Recall convert( Recall recall){
        com.tikalk.okretro.beans.recall.Recall retVal = new com.tikalk.okretro.beans.recall.Recall();
        List<com.tikalk.okretro.beans.recall.RecallHolder> recallHolders = new ArrayList<>();
        for(RecallHolder recallHolder : recall.getRecallHolder()){
            recallHolders.add(convert(recallHolder));
        }
        retVal.setRecallHolder(recallHolders);
        return retVal;
    }

    public static final com.tikalk.okretro.beans.recall.RecallHolder convert(RecallHolder recallHolder){
        com.tikalk.okretro.beans.recall.RecallHolder  retVal =  new com.tikalk.okretro.beans.recall.RecallHolder ();
        retVal.setComponentDescription(recallHolder.getComponentDescription());
        retVal.setDefectConsequence(recallHolder.getDefectConsequence());
        retVal.setDefectCorrectiveAction(recallHolder.getDefectCorrectiveAction());
        retVal.setId(recallHolder.getId());
        retVal.setRecallNumber(recallHolder.getRecallNumber());
        retVal.setManufacturerRecallNumber(recallHolder.getManufacturerRecallNumber());
        retVal.setManufacturedFrom(recallHolder.getManufacturedFrom());
        retVal.setManufacturedTo(recallHolder.getManufacturedTo());
        retVal.setOwnerNotificationDate(recallHolder.getOwnerNotificationDate());
        retVal.setNumberOfVehiclesAffected(recallHolder.getNumberOfVehiclesAffected());
        retVal.setInfluencedBy(recallHolder.getInfluencedBy());
        retVal.setDefectDescription(recallHolder.getDefectDescription());
        retVal.setModelYear(recallHolder.getModelYear());
        return retVal;
    }

    public static final Recall convert(Realm realm, com.tikalk.okretro.beans.recall.Recall recall){
        Recall retVal = realm.createObject(Recall.class);
        RealmList<RecallHolder> recallHolders = new RealmList<>();
       for(com.tikalk.okretro.beans.recall.RecallHolder recallHolder : recall.getRecallHolder()){
           recallHolders.add(convert(realm,recallHolder));
       }
        retVal.setRecallHolder(recallHolders);
        return retVal;
    }

    public static final RecallHolder convert(Realm realm,com.tikalk.okretro.beans.recall.RecallHolder recallHolder){
        RecallHolder retVal =  realm.createObject(RecallHolder.class);
        retVal.setComponentDescription(recallHolder.getComponentDescription());
        retVal.setDefectConsequence(recallHolder.getDefectConsequence());
        retVal.setDefectCorrectiveAction(recallHolder.getDefectCorrectiveAction());
        retVal.setId(recallHolder.getId());
        retVal.setRecallNumber(recallHolder.getRecallNumber());
        retVal.setManufacturerRecallNumber(recallHolder.getManufacturerRecallNumber());
        retVal.setManufacturedFrom(recallHolder.getManufacturedFrom());
        retVal.setManufacturedTo(recallHolder.getManufacturedTo());
        retVal.setOwnerNotificationDate(recallHolder.getOwnerNotificationDate());
        retVal.setNumberOfVehiclesAffected(recallHolder.getNumberOfVehiclesAffected());
        retVal.setInfluencedBy(recallHolder.getInfluencedBy());
        retVal.setDefectDescription(recallHolder.getDefectDescription());
        retVal.setModelYear(recallHolder.getModelYear());
        return retVal;
    }
}
