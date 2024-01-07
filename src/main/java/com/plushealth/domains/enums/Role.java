package com.plushealth.domains.enums;

public enum Role {
	
	USER(0, "USUARIO"), ADM(1, "ADMINISTRADOR");

	private Integer codigo;
	private String descricao;
	
	private Role(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Role fromCodigo(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (Role role : Role.values()) {
            if (codigo.equals(role.getCodigo())) {
                return role;
            }
        }

        throw new IllegalArgumentException("Código de Role inválido: " + codigo);
    }
}
