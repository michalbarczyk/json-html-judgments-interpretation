package com.michalbarczyk.judgmentapp.objectrep;

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
        "caseNumber",
        "judgmentIds",
        "generated"
})
public class ReferencedCourtCase {

    @JsonProperty("caseNumber")
    private String caseNumber;
    @JsonProperty("judgmentIds")
    private List<Object> judgmentIds = null;
    @JsonProperty("generated")
    private Boolean generated;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("caseNumber")
    public String getCaseNumber() {
        return caseNumber;
    }

    @JsonProperty("caseNumber")
    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    @JsonProperty("judgmentIds")
    public List<Object> getJudgmentIds() {
        return judgmentIds;
    }

    @JsonProperty("judgmentIds")
    public void setJudgmentIds(List<Object> judgmentIds) {
        this.judgmentIds = judgmentIds;
    }

    @JsonProperty("generated")
    public Boolean getGenerated() {
        return generated;
    }

    @JsonProperty("generated")
    public void setGenerated(Boolean generated) {
        this.generated = generated;
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