package tn.esprit.tic.springproj.Controller;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.springproj.Models.Etudiant;
import tn.esprit.tic.springproj.services.EtudiantService;
import tn.esprit.tic.springproj.services.IEtudiantService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantController {



    IEtudiantService Es;


    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getAllEtudiants() {
        return Es.retrieveAllEtudiants();
    }

    @PostMapping("/add-etudiant")
    public  Etudiant addEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = Es.addEtudiant(e);
        return etudiant;
    }
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
        return Es.retrieveEtudiant(etudiantId);
    }

    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
        Es.removeEtudiant(etudiantId);
    }


    @PostMapping("/affecterEtudARes/{nomEt}/{prenomEt}/{idReservation}")
    @ResponseBody
    public Etudiant affecterEtudiantAReservation( @PathVariable("nomEt")  String nomEt,@PathVariable("prenomEt") String prenomEt,@PathVariable("idReservation") String idReservation){
        Etudiant etudiant = Es.affecterEtudiantAReservation(nomEt,prenomEt,idReservation);
        return etudiant;
    }


}
