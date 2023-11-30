package tn.esprit.tic.springproj.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Etudiant implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;
    private String nomEt;
    private String prenomEt;
    private  long cin;
    private String Ecole;


    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @ManyToMany (cascade = CascadeType.ALL )
    @JsonIgnore
    private List<Reservation> ReservationEtudiant;



}
