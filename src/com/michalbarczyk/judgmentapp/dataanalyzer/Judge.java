package com.michalbarczyk.judgmentapp.dataanalyzer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "function",
        "specialRoles"
})
public class Judge {

    @JsonProperty("name")
    private String name;
    @JsonProperty("function")
    private Object function;
    @JsonProperty("specialRoles")
    private List<String> specialRoles = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("function")
    public Object getFunction() {
        return function;
    }

    @JsonProperty("function")
    public void setFunction(Object function) {
        this.function = function;
    }

    @JsonProperty("specialRoles")
    public List<String> getSpecialRoles() {
        return specialRoles;
    }

    @JsonProperty("specialRoles")
    public void setSpecialRoles(List<String> specialRoles) {
        this.specialRoles = specialRoles;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}