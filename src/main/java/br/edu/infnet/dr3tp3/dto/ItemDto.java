package br.edu.infnet.dr3tp3.dto;

public record ItemDto(
        Long id,
        String type,
        String isbn13,
        Double price,
        Integer numberinstock
) {}
