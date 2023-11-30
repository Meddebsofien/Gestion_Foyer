package tn.esprit.tic.springproj.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tic.springproj.Models.Universite;

public interface UniversiteRepository extends JpaRepository<Universite,Long> {


    @Query("select u from Universite u where u.nomUniversite = :universite")
    Universite RecuperebyNomUniversite(@Param("universite") String universite  );

}
