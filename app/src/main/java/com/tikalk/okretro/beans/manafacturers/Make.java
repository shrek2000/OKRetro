
package com.tikalk.okretro.beans.manafacturers;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Make {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("niceName")
    @Expose
    private String niceName;
    @SerializedName("models")
    @Expose
    private List<Model> models = new ArrayList<Model>();

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

    public Make withId(Integer id) {
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

    public Make withName(String name) {
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

    public Make withNiceName(String niceName) {
        this.niceName = niceName;
        return this;
    }

    /**
     * 
     * @return
     *     The models
     */
    public List<Model> getModels() {
        return models;
    }

    /**
     * 
     * @param models
     *     The models
     */
    public void setModels(List<Model> models) {
        this.models = models;
    }

    public Make withModels(List<Model> models) {
        this.models = models;
        return this;
    }

}
