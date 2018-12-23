package com.michalbarczyk.judgmentapp.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.swing.text.Document;
import javax.swing.text.Element;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "courtType",
        "courtCases",
        "judges",
        "textContent",
        "referencedRegulations",
        "judgmentDate"
})
public class Item {

    @JsonProperty("courtType")
    private String courtType;
    @JsonProperty("courtCases")
    private List<CourtCase> courtCases = null;
    @JsonProperty("judges")
    private List<Judge> judges = null;
    @JsonProperty("textContent")
    private String textContent;
    @JsonProperty("referencedRegulations")
    private List<ReferencedRegulation> referencedRegulations = null;
    @JsonProperty("judgmentDate")
    private String judgmentDate;


    @JsonProperty("courtType")
    public String getCourtType() {
        return courtType;
    }

    @JsonProperty("courtType")
    public void setCourtType(String courtType) {
        this.courtType = courtType;
    }

    @JsonProperty("courtCases")
    public List<CourtCase> getCourtCases() {
        return courtCases;
    }

    @JsonProperty("courtCases")
    public void setCourtCases(List<CourtCase> courtCases) {
        this.courtCases = courtCases;
    }

    @JsonProperty("judges")
    public List<Judge> getJudges() {
        return judges;
    }

    @JsonProperty("judges")
    public void setJudges(List<Judge> judges) {
        this.judges = judges;
    }

    @JsonProperty("textContent")
    public String getTextContent() {
        return textContent;
    }

    @JsonProperty("textContent")
    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }


    @JsonProperty("referencedRegulations")
    public List<ReferencedRegulation> getReferencedRegulations() {
        return referencedRegulations;
    }

    @JsonProperty("referencedRegulations")
    public void setReferencedRegulations(List<ReferencedRegulation> referencedRegulations) {
        this.referencedRegulations = referencedRegulations;
    }

    @JsonProperty("judgmentDate")
    public String getJudgmentDate() {
        return judgmentDate;
    }

    @JsonProperty("judgmentDate")
    public void setJudgmentDate(String judgmentDate) {
        this.judgmentDate = judgmentDate;
    }


}