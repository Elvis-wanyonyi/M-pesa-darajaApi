package com.wolfcode.MpesadarajaApi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterUrlRequest {

	@JsonProperty("ShortCode")
	private String shortCode;

	@JsonProperty("ConfirmationURL")
	private String confirmationURL;

	@JsonProperty("ValidationURL")
	private String validationURL;

	@JsonProperty("ResponseType")
	private String responseType;
}