package com.wolfcode.MpesadarajaApi.dto;

public record RegisterUrlRequest(int ShortCode,

                                 String ResponseType,

                                 String ConfirmationURL,

                                 String ValidationURL) {
}
