package com.boot.demo.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query
    Collection<Reservation> findByReservationName (@Param("rn") String rn);

}
