package uk.co.acme.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class QuoteResponseDataModel {

    @SerializedName("quoteId")
    @Expose
    private String quoteId;
    @SerializedName("quoteOffered")
    @Expose
    private Boolean quoteOffered;
    @SerializedName("amountToBorrow")
    @Expose
    private Integer amountToBorrow;
    @SerializedName("termLength")
    @Expose
    private Integer termLength;
    @SerializedName("interestRate")
    @Expose
    private Double interestRate;
    @SerializedName("memberId")
    @Expose
    private String memberId;
    @SerializedName("membersFullName")
    @Expose
    private Object membersFullName;

    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public Boolean getQuoteOffered() {
        return quoteOffered;
    }

    public void setQuoteOffered(Boolean quoteOffered) {
        this.quoteOffered = quoteOffered;
    }

    public Integer getAmountToBorrow() {
        return amountToBorrow;
    }

    public void setAmountToBorrow(Integer amountToBorrow) {
        this.amountToBorrow = amountToBorrow;
    }

    public Integer getTermLength() {
        return termLength;
    }

    public void setTermLength(Integer termLength) {
        this.termLength = termLength;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Object getMembersFullName() {
        return membersFullName;
    }

    public void setMembersFullName(Object membersFullName) {
        this.membersFullName = membersFullName;
    }

}
