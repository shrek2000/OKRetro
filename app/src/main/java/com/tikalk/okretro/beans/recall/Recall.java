
package com.tikalk.okretro.beans.recall;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Recall {

    @SerializedName("recallHolder")
    @Expose
    private List<RecallHolder> recallHolder = new ArrayList<RecallHolder>();

    /**
     * 
     * @return
     *     The recallHolder
     */
    public List<RecallHolder> getRecallHolder() {
        return recallHolder;
    }

    /**
     * 
     * @param recallHolder
     *     The recallHolder
     */
    public void setRecallHolder(List<RecallHolder> recallHolder) {
        this.recallHolder = recallHolder;
    }

    @Override
    public String toString() {
        return "Recall{" +
                "recallHolder=" + recallHolder +
                '}';
    }
}
