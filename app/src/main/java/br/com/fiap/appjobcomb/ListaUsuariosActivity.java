package br.com.fiap.appjobcomb;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import br.com.fiap.appjobcomb.DAO.UsuarioDAO;
import br.com.fiap.appjobcomb.Modelo.Usuario;

public class ListaUsuariosActivity extends AppCompatActivity {

    private ListView listaUsuarios;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);

        listaUsuarios = (ListView) findViewById(R.id.lista_usuarios);

        listaUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
            Usuario usuario = (Usuario) listaUsuarios.getItemAtPosition(position);
                Intent intentVaiproFormulario = new Intent(ListaUsuariosActivity.this, FormularioActivity.class);
                intentVaiproFormulario.putExtra("usuario", usuario);
                startActivity(intentVaiproFormulario);
            }

        });

        Button novoUsuario = (Button) findViewById(R.id.btn_novo_usuario);
        novoUsuario.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaUsuariosActivity.this, FormularioActivity.class);
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });

        registerForContextMenu(listaUsuarios);
    }

    public void carregaLista(){
        UsuarioDAO dao = new UsuarioDAO(this);
        List<Usuario> usuarios = dao.buscaUsuario();
        dao.close();

        ArrayAdapter<Usuario> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, usuarios);
        listaUsuarios.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Usuario usuario = (Usuario) listaUsuarios.getItemAtPosition(info.position);

        final MenuItem itemGit = menu.add("Ir pro Git");
        itemGit.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intentGit = new Intent(ListaUsuariosActivity.this, GitProfileActivity.class);

                ///String git = usuario.getNomeGit();
                //if (!git.startsWith("http://")) {
                // git = "http://github.com/" + git;
                //}

                //intentGit.setData(Uri.parse(git));
                itemGit.setIntent(intentGit);
                startActivity(intentGit);
                return false;
            }
        });

    }

}
