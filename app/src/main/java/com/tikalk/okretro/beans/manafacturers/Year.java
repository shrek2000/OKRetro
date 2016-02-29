
package com.tikalk.okretro.beans.manafacturers;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Year {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("year")
    @Expose
    private Integer year;

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

    public Year withId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 
     * @param year
     *     The year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    public Year withYear(Integer year) {
        this.year = year;
        return this;
    }

    @Override
    public String toString() {
        return "Year{" +
                "id=" + id +
                ", year=" + year +
                '}';
    }
}
