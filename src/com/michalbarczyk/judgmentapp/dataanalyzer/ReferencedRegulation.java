package com.michalbarczyk.judgmentapp.dataanalyzer;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "journalTitle",
        "journalNo",
        "journalYear",
        "journalEntry",
        "text"
})
public class ReferencedRegulation {

    @JsonProperty("journalTitle")
    private String journalTitle;
    @JsonProperty("journalNo")
    private Integer journalNo;
    @JsonProperty("journalYear")
    private Integer journalYear;
    @JsonProperty("journalEntry")
    private Integer journalEntry;
    @JsonProperty("text")
    private String text;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("journalTitle")
    public String getJournalTitle() {
        return journalTitle;
    }

    @JsonProperty("journalTitle")
    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }

    @JsonProperty("journalNo")
    public Integer getJournalNo() {
        return journalNo;
    }

    @JsonProperty("journalNo")
    public void setJournalNo(Integer journalNo) {
        this.journalNo = journalNo;
    }

    @JsonProperty("journalYear")
    public Integer getJournalYear() {
        return journalYear;
    }

    @JsonProperty("journalYear")
    public void setJournalYear(Integer journalYear) {
        this.journalYear = journalYear;
    }

    @JsonProperty("journalEntry")
    public Integer getJournalEntry() {
        return journalEntry;
    }

    @JsonProperty("journalEntry")
    public void setJournalEntry(Integer journalEntry) {
        this.journalEntry = journalEntry;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
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