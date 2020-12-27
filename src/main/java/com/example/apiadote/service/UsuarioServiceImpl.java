package com.example.apiadote.service;

import com.example.apiadote.exception.ErroAutenticacao;
import com.example.apiadote.exception.RegraNegocioException;
import com.example.apiadote.model.entity.Usuario;
import com.example.apiadote.model.repository.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    @Autowired
    UsuarioDAO usuarioDAO;

    @Override
    public Usuario authenticate(String email, String senha) {

        Usuario usuario = usuarioDAO.findByEmail(email);

        if(usuario!=null) {
           throw new ErroAutenticacao ("Usuário não encontrado para o e-mail informado");
        }
        if(!usuario.getSenha().contentEquals(senha)){
            throw new ErroAutenticacao("Autenticação Inválida");
        }

        return usuario;
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {


       usuarioDAO.createUsuario(usuario);

       return usuario;
    }

    @Override
    public void validEmail(String email) {

       Usuario usuarioExistente = usuarioDAO.findByEmail(email);
       if(usuarioExistente!=null){
           throw new RegraNegocioException("Já existe um usuário cadastrado com este e-mail");
       }


    }

    @Override
    public Usuario findById(Long id) {

        return usuarioDAO.findUsuarioById(id);
    }
}
