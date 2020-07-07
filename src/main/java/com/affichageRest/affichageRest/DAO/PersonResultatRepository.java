package com.affichageRest.affichageRest.DAO;

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
    @Query(value="select * " +
            "from resultat \n" +
            "where person_id = :uuid ", nativeQuery = true)
    List<PersonResultat> findByPerson(@Param("uuid") UUID person);

    List<PersonResultat> findByPersonResultatPK_IdCoursContaining(UUID idCours);
}


