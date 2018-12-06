package com.michalbarczyk.judgmentapp.objectrep;

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

    @JsonProperty("caseNumber")
    public String getCaseNumber() {
        return caseNumber;
    }

    @JsonProperty("caseNumber")
    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

}