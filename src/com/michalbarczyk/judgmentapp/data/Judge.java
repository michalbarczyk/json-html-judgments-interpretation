package com.michalbarczyk.judgmentapp.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "specialRoles"
})
public class Judge {

    @JsonProperty("name")
    private String name;
    @JsonProperty("specialRoles")
    private List<String> specialRoles = null;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("specialRoles")
    public List<String> getSpecialRoles() {
        return specialRoles;
    }

    @JsonProperty("specialRoles")
    public void setSpecialRoles(List<String> specialRoles) {
        this.specialRoles = specialRoles;
    }


    public Judge(String name, List<String> specialRoles) {

        this.name = name;
        this.specialRoles = specialRoles;
    }

    
    public Judge(String name) {

        this(name, null);
    }

    public Judge() {} //dummy constructor is needed for Jackson


    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Judge))
            return false;
        Judge that = (Judge) other;

        return that.name.equals(this.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}