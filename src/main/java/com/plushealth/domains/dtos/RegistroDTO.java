package com.plushealth.domains.dtos;

import com.plushealth.domains.enums.Role;

public record RegistroDTO(String nome, String login, String password, Role role) {

}
