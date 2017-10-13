package br.com.fiap.appjobcomb;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import br.com.fiap.appjobcomb.Modelo.GitProfile;
import br.com.fiap.appjobcomb.api.Client;
import br.com.fiap.appjobcomb.api.GitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GitProfileActivity extends AppCompatActivity {

    TextView Disconnected;
    ProgressDialog pd;

    private ImageView imageView;
    private TextView Login, Htmlurl, Name, Company, Location, Bio,PublicRepos, PublicGists, Followers, Following, Blog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_profile);

        // Loading animation...
        pd = new ProgressDialog(this);
        pd.setMessage(getString(R.string.atualizando));
        pd.setCancelable(false);
        pd.show();

        //imageView = (ImageView) findViewById(R.id.cover);
        Login = (TextView) findViewById(R.id.tvLogin);
        Htmlurl = (TextView) findViewById(R.id.tvLinkGitProfile);
        Name = (TextView) findViewById(R.id.tvNome);
        Company = (TextView) findViewById(R.id.tvCompany);
        Location = (TextView) findViewById(R.id.tvCidade);
        Bio = (TextView) findViewById(R.id.tvBio);
        PublicRepos = (TextView) findViewById(R.id.tvPublicReposNumber);
        PublicGists = (TextView) findViewById(R.id.tvPublicGistsNumber);
        Followers = (TextView) findViewById(R.id.tvfollowersNumber);
        Following = (TextView) findViewById(R.id.tvFolloingNumber);
        Blog = (TextView) findViewById(R.id.tvLinkBlog);

        loadJSON();

    }

    // loadJSON - CARREGA O JSON.
    private void loadJSON(){
        Disconnected = (TextView) findViewById(R.id.disconnected);
        try{
            Client Client = new Client();
            GitService apiService =
                    br.com.fiap.appjobcomb.api.Client.getClient().create(GitService.class);
            Call<GitProfile> call = apiService.getProfile();
            call.enqueue(new Callback<GitProfile> () {
                @Override
                public void onResponse(Call<GitProfile> call, Response<GitProfile> response) {

                    GitProfile profile = response.body();
                    //Toast.makeText(GitProfileActivity.this, profile.toString(), Toast.LENGTH_SHORT).show();


                    Name.setText(profile.getName());
                    Login.setText(profile.getLogin());
                    Htmlurl.setText(profile.getHtmlUrl());
                    Company.setText(profile.getCompany());
                    Location.setText(profile.getLocation());
                    Bio.setText(profile.getBio());
                    PublicRepos.setText(profile.getPublicRepos());
                    PublicGists.setText(profile.getPublicGist());
                    Followers.setText(profile.getFollowers());
                    Following.setText(profile.getFollowing());
                    Blog.setText(profile.getBlog());

//                    Glide.with(this)
//                            .load(avatarUrl)
//                            .placeholder(R.drawable.load)
//                            .into(imageView);


                    pd.hide();

                    getSupportActionBar().setTitle("Perfil GitHub");
                }

                @Override
                public void onFailure(Call<GitProfile> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    Toast.makeText(GitProfileActivity.this, "Erro ao buscar dados!", Toast.LENGTH_SHORT).show();
                    Disconnected.setVisibility(View.VISIBLE);
                    pd.hide();

                }
            });

        }catch (Exception e){
            Log.d("Error", e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void vaiParaDesafios(View v){
        Intent goDasefios = new Intent(this, PrincipalActivity.class);
        startActivity(goDasefios);

    }



}// fecha activity

