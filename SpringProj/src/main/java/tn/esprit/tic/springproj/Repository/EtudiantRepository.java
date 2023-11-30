package tn.esprit.tic.springproj.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tic.springproj.Models.Etudiant;
public interface EtudiantRepository    extends JpaRepository<Etudiant,Long> {

    @Query("select e from Etudiant  e where  e.nomEt=:nom And e.prenomEt=:prenom")
    Etudiant getEtudiantbynomprenom(@Param("nom") String nom , @Param("prenom") String prenom);

    @Query("select e from Etudiant  e where  e.cin=:cin ")
    Etudiant getEtudiantbycin(@Param("cin") Long cin );

}
