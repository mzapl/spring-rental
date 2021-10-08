package com.mzapl.springrental.repository;

import com.mzapl.springrental.model.Archetype;
import com.mzapl.springrental.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {

    List<Unit> findAllByArchetype(Archetype archetype);
    List<Unit> findAllByArchetype_Id(Long id);
}
