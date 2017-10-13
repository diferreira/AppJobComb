package br.com.fiap.appjobcomb.Modelo;

import com.google.gson.annotations.Expose;

/**
 * Created by Jesse on 10/11/2017.
 */

public class ItemResponseGit {

    @Expose
    private GitProfile profile;

    public GitProfile getProfile() {
        return profile;
    }

    public void setProfile(GitProfile profile) {
        this.profile = profile;
    }
}
