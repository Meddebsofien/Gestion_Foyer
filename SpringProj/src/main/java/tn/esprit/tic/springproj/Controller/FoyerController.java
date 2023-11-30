package tn.esprit.tic.springproj.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.springproj.Models.Foyer;
import tn.esprit.tic.springproj.Repository.FoyerRepository;
import tn.esprit.tic.springproj.services.FoyerService;
import tn.esprit.tic.springproj.services.IFoyerService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("foyer")
public class FoyerController {

    IFoyerService foyerservice;
    FoyerRepository fr;

@GetMapping("getAllFoyer")
   public  List<Foyer> getAllFoyer(){
       return  foyerservice.retrieveAllFoyers();
   }

   @PostMapping("ajouterfoyer")
    public  Foyer addFoyer ( @RequestBody  Foyer f){

    Foyer foyer = foyerservice.addFoyer(f);
    return  foyer;

    }
    @PutMapping("updatefoyer")
    public Foyer updateFoyer ( @RequestBody Foyer f){
    Foyer foyer = foyerservice.updateFoyer(f);
    return  foyer;
    }


    @GetMapping("getfoyerbyid/{idf}")
    public Foyer getfoyerbyid ( @PathVariable("idf")  long idf){
    return foyerservice.retrieveFoyer(idf);

    }

    @PutMapping("archiver/{idFoyer}")
    public  Foyer archiverFoyer ( @PathVariable("idFoyer")  long idFoyer){
    //Foyer fo = fr.findById(idFoyer).get();
     Foyer fo = foyerservice.archiverFoyer(idFoyer);
    return  fo;

    }

    @PostMapping("/addFoyerWithBloc")
    @ResponseBody
    public Foyer addFoyerWithBloc( @RequestBody Foyer f) {
    Foyer foyer = foyerservice.addFoyerWithBloc(f);
     return  foyer;

    }
}
