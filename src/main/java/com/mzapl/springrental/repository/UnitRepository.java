package com.mzapl.springrental.repository;

import com.mzapl.springrental.model.Archetype;
import com.mzapl.springrental.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {

    List<Unit> findAllByArchetype(Archetype archetype);
    List<Unit> findAllByArchetype_Id(Long id);
    Optional<Unit> findById(Long id);
}
