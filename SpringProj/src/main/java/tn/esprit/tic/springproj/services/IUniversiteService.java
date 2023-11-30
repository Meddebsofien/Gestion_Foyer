package tn.esprit.tic.springproj.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tic.springproj.Models.Universite;

import java.util.List;

public interface IUniversiteService {

    List<Universite> retrieveAllUniversities();
    Universite addUniversity (Universite u);
    Universite updateUniversity (Universite u);
    Universite retrieveUniversity (long idUniversity);
    void removeUniversity  (long idUniversity );



    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;
     public Universite desaffecterFoyerAUniversite (long idFoyer, long idUniversite) ;
}
