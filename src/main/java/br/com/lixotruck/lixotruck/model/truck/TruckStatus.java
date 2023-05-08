package br.com.lixotruck.lixotruck.model.truck;

public enum TruckStatus {

    OK("Ok"),
    MAINTENANCE("Em manutenção"),
    BROKE("Quebrado");

    private String description;

    TruckStatus(String description) {
        this.description = description;
    }
}
