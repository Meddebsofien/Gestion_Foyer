package tn.esprit.tic.springproj.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.springproj.Models.Universite;
import tn.esprit.tic.springproj.services.IUniversiteService;
import tn.esprit.tic.springproj.services.UniversiteService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteController {
    IUniversiteService  us;


 @GetMapping("/afficher")
  public  List<Universite> afficherUniversites(){
     return  us.retrieveAllUniversities();

 }
 @PostMapping("/add-universite")
 public  Universite addUniversity (@RequestBody Universite u){
     Universite univer = us.addUniversity(u);
     return  univer;

 }
 @PutMapping("/modifier")
 public   Universite updateUniversity ( @RequestBody Universite u){
     return  us.updateUniversity(u);

 }
 @GetMapping("/getuniversitebyid/{idu}")
 public   Universite retrieveUniversity ( @PathVariable("idu") long idu){
     return  us.retrieveUniversity(idu);

 }
 @DeleteMapping("/supprimer-univ/{id}")
 public  void removeUniversity  (@PathVariable("id") long id ){
     us.removeUniversity(id);

 }




    @PutMapping("affecter-foyer-universite/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite(@PathVariable("idFoyer") long idFoyer, @PathVariable("nomUniversite") String nomUniversite){
        return   us.affecterFoyerAUniversite(idFoyer,nomUniversite);

    }

    @PutMapping("desaffecter-foyer-universite/{idFoyer}/{idUniversite}")
    public Universite deaffecterFoyerAUniversite(@PathVariable("idFoyer") long idFoyer, @PathVariable("idUniversite") Long idUniversite){
        return   us.desaffecterFoyerAUniversite(idFoyer,idUniversite);

    }


}
