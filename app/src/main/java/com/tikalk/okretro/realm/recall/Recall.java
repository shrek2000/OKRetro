package com.tikalk.okretro.realm.recall;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;

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

    @Override
    public String toString() {
        return "Recall{" +
                "recallHolder=" + recallHolder +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recall)) return false;

        Recall recall = (Recall) o;

        return recallHolder != null ? recallHolder.equals(recall.recallHolder) : recall.recallHolder == null;

    }

    @Override
    public int hashCode() {
        return recallHolder != null ? recallHolder.hashCode() : 0;
    }
}
