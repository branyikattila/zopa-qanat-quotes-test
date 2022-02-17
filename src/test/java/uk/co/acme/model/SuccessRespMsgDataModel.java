package uk.co.acme.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class SuccessRespMsgDataModel {

    @SerializedName("memberId")
    @Expose
    private String memberId;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("address")
    @Expose
    private AddressDataModel address;
    @SerializedName("emailAddress")
    @Expose
    private String emailAddress;
    @SerializedName("jobTitle")
    @Expose
    private String jobTitle;
    @SerializedName("memberFullName")
    @Expose
    private String memberFullName;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}