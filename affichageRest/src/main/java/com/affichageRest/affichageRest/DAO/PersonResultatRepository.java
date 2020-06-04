package com.affichageRest.affichageRest.DAO;

import com.affichageRest.affichageRest.DTO.PersonResultatGetDTO;
import com.affichageRest.affichageRest.model.Person;
import com.affichageRest.affichageRest.model.PersonResultat;
import com.affichageRest.affichageRest.model.PersonResultatPK;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PersonResultatRepository extends JpaRepository<PersonResultat, PersonResultatPK> {

    @Type(type="pg-uuid")
    @Query("select u from PersonResultat u  where u.personResultatPK.idPerson  = :uuid ")
    List<PersonResultat> findByPerson(@Param("uuid") UUID person);
}


