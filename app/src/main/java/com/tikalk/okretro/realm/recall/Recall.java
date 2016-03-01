package com.tikalk.okretro.realm.recall;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by oren on 01/03/16.
 */
public class Recall extends RealmObject {
    private RealmList<RecallHolder> recallHolder = new RealmList<RecallHolder>();

    public RealmList<RecallHolder> getRecallHolder() {
        return recallHolder;
    }

    public void setRecallHolder(RealmList<RecallHolder> recallHolder) {
        this.recallHolder = recallHolder;
    }
}
