
package com.tikalk.okretro.beans.manafacturers;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("niceName")
    @Expose
    private String niceName;
    @SerializedName("years")
    @Expose
    private List<Year> years = new ArrayList<Year>();

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    public Model withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public Model withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The niceName
     */
    public String getNiceName() {
        return niceName;
    }

    /**
     * 
     * @param niceName
     *     The niceName
     */
    public void setNiceName(String niceName) {
        this.niceName = niceName;
    }

    public Model withNiceName(String niceName) {
        this.niceName = niceName;
        return this;
    }

    /**
     * 
     * @return
     *     The years
     */
    public List<Year> getYears() {
        return years;
    }

    /**
     * 
     * @param years
     *     The years
     */
    public void setYears(List<Year> years) {
        this.years = years;
    }

    public Model withYears(List<Year> years) {
        this.years = years;
        return this;
    }

}
