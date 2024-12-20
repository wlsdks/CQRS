package com.example.cqrs.query.controller;

import com.example.cqrs.query.document.AccountDocument;
import com.example.cqrs.query.usecase.AccountQueryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
@RestController
public class AccountQueryController {

    private final AccountQueryUseCase accountQueryUseCase;

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDocument> getAccount(
            @PathVariable String accountId
    ) {
        return accountQueryUseCase.getAccount(accountId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
