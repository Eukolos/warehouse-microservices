package com.istanify.finance.client;

public record AccountDto(Long id, String name, String description, Double balance, Integer accountTypeCode) {}