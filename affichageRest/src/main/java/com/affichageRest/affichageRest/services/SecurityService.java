package com.affichageRest.affichageRest.services;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String nom,String mdp);
}
