package com.example.apiadote.model.repository;

import com.example.apiadote.model.entity.Animal;
import com.example.apiadote.model.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioDAO {


    public Usuario createUsuario(Usuario usuario);


    public void updateUsuario(Long id);

    public Usuario findUsuarioById(Long id);

    public void deleteUsuario(Long id);

    public Usuario findByEmail(String email);


}
