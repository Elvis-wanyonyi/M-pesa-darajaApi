package com.wolfcode.MpesadarajaApi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wolfcode.MpesadarajaApi.config.MpesaConfig;
import com.wolfcode.MpesadarajaApi.dto.TokenResponse;
import com.wolfcode.MpesadarajaApi.utils.HelperUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.wolfcode.MpesadarajaApi.utils.Constants.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class DarajaService {

    private final ObjectMapper objectMapper;
    private final OkHttpClient okHttpClient;
    private final MpesaConfig mpesaConfig;

    public TokenResponse getAccessToken() {

        String encodedCredentials = HelperUtility.toBase64String(String.format("%s:%s", mpesaConfig.getConsumerKey(),
                mpesaConfig.getConsumerSecret()));

        Request request = new Request.Builder()
                .url(String.format("%s?grant_type=%s", mpesaConfig.getOauthEndpoint(), mpesaConfig.getGrantType()))
                .get()
                .addHeader(AUTHORIZATION_HEADER_STRING, String.format("%s %s", BASIC_AUTH_STRING, encodedCredentials))
                .addHeader(CACHE_CONTROL_HEADER, CACHE_CONTROL_HEADER_VALUE)
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            assert response.body() != null;

            // use Jackson to Decode the ResponseBody ...
            return objectMapper.readValue(response.body().string(), TokenResponse.class);
        } catch (IOException e) {
            log.error(String.format("Could not get access token. -> %s", e.getLocalizedMessage()));
            return null;
        }
    }
}
