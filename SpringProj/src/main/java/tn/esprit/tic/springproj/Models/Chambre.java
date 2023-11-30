package tn.esprit.tic.springproj.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "blocch")
@EqualsAndHashCode
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChambre;
    private long numeroChambre;
    @Enumerated(EnumType.STRING)
    private  TypeChambre type;

    @ManyToOne
    @JsonBackReference
    private Bloc blocch;

    @OneToMany
    private List<Reservation> ReservationsChambre;



}
