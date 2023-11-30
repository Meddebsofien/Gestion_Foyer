package tn.esprit.tic.springproj.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tic.springproj.Models.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,String> {

    @Query("select r from Reservation  r where r.idReservation=:res")
    Reservation getResbyidRes(@Param("res") String res);

    @Query("select r from  Reservation r where r.anneUniv between :date1 and :date2")
    List<Reservation> getReservationsBetweenDates(@Param("date1") String date1, @Param("date2") String date2);
}
