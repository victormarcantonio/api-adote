package com.example.apiadote.model.repository;

import com.example.apiadote.model.entity.Animal;
import com.example.apiadote.model.entity.Usuario;
import com.example.apiadote.util.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {



    @Override
    public Usuario createUsuario(Usuario usuario){

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(usuario);
        session.getTransaction().commit();
        session.close();
        System.out.println(usuario);

        return usuario;
    }

    @Override
    public Usuario findUsuarioById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Usuario findUsuario =  session.load(Usuario.class, id);

        return findUsuario;

    }

    @Override
    public void updateUsuario(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Usuario usuario = new Usuario();

        Usuario usuarioUpdated = (Usuario)session.get(Usuario.class, id);
        usuarioUpdated.setEmail(usuario.getEmail());
        usuarioUpdated.setSenha(usuario.getSenha());

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteUsuario(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Usuario usuarioDelete = findUsuarioById(id);
        session.delete(usuarioDelete);

        session.getTransaction().commit();

    }

    @Override
    public Usuario findByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Usuario usuario = new Usuario();

        Usuario usuarioByEmail = (Usuario) session.get(Usuario.class, usuario.getEmail());

        return usuarioByEmail;
    }



}
