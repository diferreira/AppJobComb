package br.com.fiap.appjobcomb.api;


import br.com.fiap.appjobcomb.Modelo.GitProfile;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Jesse on 10/11/2017.
 */

public interface GitService {
    @GET("users/jesselima")
    Call <GitProfile> getProfile();
}
