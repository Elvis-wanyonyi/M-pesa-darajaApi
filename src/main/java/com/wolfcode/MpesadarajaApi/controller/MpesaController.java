package com.wolfcode.MpesadarajaApi.controller;

import com.wolfcode.MpesadarajaApi.dto.TokenResponse;
import com.wolfcode.MpesadarajaApi.service.DarajaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mpesa/")
public class MpesaController {

    private final DarajaService darajaService;

    @GetMapping("token")
    public ResponseEntity<TokenResponse> getAccessToken(){
        return ResponseEntity.ok(darajaService.getAccessToken());
    }
}
