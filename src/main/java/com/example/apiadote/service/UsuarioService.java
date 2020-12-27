package com.example.apiadote.service;

import com.example.apiadote.model.entity.Usuario;

public interface UsuarioService {


    Usuario authenticate (String email, String senha);

    Usuario createUsuario (Usuario usuario);

    public void validEmail(String email);

    public Usuario findById(Long id);

}
