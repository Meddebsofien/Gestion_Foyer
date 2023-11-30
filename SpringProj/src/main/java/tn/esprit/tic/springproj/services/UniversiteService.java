package tn.esprit.tic.springproj.services;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import tn.esprit.tic.springproj.Models.Foyer;
import tn.esprit.tic.springproj.Models.Universite;
import tn.esprit.tic.springproj.Repository.FoyerRepository;
import tn.esprit.tic.springproj.Repository.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteService implements  IUniversiteService{

   UniversiteRepository ur;
   FoyerRepository fr;




    @Override
    public List<Universite> retrieveAllUniversities() {
        return ur.findAll();
    }

    @Override
    public Universite addUniversity(Universite u) {
        return ur.save(u);
    }

    @Override
    public Universite updateUniversity(Universite u) {
        return ur.save(u);
    }

    @Override
    public Universite retrieveUniversity(long idUniversity) {
        return ur.findById(idUniversity).get();
    }

    @Override
    public void removeUniversity(long idUniversity) {
        ur.deleteById(idUniversity);

    }



    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {

        Foyer foyer = fr.findById(idFoyer).get();

        Universite univer = ur.RecuperebyNomUniversite(nomUniversite);

        univer.setFoyer(foyer);
         ur.save(univer);

         return  univer;

    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idFoyer, long idUniversite) {
        Foyer foyer = fr.findById(idFoyer).get();
        Universite universite = ur.findById(idUniversite).get();
        if(universite.getFoyer().getIdFoyer() == idFoyer ){
            universite.setFoyer(null);
        }

         ur.save(universite);

        return universite;

    }
}
