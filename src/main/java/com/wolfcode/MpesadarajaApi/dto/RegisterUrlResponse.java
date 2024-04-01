package com.wolfcode.MpesadarajaApi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterUrlResponse {

	@JsonProperty("ResponseCode")
	private String ResponseCode;

	@JsonProperty("ResponseDescription")
	private String ResponseDescription;

	@JsonProperty("OriginatorCoversationID")
	private String OriginatorCoversationID;

	@JsonProperty("requestId")
	private String requestId;
}