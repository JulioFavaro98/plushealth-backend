package com.plushealth.domains.enums;

public enum Role {
	
	USER("usuario"), ADMIN("admin");

	private String descricao;
	
	private Role(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
