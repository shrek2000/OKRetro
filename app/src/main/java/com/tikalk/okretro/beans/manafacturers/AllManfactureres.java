
package com.tikalk.okretro.beans.manafacturers;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AllManfactureres {

    @SerializedName("makes")
    @Expose
    private List<Make> makes = new ArrayList<Make>();

    /**
     * 
     * @return
     *     The makes
     */
    public List<Make> getMakes() {
        return makes;
    }

    /**
     * 
     * @param makes
     *     The makes
     */
    public void setMakes(List<Make> makes) {
        this.makes = makes;
    }

    public AllManfactureres withMakes(List<Make> makes) {
        this.makes = makes;
        return this;
    }

}
