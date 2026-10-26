package com.enialcode.helpdesk_pro.domain.dtos;

import com.enialcode.helpdesk_pro.domain.enums.Perfil;

public record RegisterDTO(String nome, String email, String senha, Perfil perfil) {
}