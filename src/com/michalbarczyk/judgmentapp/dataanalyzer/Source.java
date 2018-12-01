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
        "code",
        "judgmentUrl",
        "judgmentId",
        "publisher",
        "reviser",
        "publicationDate"
})
public class Source {

    @JsonProperty("code")
    private String code;
    @JsonProperty("judgmentUrl")
    private String judgmentUrl;
    @JsonProperty("judgmentId")
    private String judgmentId;
    @JsonProperty("publisher")
    private String publisher;
    @JsonProperty("reviser")
    private String reviser;
    @JsonProperty("publicationDate")
    private String publicationDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("judgmentUrl")
    public String getJudgmentUrl() {
        return judgmentUrl;
    }

    @JsonProperty("judgmentUrl")
    public void setJudgmentUrl(String judgmentUrl) {
        this.judgmentUrl = judgmentUrl;
    }

    @JsonProperty("judgmentId")
    public String getJudgmentId() {
        return judgmentId;
    }

    @JsonProperty("judgmentId")
    public void setJudgmentId(String judgmentId) {
        this.judgmentId = judgmentId;
    }

    @JsonProperty("publisher")
    public String getPublisher() {
        return publisher;
    }

    @JsonProperty("publisher")
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @JsonProperty("reviser")
    public String getReviser() {
        return reviser;
    }

    @JsonProperty("reviser")
    public void setReviser(String reviser) {
        this.reviser = reviser;
    }

    @JsonProperty("publicationDate")
    public String getPublicationDate() {
        return publicationDate;
    }

    @JsonProperty("publicationDate")
    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
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