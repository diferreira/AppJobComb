package br.com.fiap.appjobcomb;

import android.widget.EditText;

import br.com.fiap.appjobcomb.Modelo.Usuario;

/**
 * Created by Diego Ferreira on 08/10/2017.
 */

public class FormularioHelper {

    private EditText campoNome;
    private EditText campoSobrenome;
    private EditText campoCidade;
    private EditText campoPais;
    private EditText campoNomeGit;
    private EditText campoNomeLinkedin;
    private EditText campoSite;
    private EditText campoSexo;
    private EditText campoDataNascimento;
    private EditText campoDataCadastro;
    private Usuario usuario;

    public FormularioHelper(FormularioActivity activity) {
        this.campoNome = (EditText) activity.findViewById(R.id.formulario_nome);
        this.campoSobrenome = (EditText) activity.findViewById(R.id.formulario_sobrenome);
        this.campoCidade = (EditText) activity.findViewById(R.id.formulario_cidade);
        this.campoPais = (EditText) activity.findViewById(R.id.formulario_pais);
        this.campoNomeGit = (EditText) activity.findViewById(R.id.formulario_nome_git);
        this.campoNomeLinkedin = (EditText) activity.findViewById(R.id.formulario_nome_linkedin);
        this.campoSite = (EditText) activity.findViewById(R.id.formulario_site);
        this.campoSexo = (EditText) activity.findViewById(R.id.formulario_sexo);
        this.campoDataNascimento = (EditText) activity.findViewById(R.id.formulario_data_nascimento);
        this.campoDataCadastro = (EditText) activity.findViewById(R.id.formulario_data_cadastro);
        usuario = new Usuario();
    }

    public Usuario pegaUsuario(){
        usuario.setNome(campoNome.getText().toString());
        usuario.setSobrenome(campoSobrenome.getText().toString());
        usuario.setCidade(campoCidade.getText().toString());
        usuario.setPais(campoCidade.getText().toString());
        usuario.setNomeGit(campoNomeGit.getText().toString());
        usuario.setNomeLinkedin(campoNomeLinkedin.getText().toString());
        usuario.setSite(campoSite.getText().toString());
        usuario.setSexo(campoSexo.getText().toString());
        usuario.setDataNascimento(campoDataNascimento.getText().toString());
        usuario.setDataCadastro(campoDataCadastro.getText().toString());
        return usuario;

    }

    public void preencheFormulario(Usuario usuario){
        campoNome.setText(usuario.getNome());
        campoSobrenome.setText(usuario.getSobrenome());
        campoCidade.setText(usuario.getCidade());
        campoPais.setText(usuario.getPais());
        campoNomeGit.setText(usuario.getNomeGit());
        campoSite.setText(usuario.getSite());
        campoSexo.setText(usuario.getSexo());
        campoDataNascimento.setText(usuario.getDataNascimento());
        campoDataCadastro.setText(usuario.getDataCadastro());
        this.usuario = usuario;
    }

}
