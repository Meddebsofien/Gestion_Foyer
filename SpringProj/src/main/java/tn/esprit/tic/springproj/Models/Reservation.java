package tn.esprit.tic.springproj.Models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reservation implements  Serializable {

    @Id
    private String idReservation;
    private Date anneUniv;
    private Boolean valid;

    @ManyToMany(cascade =  CascadeType.ALL,mappedBy = "ReservationEtudiant")
    private List<Etudiant> etudiantRes;


}
