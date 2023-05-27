package br.com.lixotruck.lixotruck.model.region.dtos;

import br.com.lixotruck.lixotruck.model.region.Street;

public record StreetDTO(
        String nome
) {
    public StreetDTO(Street street) {
        this(street.getName());
    }
}
