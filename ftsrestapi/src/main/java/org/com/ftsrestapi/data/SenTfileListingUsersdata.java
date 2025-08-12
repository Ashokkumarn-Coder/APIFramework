package org.com.ftsrestapi.data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude;

//pojo- plain old java object created

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class SenTfileListingUsersdata {
	
	private  PageDetails pagedetails;
	private  String sortBy;
	private  String Direction;
	private  String senderBuId;
	private  String recipientBuId;
	private  String fileName;
	private  String fileType;
	private  String userName;
	private  String senderEdi;
	private String recipientEdi;
	private  List<Object> aprf;
	private  List<String> snrf;
	private String delete;
	private  Boolean isConfidential;
	private  Boolean isLive;
	private List<String> status;
	private  Map<Object, Object> attributes;
	
	public SenTfileListingUsersdata() {
		
	}
	
	
	// Getters and Setters
    public PageDetails getPageDetails() {
        return pagedetails;
    }

    public void setPageDetails(PageDetails pageDetails) {
        this.pagedetails = pageDetails;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getDirection() {
        return Direction;
    }

    public void setDirection(String direction) {
        this.Direction = direction;
    }

    public String getSenderBuId() {
        return senderBuId;
    }

    public void setSenderBuId(String senderBuId) {
        this.senderBuId = senderBuId;
    }

    public String getRecipientBuId() {
        return recipientBuId;
    }

    public void setRecipientBuId(String recipientBuId) {
        this.recipientBuId = recipientBuId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSenderEdi() {
        return senderEdi;
    }

    public void setSenderEdi(String senderEdi) {
        this.senderEdi = senderEdi;
    }

    public String getRecipientEdi() {
        return recipientEdi;
    }

    public void setRecipientEdi(String recipientEdi) {
        this.recipientEdi = recipientEdi;
    }

    public List<Object> getAprf() {
        return aprf;
    }

    public void setAprf(List<Object> aprf) {
        this.aprf = aprf;
    }

    public List<String> getSnrf() {
        return snrf;
    }

    public void setSnrf(List<String> snrf) {
        this.snrf = snrf;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public Boolean getIsConfidential() {
        return isConfidential;
    }

    public void setIsConfidential(Boolean isConfidential) {
        this.isConfidential = isConfidential;
    }

    public Boolean getIsLive() {
        return isLive;
    }

    public void setIsLive(Boolean isLive) {
        this.isLive = isLive;
    }

    public List<String> getStatus() {
        return status;
    }

    public void setStatus(List<String> status) {
        this.status = status;
    }

    public Map<Object, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<Object, Object> hashMap) {
        this.attributes = hashMap;
    }       
}
	
	
