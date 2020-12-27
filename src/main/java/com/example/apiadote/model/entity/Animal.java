package com.example.apiadote.model.entity;



import com.example.apiadote.model.enums.Porte;
import com.example.apiadote.model.enums.Sexo;
import com.example.apiadote.model.enums.TipoAnimal;

import javax.persistence.*;

@Entity
@Table(name="animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipo")
    @Enumerated(value = EnumType.STRING)
    private TipoAnimal tipo;

    @Column(name = "sexo")
    @Enumerated(value = EnumType.STRING)
    private Sexo sexo;

    @Column(name="porte")
    @Enumerated(value= EnumType.STRING)
    private Porte porte;

    @Column(name = "raca")
    private String raca;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "imagem")
    private byte imagem;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "telefone")
    private String telefone;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


    public Animal() {

    }

    public Animal(Long id, String nome, TipoAnimal tipo, Sexo sexo, String raca, String descricao, byte imagem, String cidade, String estado, String telefone, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.sexo = sexo;
        this.raca = raca;
        this.descricao = descricao;
        this.imagem = imagem;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoAnimal getTipo() {
        return tipo;
    }

    public void setTipo(TipoAnimal tipo) {
        this.tipo = tipo;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte getImagem() {
        return imagem;
    }

    public void setImagem(byte imagem) {
        this.imagem = imagem;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

