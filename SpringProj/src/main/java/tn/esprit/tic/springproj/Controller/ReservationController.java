package tn.esprit.tic.springproj.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.springproj.Models.Reservation;
import tn.esprit.tic.springproj.services.IReservationService;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("reservation")

public class ReservationController {

    IReservationService resservice;

@GetMapping("getallres")
  public   List<Reservation> retrieveAllReservation(){
    return  resservice.retrieveAllReservation();
}

@PutMapping("modifierres")
   public Reservation updateReservation ( @RequestBody  Reservation res){
    Reservation r = resservice.updateReservation(res);
    return r;
}
@GetMapping("getresbyid/{idReservation}")
   public  Reservation retrieveReservation ( @PathVariable("idReservation") String idReservation){
    Reservation r = resservice.retrieveReservation(idReservation);
    return r;
}


@GetMapping("getResByAnne/{datedebut}/{dateFin}")
public List<Reservation> getReservationParAnneeUniversitaire(@PathVariable("datedebut") Date datedebut,@PathVariable("dateFin") Date dateFin){
    return resservice.getReservationParAnneeUniversitaire(datedebut,dateFin);
}

@PostMapping("ajouterResaChambreETEtudiant/{numch}/{cin}")
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant( @RequestBody  Reservation res,@PathVariable("numch") Long numch,@PathVariable("cin") long cin){
     return  resservice.ajouterReservationEtAssignerAChambreEtAEtudiant(res,numch,cin);
    }
}
