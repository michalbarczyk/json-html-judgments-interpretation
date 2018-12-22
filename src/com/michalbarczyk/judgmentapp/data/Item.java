package com.michalbarczyk.judgmentapp.data;

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
        "id",
        "courtType",
        "courtCases",
        "judgmentType",
        "judges",
        "source",
        "courtReporters",
        "decision",
        "summary",
        "textContent",
        "legalBases",
        "referencedRegulations",
        "keywords",
        "referencedCourtCases",
        "receiptDate",
        "meansOfAppeal",
        "judgmentResult",
        "lowerCourtJudgments",
        "division",
        "judgmentDate"
})
public class Item {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("courtType")
    private String courtType;
    @JsonProperty("courtCases")
    private List<CourtCase> courtCases = null;
    @JsonProperty("judgmentType")
    private String judgmentType;
    @JsonProperty("judges")
    private List<Judge> judges = null;
    @JsonProperty("source")
    private Source source;
    @JsonProperty("courtReporters")
    private List<String> courtReporters = null;
    @JsonProperty("decision")
    private Object decision;
    @JsonProperty("summary")
    private Object summary;
    @JsonProperty("textContent")
    private String textContent;
    @JsonProperty("legalBases")
    private List<Object> legalBases = null;
    @JsonProperty("referencedRegulations")
    private List<ReferencedRegulation> referencedRegulations = null;
    @JsonProperty("keywords")
    private List<Object> keywords = null;
    @JsonProperty("referencedCourtCases")
    private List<ReferencedCourtCase> referencedCourtCases = null;
    @JsonProperty("receiptDate")
    private String receiptDate;
    @JsonProperty("meansOfAppeal")
    private Object meansOfAppeal;
    @JsonProperty("judgmentResult")
    private Object judgmentResult;
    @JsonProperty("lowerCourtJudgments")
    private List<Object> lowerCourtJudgments = null;
    @JsonProperty("division")
    private Division division;
    @JsonProperty("judgmentDate")
    private String judgmentDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

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

    @JsonProperty("judgmentType")
    public String getJudgmentType() {
        return judgmentType;
    }

    @JsonProperty("judgmentType")
    public void setJudgmentType(String judgmentType) {
        this.judgmentType = judgmentType;
    }

    @JsonProperty("judges")
    public List<Judge> getJudges() {
        return judges;
    }

    @JsonProperty("judges")
    public void setJudges(List<Judge> judges) {
        this.judges = judges;
    }

    @JsonProperty("source")
    public Source getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(Source source) {
        this.source = source;
    }

    @JsonProperty("courtReporters")
    public List<String> getCourtReporters() {
        return courtReporters;
    }

    @JsonProperty("courtReporters")
    public void setCourtReporters(List<String> courtReporters) {
        this.courtReporters = courtReporters;
    }

    @JsonProperty("decision")
    public Object getDecision() {
        return decision;
    }

    @JsonProperty("decision")
    public void setDecision(Object decision) {
        this.decision = decision;
    }

    @JsonProperty("summary")
    public Object getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(Object summary) {
        this.summary = summary;
    }

    @JsonProperty("textContent")
    public String getTextContent() {
        return textContent;
    }

    @JsonProperty("textContent")
    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    @JsonProperty("legalBases")
    public List<Object> getLegalBases() {
        return legalBases;
    }

    @JsonProperty("legalBases")
    public void setLegalBases(List<Object> legalBases) {
        this.legalBases = legalBases;
    }

    @JsonProperty("referencedRegulations")
    public List<ReferencedRegulation> getReferencedRegulations() {
        return referencedRegulations;
    }

    @JsonProperty("referencedRegulations")
    public void setReferencedRegulations(List<ReferencedRegulation> referencedRegulations) {
        this.referencedRegulations = referencedRegulations;
    }

    @JsonProperty("keywords")
    public List<Object> getKeywords() {
        return keywords;
    }

    @JsonProperty("keywords")
    public void setKeywords(List<Object> keywords) {
        this.keywords = keywords;
    }

    @JsonProperty("referencedCourtCases")
    public List<ReferencedCourtCase> getReferencedCourtCases() {
        return referencedCourtCases;
    }

    @JsonProperty("referencedCourtCases")
    public void setReferencedCourtCases(List<ReferencedCourtCase> referencedCourtCases) {
        this.referencedCourtCases = referencedCourtCases;
    }

    @JsonProperty("receiptDate")
    public String getReceiptDate() {
        return receiptDate;
    }

    @JsonProperty("receiptDate")
    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    @JsonProperty("meansOfAppeal")
    public Object getMeansOfAppeal() {
        return meansOfAppeal;
    }

    @JsonProperty("meansOfAppeal")
    public void setMeansOfAppeal(Object meansOfAppeal) {
        this.meansOfAppeal = meansOfAppeal;
    }

    @JsonProperty("judgmentResult")
    public Object getJudgmentResult() {
        return judgmentResult;
    }

    @JsonProperty("judgmentResult")
    public void setJudgmentResult(Object judgmentResult) {
        this.judgmentResult = judgmentResult;
    }

    @JsonProperty("lowerCourtJudgments")
    public List<Object> getLowerCourtJudgments() {
        return lowerCourtJudgments;
    }

    @JsonProperty("lowerCourtJudgments")
    public void setLowerCourtJudgments(List<Object> lowerCourtJudgments) {
        this.lowerCourtJudgments = lowerCourtJudgments;
    }

    @JsonProperty("division")
    public Division getDivision() {
        return division;
    }

    @JsonProperty("division")
    public void setDivision(Division division) {
        this.division = division;
    }

    @JsonProperty("judgmentDate")
    public String getJudgmentDate() {
        return judgmentDate;
    }

    @JsonProperty("judgmentDate")
    public void setJudgmentDate(String judgmentDate) {
        this.judgmentDate = judgmentDate;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    /*public Rubrum getRubrum() {

    }*/
}