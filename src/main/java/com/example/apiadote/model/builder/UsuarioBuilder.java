package com.example.apiadote.model.builder;

import com.example.apiadote.model.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioBuilder {

    private String email;
    private String senha;

    public UsuarioBuilder(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public UsuarioBuilder() {
    }

    public UsuarioBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UsuarioBuilder senha(String senha) {
        this.senha = senha;
        return this;
    }

    public Usuario build () {
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);
        return usuario;
    }
}
