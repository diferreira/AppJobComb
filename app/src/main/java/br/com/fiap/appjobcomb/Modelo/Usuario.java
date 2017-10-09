package br.com.fiap.appjobcomb.Modelo;

import java.io.Serializable;

/**
 * Created by Diego Ferreira on 08/10/2017.
 */

public class Usuario implements Serializable {

    private Long id;
    private String nome;
    private String sobrenome;
    private String cidade;
    private String pais;
    private String nomeGit;
    private String nomeLinkedin;
    private String site;
    private String sexo;
    private String dataNascimento;
    private String dataCadastro;
    private String senha;


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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNomeGit() {
        return nomeGit;
    }

    public void setNomeGit(String nomeGit) {
        this.nomeGit = nomeGit;
    }

    public String getNomeLinkedin() {
        return nomeLinkedin;
    }

    public void setNomeLinkedin(String nomeLinkedin) {
        this.nomeLinkedin = nomeLinkedin;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return getId() + " - " + getNome();
    }
}
