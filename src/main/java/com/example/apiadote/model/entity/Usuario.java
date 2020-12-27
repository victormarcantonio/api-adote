package com.example.apiadote.model.entity;

import com.example.apiadote.model.builder.UsuarioBuilder;
import org.apache.catalina.valves.rewrite.Substitution;
import org.springframework.stereotype.Component;




import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name="senha")
    private String senha;

    public static UsuarioBuilder builder() {
        return new UsuarioBuilder();
    }

    public Usuario() {
    }

    public Usuario(Long id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
