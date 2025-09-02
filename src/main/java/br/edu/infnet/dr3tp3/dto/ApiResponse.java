package br.edu.infnet.dr3tp3.dto;

public record ApiResponse<T>(
        int statusCode,
        String message,
        T data
) {}
