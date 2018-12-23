package com.michalbarczyk.judgmentapp.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "caseNumber"
})
public class CourtCase {

    @JsonProperty("caseNumber")
    private String caseNumber;

    public CourtCase(String caseNumber) {

        this.caseNumber = caseNumber;
    }

    public CourtCase() {} //dummy constructor is needed for Jackson

    @JsonProperty("caseNumber")
    public String getCaseNumber() {
        return caseNumber;
    }

    @JsonProperty("caseNumber")
    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

}