package br.com.fiap.appjobcomb.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.appjobcomb.Modelo.Usuario;

import static android.icu.text.MessagePattern.ArgType.SELECT;

/**
 * Created by Diego Ferreira on 08/10/2017.
 */

public class UsuarioDAO extends SQLiteOpenHelper{

    public UsuarioDAO(Context context){
        super(context, "JobComb", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Usuarios (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, sobrenome TEXT, cidade TEXT, pais TEXT, nomeGit TEXT, nomeLinkedin TEXT, site TEXT, sexo TEXT, dataNascimento TEXT, dataCadastro TEXT, senha TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int bancoAntigo, int bancoNovo) {
        String sql = "DROP TABLE IF EXISTS Usuarios;";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Usuario usuario){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosUsuario(usuario);

        db.insert("Usuarios", null, dados);
    }

    public List<Usuario> buscaUsuario(){
        String sql = "SELECT * FROM Usuarios ORDER BY id DESC;";
        //String sql = "SELECT * FROM Usuarios LIMIT 1 order by id DESC;";

        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Usuario> usuarios = new ArrayList<>();
        while (c.moveToNext()){
            Usuario usuario = new Usuario();
            usuario.setId(c.getLong(c.getColumnIndex("id")));
            usuario.setNome(c.getString(c.getColumnIndex("nome")));
            usuario.setSobrenome(c.getString(c.getColumnIndex("sobrenome")));
            usuario.setCidade(c.getString(c.getColumnIndex("cidade")));
            usuario.setPais(c.getString(c.getColumnIndex("pais")));
            usuario.setNomeGit(c.getString(c.getColumnIndex("nomeGit")));
            usuario.setNomeLinkedin(c.getString(c.getColumnIndex("nomeLinkedin")));
            usuario.setSite(c.getString(c.getColumnIndex("site")));
            usuario.setSexo(c.getString(c.getColumnIndex("sexo")));
            usuario.setDataNascimento(c.getString(c.getColumnIndex("dataNascimento")));
            usuario.setDataCadastro(c.getString(c.getColumnIndex("dataCadastro")));
            usuario.setSenha(c.getString(c.getColumnIndex("senha")));
            usuarios.add(usuario);
        }

        c.close();
        return usuarios;
    }

    public  void deleta(Usuario usuario){
        SQLiteDatabase db = getWritableDatabase();
        String [] params = {String.valueOf(usuario.getId())};
        db.delete("Usuarios", "id = ?", params);
    }

    public void altera(Usuario usuario){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosUsuario(usuario);

        String [] params = {String.valueOf(usuario.getId())};
        db.update("Usuarios", dados, "id = ?", params);

    }

    @NonNull
    private ContentValues pegaDadosUsuario(Usuario usuario) {
        ContentValues dados = new ContentValues();
        dados.put("nome", usuario.getNome());
        dados.put("sobrenome", usuario.getSobrenome());
        dados.put("cidade", usuario.getCidade());
        dados.put("pais", usuario.getPais());
        dados.put("nomeGit", usuario.getNomeGit());
        dados.put("nomeLinkedin", usuario.getNomeLinkedin());
        dados.put("site", usuario.getSite());
        dados.put("sexo", usuario.getSexo());
        dados.put("dataNascimento", usuario.getDataNascimento());
        dados.put("dataCadastro", usuario.getDataCadastro());
        dados.put("senha", usuario.getSenha());
        return dados;

    }
}












