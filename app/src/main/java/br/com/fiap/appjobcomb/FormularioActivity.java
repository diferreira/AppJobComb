package br.com.fiap.appjobcomb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.fiap.appjobcomb.DAO.UsuarioDAO;
import br.com.fiap.appjobcomb.Modelo.Usuario;

public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
       this.helper = new FormularioHelper(this);

        Intent intent = getIntent();
        Usuario usuario = (Usuario) intent.getSerializableExtra("usuario");
        if(usuario != null){
            helper.preencheFormulario(usuario);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case R.id.menu_formulario_ok:
               Usuario usuario = helper.pegaUsuario();
               UsuarioDAO dao = new UsuarioDAO(this);
               if(usuario.getId() != null){
                   dao.altera(usuario);
                   Toast.makeText(FormularioActivity.this, "Usuario" + usuario.getNome() + " alterado", Toast.LENGTH_SHORT).show();
               } else {
                   dao.insere(usuario);
                   Toast.makeText(FormularioActivity.this, "Usuario" + usuario.getNome() + " salvo", Toast.LENGTH_SHORT).show();
               }

               dao.close();

               finish();
               break;
       }
        return super.onOptionsItemSelected(item);
    }
}
