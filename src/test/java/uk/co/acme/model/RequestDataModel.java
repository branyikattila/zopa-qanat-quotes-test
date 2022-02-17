package uk.co.acme.model;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class RequestDataModel {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("payload")
    @Expose
    private String payload;
    @SerializedName("memberId")
    @Expose
    private String memberId;
    @SerializedName("expectedResponseCode")
    @Expose
    private String expectedResponseCode;
    @SerializedName("expectedResponseMsg")
    @Expose
    private QuoteResponseDataModel expectedResponseMsg;
    @SerializedName("expectedFailMsg")
    @Expose
    private String expectedFailMsg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getExpectedResponseCode() {
        return expectedResponseCode;
    }

    public void setExpectedResponseCode(String expectedResponseCode) {
        this.expectedResponseCode = expectedResponseCode;
    }

    public QuoteResponseDataModel getExpectedResponseMsg() {
        return expectedResponseMsg;
    }

    public void setExpectedResponseMsg(QuoteResponseDataModel expectedResponseMsg) {
        this.expectedResponseMsg = expectedResponseMsg;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getExpectedFailMsg() {
        return expectedFailMsg;
    }

    public void setExpectedFailMsg() {
        this.expectedFailMsg = expectedFailMsg;
    }
}