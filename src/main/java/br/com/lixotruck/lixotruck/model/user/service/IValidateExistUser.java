package br.com.lixotruck.lixotruck.model.user.service;

public interface IValidateExistUser {

    void validateExistByUsername(String username);

    void validateExistByEmail(String email);
}
